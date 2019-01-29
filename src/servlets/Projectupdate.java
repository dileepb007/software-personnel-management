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
import databases.ProjectDetailsDao;
import objects.EmpProj;
@WebServlet("/update")
public class Projectupdate extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		ArrayList<String> names = EmpDetailsDao.get_all_downline((String)session.getAttribute("emp_email"));
		names.add((String)session.getAttribute("emp_email"));
		System.out.print(names.toString());
		for(int i=0;i<names.size();i++){
		ArrayList<EmpProj> proj = ProjectDetailsDao.get_from_emp_project_table(names.get(i));
		for(int j=0;j<proj.size();j++){
			EmpProj obj=proj.get(j);
			
			if(ProjectDetailsDao.update_in_emp_project_table(obj.getEmp_id(),obj.getP_name(),request.getParameter("m"+obj.getEmp_id()+obj.getP_name()),request.getParameter("p"+obj.getEmp_id()+obj.getP_name()))>=1)
			{

				request.setAttribute("project_updated", "true");
				RequestDispatcher rd = request.getRequestDispatcher("jsp/presentprojects.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("project_updated", "false");
				RequestDispatcher rd = request.getRequestDispatcher("jsp/presentprojects.jsp");
				rd.forward(request, response);
			}
		}
	}

}}
