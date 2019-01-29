package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import databases.EmpDetailsDao;
import databases.LoginDao;
import objects.EmpDetails;
@WebServlet("/remove")
public class Remove extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		ArrayList<String> names = EmpDetailsDao.get_all_downline((String)session.getAttribute("emp_email"));
		
		ArrayList<EmpDetails> det = EmpDetailsDao.get_all_downline_details(names);
		String[] s=request.getParameterValues("checkedRows");
		System.out.println(s[0]);
		for(int i=0;i<s.length;i++)
		{
			
			EmpDetails obj = new EmpDetails();
			obj.setEmail(s[i]);
			
			
			
				LoginDao.delete_in_login_table(obj.getEmail());
				EmpDetailsDao.delete_from_reg_table(obj.getEmail());
				EmpDetailsDao.delete_from_hierarchy_table(obj.getEmail());
				System.out.println(obj.getEmail()+"yes");
			
		}
		
		request.setAttribute("remove", "true");
		RequestDispatcher rd = request.getRequestDispatcher("jsp/downline.jsp");
		rd.forward(request, response);
	}

}
