package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import databases.Connect;
import databases.Payroll1;

/**
 * Servlet implementation class Payroll
 */
@WebServlet("/Payroll")
public class Payroll extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		try
		{
			System.out.println((String)session.getAttribute("emp_email"));
			Double pay=Payroll1.retrieve_attr((String)session.getAttribute("emp_email"), request.getParameter("from"), request.getParameter("to"));
			request.setAttribute("Pay", pay);
		}
		catch(Exception e)
		{
			System.out.println("In payroll");
			e.printStackTrace();
		}
		
		request.setAttribute("payroll", "true");
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/payroll.jsp");
	
		rd.forward(request, response);
	}

}