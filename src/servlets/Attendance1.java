package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Attendance1
 */
@WebServlet("/Attendance1")
public class Attendance1 extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
			HttpSession session = request.getSession();
			
			String email=(String)session.getAttribute("emp_email");
			//String email="pprasannasai@yahoo.com";
			
			Timestamp t=new Timestamp(System.currentTimeMillis());
			int ent=0;
			int h;
			h=t.getHours();
			if(t.getHours()>=12)
			{
				h=t.getHours()-12;
				ent=1;
			}
			int m=t.getMonth();
			String s[]={"jan","feb","mar","apr","may","jun","jul","aug","sep","oct","nov","dec"};
			String sql="update e_attendance set leave='"+t.getDate()+"-"+s[m]+"-"+t.getYear()+" "+h+":"+t.getMinutes()+":"+t.getSeconds()+"', flag=0, lea="+ent+" where email='"+email+"' and flag=1";
			//String sql="update e_attendance set flag=0 where email='"+email+"' and flag=1";
			
			System.out.println(sql);
			PreparedStatement stmt=con.prepareStatement(sql);
			//Boolean b=stmt.execute(sql);
			int m1=stmt.executeUpdate();
			if(m1>0)
				System.out.println("updated");
			else
				System.out.println("not updated");
		}
		catch(Exception e)
		{
			System.out.println("in attendance 1");
			e.printStackTrace();
		}
		
		request.setAttribute("checkedout", "true");
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/attendance.jsp");
	
		rd.forward(request, response);
	}

}