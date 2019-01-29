package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
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
@WebServlet("/assignmodules")
public class Assignmodules extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String p_name=request.getParameter("p_id");
		ArrayList<EmpPar> sed = EmpDetailsDao.get_downline((String)session.getAttribute("emp_email"));
		int f=0;
		for(int i=0;i<sed.size();i++)
		{
			EmpPar se = sed.get(i);
			if(request.getParameter(se.getE_name())!=null)
			{
				
				
					if(ProjectDetailsDao.insert_modules_in_emp_project_table(se.getE_name(), p_name,request.getParameter(se.getE_name()))==1)
					{
						
					}
					
			}
			f++;
			}
		if(f==sed.size())
		{
			request.setAttribute("module_update", "true");
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/presentprojects.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("module_update", "false");
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/presentprojects.jsp");
			rd.forward(request, response);
		}
				
		}
		
	}
