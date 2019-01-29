package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import databases.EmpDetailsDao;
import databases.ProjectDetailsDao;
import objects.EmpPar;
@WebServlet("/addproject")
public class AddProject extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String e_id=(String)session.getAttribute("emp_email");
		
		
		String t_id=request.getParameter("t_id");
		
		String p_name=request.getParameter("p_name");
		
		if(ProjectDetailsDao.Check_emp_project_table(p_name)||p_name.equals(""))
		{
			request.setAttribute("project_insert", "false");
			RequestDispatcher rd = request.getRequestDispatcher("jsp/presentprojects.jsp");
			rd.forward(request, response);
		}
		else{
		int f=0;
		ProjectDetailsDao.insert_in_project_table(p_name);
		System.out.print("team leader "+t_id);
		if(ProjectDetailsDao.insert_in_emp_project_table(e_id,p_name)==1&&ProjectDetailsDao.insert_in_emp_project_table(t_id,p_name)==1)
		{
			request.setAttribute("project_update", "true");
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/presentprojects.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("project_update", "false");
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/presentprojects.jsp");
			rd.forward(request, response);
		}
	}}
}

