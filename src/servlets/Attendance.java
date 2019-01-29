package servlets;

import java.util.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import objects.EmpDetails;

/**
 * Servlet implementation class Attendance
 */
@WebServlet("/Attendance")
public class Attendance extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
			HttpSession session = request.getSession();
			
			String email=(String)session.getAttribute("emp_email");
			//String email="pprasannasai@yahoo.com";
			String sql1="select * from e_attendance where flag=1 and email='"+email+"'";
			PreparedStatement stmt=con.prepareStatement(sql1);
			ResultSet rs=stmt.executeQuery(sql1);
			
			int count=0;
			
			while(rs.next())
			{
				count++;
			}
			
			System.out.println(count);
			if(count==0)
			{
				Timestamp t=new Timestamp(System.currentTimeMillis());
				System.out.println("Timestamp.");
				System.out.println(t);
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
				String sql="insert into e_attendance(email,enter,leave,flag,ent,lea) values('"+email+"','"+t.getDate()+"-"+s[m]+"-"+t.getYear()+" "+h+":"+t.getMinutes()+":"+t.getSeconds()+"','"+t.getDate()+"-"+s[m]+"-"+t.getYear()+" "+h+":"+t.getMinutes()+":"+t.getSeconds()+"',"+ent+","+ent+",1)";	
				System.out.println(email+"Email");
				System.out.println(sql);
				
				stmt=con.prepareStatement(sql);
				int b=stmt.executeUpdate();
				if(b>0)
					System.out.println("inserted");
			}
			else
			System.out.println("Already checked in");
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		request.setAttribute("checkedin", "true");
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/attendance.jsp");
	
		rd.forward(request, response);
		
		
	}

}