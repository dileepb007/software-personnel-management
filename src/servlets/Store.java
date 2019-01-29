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

import databases.RegisterDao;
import objects.EmployeeObj;
@WebServlet("/Store")
public class Store extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<EmployeeObj> l=RegisterDao.get_empdetails_table();
		
		for(int i=0;i<l.size();i++)
		{
			EmployeeObj o = l.get(i);
			if(request.getParameter(o.getEmail())!=null)
			{
				if(request.getParameter(o.getEmail()).toString().equals("approve"))
				{
					RegisterDao.insert_to_login_table(o);
					RegisterDao.insert_to_empdetails_table(o);
					RegisterDao.insert_to_photo_table(o.getEmail());
					System.out.println(request.getParameter("upline"));
					String name1=o.getF_name()+" "+o.getL_name();
					RegisterDao.insert_to_hierarchy_table(o.getEmail(),o.getPos(),request.getParameter("upline"), name1);
					RegisterDao.delete_from_reg_table(o.getEmail());
					
				}
				else if(request.getParameter(o.getEmail()).toString().equals("deny"))
				{
					RegisterDao.delete_from_reg_table(o.getEmail());
				}
			}
			
		}
		
		request.setAttribute("edited","true");
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/registered.jsp");
		rd.forward(request, response);
	}

	
}
