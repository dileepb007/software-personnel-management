package servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import databases.UploadphotoDao;
@WebServlet("/UploadPhoto")
public class UploadPhoto extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		DiskFileItemFactory factory = new DiskFileItemFactory();
	    String contextRoot = getServletContext().getRealPath("/");

	    factory.setRepository(new File(contextRoot));
	    ServletFileUpload upload = new ServletFileUpload(factory);

	    try {
	        List<FileItem> items = upload.parseRequest(request);
	        for (FileItem item : items) {
	            if (!item.isFormField()) {
	                // Process form file field (input type="file").
	               /* System.out.println("Field name: " + item.getFieldName());
	                System.out.println("File name: " + item.getName());
	                System.out.println("File size: " + item.getSize());
	                System.out.println("File type: " + item.getContentType());*/

	                String fileName = item.getName();
	                try {
	                    String uploadFolder = getServletContext().getRealPath("") + "images";
	                    String filePath = uploadFolder + File.separator +session.getAttribute("emp_email") +fileName;
	                    fileName=session.getAttribute("emp_email") +fileName;
	                    System.out.println(filePath);
	                    File saveFile = new File(filePath);                        
	                    saveFile.createNewFile();
	                    item.write(saveFile); 
	                    if(UploadphotoDao.insert_photo((String)session.getAttribute("emp_email"),fileName)==1)
	                    {
	                    	request.setAttribute("photo_update", "true");
	                    	RequestDispatcher rd = request.getRequestDispatcher("jsp/uploadphoto.jsp");
	            			
	            			rd.forward(request, response);
	                    }
	                    else
	                    {
	                    	request.setAttribute("photo_update", "false");
	                    	RequestDispatcher rd = request.getRequestDispatcher("jsp/uploadphoto.jsp");
	            			
	            			rd.forward(request, response);
	                    	
	                    }

	                } catch (Exception e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }
	            }

	        }
	    } catch (FileUploadException e) {
	        try {
	            throw new ServletException("Cannot parse multipart request.", e);
	        } catch (ServletException e1) {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	        }
	    }
		/*System.out.println("uploaded");*/
	}

	
}
