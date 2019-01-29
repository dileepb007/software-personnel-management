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

import databases.EmpDetailsDao;
import objects.EmpDetails;
@WebServlet("/Editprofile")
public class Editprofile extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EmpDetails details = new EmpDetails();
		
		details.setFname(request.getParameter("firstname"));
		details.setLname(request.getParameter("lastname"));
		details.setMobile(request.getParameter("mobile"));
		details.setEmail(request.getParameter("email"));
		details.setDob(request.getParameter("dob"));
		details.setGender(request.getParameter("gender"));
		details.setPosition(request.getParameter("position"));
		details.setAddress(request.getParameter("address"));
		details.setCity(request.getParameter("city"));
		details.setState(request.getParameter("state"));
		details.setPincode(request.getParameter("pincode"));
		details.setCountry(request.getParameter("country"));
		details.setResume(request.getParameter("resume"));
		
		/*String d=details.getDob();
		
		d=d.replaceAll("/01/","-jan-");
		d=d.replaceAll("/02/","-feb-");
		d=d.replaceAll("/03/","-mar-");
		d=d.replaceAll("/04/","-apr-");
		d=d.replaceAll("/05/","-may-");
		d=d.replaceAll("/06/","-jun-");
		d=d.replaceAll("/07/","-jul-");
		d=d.replaceAll("/08/","-aug-");
		d=d.replaceAll("/09/","-sep-");
		d=d.replaceAll("/10/","-oct-");
		d=d.replaceAll("/11/","-nov-");
		d=d.replaceAll("/12/","-dec-");
		details.setDob(d);*/
		if(EmpDetailsDao.insert_to_reg_table(details)==1)
		{
			request.setAttribute("updated", "true");
			HttpSession session = request.getSession();
			session.removeAttribute("emp_details");
			session.setAttribute("emp_details",details);
			RequestDispatcher rd = request.getRequestDispatcher("jsp/editprofile.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("updated", "false");
			RequestDispatcher rd = request.getRequestDispatcher("jsp/editprofile.jsp");
			rd.forward(request, response);
		}
		
	}

	

}
