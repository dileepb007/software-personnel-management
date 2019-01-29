package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import databases.LoginDao;
import methods.Verifysignup;
import objects.Employee;
import objects.EmployeeObj;

/**
 * Servlet implementation class Verify
 */
@WebServlet("/Verify")
public class Verify extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeObj obj = new EmployeeObj();
		
		obj.setF_name(request.getParameter("f_name").toString());
		obj.setL_name(request.getParameter("l_name").toString());
		obj.setGender(request.getParameter("gender").toString());
		obj.setEmail(request.getParameter("email").toString());
		obj.setMobile(request.getParameter("mobile").toString());
		obj.setPswd(request.getParameter("password").toString());
		obj.setC_pswd(request.getParameter("c_password").toString());
		obj.setPos(request.getParameter("position").toString());
		
		
	
		
		if(Verifysignup.verifyF_name(obj.getF_name())==false)
		{
			request.setAttribute("f_name_bool", false);
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
			
			rd.forward(request, response);
		}
		
		if(Verifysignup.verifyL_name(obj.getL_name())==false)
		{
			request.setAttribute("l_name_bool", false);
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
			
			rd.forward(request, response);
		}
		
		if(Verifysignup.verifyGender(obj.getGender())==false)
		{
			
			request.setAttribute("gender_bool", "false");
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
			
			rd.forward(request, response);
		}
		
		if(Verifysignup.verifyEmail(obj.getEmail())==false)
		{
			
			request.setAttribute("email_bool", "false");
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
			
			rd.forward(request, response);
		}
		
		if(Verifysignup.verifyMobile(obj.getMobile())==false)
		{
			
			request.setAttribute("mobile_bool", "false");
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
			
			rd.forward(request, response);
		}
		
		if(Verifysignup.verifyPassword(obj.getPswd())==false)
		{
			
			request.setAttribute("pswd_bool", "false");
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
			
			rd.forward(request, response);
		}
		
		if(Verifysignup.verifyC_Password(obj.getPswd(),obj.getC_pswd())==false)
		{
			
			request.setAttribute("c_pswd_bool", "false");
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
			
			rd.forward(request, response);
		}
		
		if(Verifysignup.verifyPosition(obj.getPos())==false)
		{
			
			request.setAttribute("position_bool", "false");
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
			
			rd.forward(request, response);
		}
		
		//check email in database
		
		if(LoginDao.Check_reg_table(obj.getEmail()))
		{
			request.setAttribute("registered_bool", "false");
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
			
			rd.forward(request, response);
		}
		else
		{
			LoginDao.insert_to_reg_table(obj);
			
			request.setAttribute("registered_bool", "true");
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
			
			rd.forward(request, response);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Employee emp = new Employee();
		
		emp.setEmail(request.getParameter("email_login").toString());
		emp.setPswd(request.getParameter("password_login").toString());
		
		if(LoginDao.check_in_login_table(emp))
		{
			HttpSession session = request.getSession();
			session.setAttribute("emp_email", emp.getEmail());
			session.setAttribute("emp_pswd", emp.getPswd());
			
			session.setAttribute("emp_details",LoginDao.get_empdetails_table(emp));
			response.sendRedirect("jsp/userprofile.jsp");
		}
		else
		{
			request.setAttribute("id_bool", "false");
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
			
			rd.forward(request, response);
		}
	
	
	}
}
