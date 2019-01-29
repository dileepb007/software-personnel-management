package servlets;

import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import databases.ProjectDetailsDao;
import databases.UploadfileDao;
import databases.UploadphotoDao;
@WebServlet("/fileupload")
public class FileUpload extends HttpServlet {

	
	int flag=0;
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		DiskFileItemFactory factory = new DiskFileItemFactory();
	    String contextRoot = getServletContext().getRealPath("/");

	    factory.setRepository(new File(contextRoot));
	    ServletFileUpload upload = new ServletFileUpload(factory);
	    
	    String project_name="";
	    
	   
	    try {
	        List<FileItem> items = upload.parseRequest(request);
	        
	        for (FileItem item : items) {
	        	if (item.isFormField()) {
	                // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
	                String fieldName = item.getFieldName();
	                String fieldValue = item.getString();
	                project_name=fieldValue;
	                if(flag==0)
	                {
	                	if(UploadfileDao.check_project(project_name))
	                    {
	                    	UploadfileDao.delete_file(project_name);
	                    	//System.out.println(flag);
	                    }
	                	flag++;
	                }
	            } 
	        	else 
	            {
	                // Process form file field (input type="file").
	               /* System.out.println("Field name: " + item.getFieldName());
	                System.out.println("File name: " + item.getName());
	                System.out.println("File size: " + item.getSize());
	                System.out.println("File type: " + item.getContentType());*/
	            	//System.out.println("File name: " + item.getName());
	                String fileName = item.getName();
	                try {
	                    String uploadFolder = getServletContext().getRealPath("") + "projects";
	                    String filePath = uploadFolder + File.separator +fileName;
	                    //System.out.println(filePath);
	                    File saveFile = new File(filePath);                        
	                    saveFile.createNewFile();
	                    item.write(saveFile); 
	                    
	                    String emp_id = (String)session.getAttribute("emp_email");
	                    
	                   /* if(!ProjectDetailsDao.Check_pro_in_emp_project_table(project_name,emp_id))
	                    {
	                    	System.out.println("hi2");
	                    	 request.setAttribute("project_update", "false");
	                     	RequestDispatcher rd = request.getRequestDispatcher("jsp/fileupload.jsp");
	                 		
	                 		rd.forward(request, response);
	                    } 
	                    else */
	                    {System.out.println("hi");
	                    	if(UploadfileDao.insert_file(project_name,fileName,emp_id)>=1)
		                    {
		                    	System.out.println("uploaded");
		                    	
		                    }
		                    else
		                    {
		                    	System.out.println(" not uploaded");
		                    	
		                    }
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
	    request.setAttribute("project_update", "true");
    	RequestDispatcher rd = request.getRequestDispatcher("jsp/fileupload.jsp");
		
		rd.forward(request, response);

	}


}
