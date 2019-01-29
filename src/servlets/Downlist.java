package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databases.EmpDetailsDao;

public class Downlist extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String e_id=request.getParameter("e_id");
		
		
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/presentprojects.jsp");
		rd.forward(request, response);
	}


}
