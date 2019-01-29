package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import databases.Connect;

/**
 * Servlet implementation class Dates
 */
@WebServlet("/Dates")
public class Dates extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		try {
			ResultSet rs=Connect.retrieve_att((String)session.getAttribute("emp_email"), request.getParameter("from"), request.getParameter("to"));
			request.setAttribute("Result_att", rs);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("viewattendance", "true");
		System.out.println(request.getParameter("from")+"Fromdate");
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/attendance.jsp");
		
		rd.forward(request, response);
	}

}