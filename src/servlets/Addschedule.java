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

import databases.AddDate;
@WebServlet("/addschedule")
public class Addschedule extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	HttpSession session = request.getSession();
	
	String emp_id=(String)session.getAttribute("emp_email");
	String s_date=request.getParameter("date");
	String from_h=request.getParameter("from_h");
	String from_m=request.getParameter("from_m");
	String to_h=request.getParameter("to_h");
	String to_m=request.getParameter("to_m");
	String event=request.getParameter("event");
	int f=0;
	if(AddDate.get_from_schedule_table(emp_id, event))
	{
		f++;
		request.setAttribute("present", "true");
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/schedule.jsp");
		rd.forward(request, response);
	}
	if(f==0){
	if(AddDate.insert_to_schedule_table(emp_id, s_date, Integer.parseInt(from_h), Integer.parseInt(from_m),Integer.parseInt(to_h),Integer.parseInt(to_m) , event)==1)
	{
		request.setAttribute("added", "true");
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/schedule.jsp");
		rd.forward(request, response);
	}
	else
	{
request.setAttribute("added", "false");
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/schedule.jsp");
		rd.forward(request, response);
	}
	}}

}
