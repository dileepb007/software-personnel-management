package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import databases.Deletedate;
@WebServlet("/removeschedule")
public class RemoveSchedule extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		String emp_id=(String)session.getAttribute("emp_email");
		String[] event=request.getParameterValues("check");
		int f=0;
		for(int i=0;i<event.length;i++)
		{
			f+=Deletedate.delete_from_reg_table(emp_id, event[i]);
		}
		if(f==event.length)
		{
			
			request.setAttribute("deleted", "true");
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/schedule.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("deleted", "false");
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/schedule.jsp");
			rd.forward(request, response);
		}
	}

}
