<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'uploadphoto.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/bootstrap.min.css " rel="stylesheet">
	<link href="css/google.bootstrap.min.css " rel="stylesheet">
	<script>
	<%if(request.getAttribute("photo_update")=="true"){ %>alert("photo updated");
	<%}else if(request.getAttribute("photo_update")=="false"){ %>
	alert("photo updated");
	<%}%>
	</script>
	
	
	<style>
	.ex
	{
	position:absolute;
	left:5%;
	top:10%;
	}
	.a
	{background-color:#d9edf7;
	border-left-color:green;
	border-left-width:3px;}
	</style>
  </head>
  
  <body class="ex">
  
  <h4 class="text-primary"><strong>Upload Profile Photo</strong></h4>
        
                	<div class="a alert">
        	    <strong>Please ensure the following points before uploading new profile picture.</strong>
        	    <ul>
        	    	<li>Image must be sharp and clear.</li>
        	    	<li>Image must be properly cropped after uploading.</li>
        	    	<li>Image must maintain appropriate aspect ratio. Do not stretch or compress the dimensions of the image.</li>
        	    	<li>Do not upload black & white image.</li>
        	    	  <li>Only <strong>jpg or jpeg or png </strong> formats are allowed.</li>
                <li>Please note that maximum allowed file size is <strong>3 MB</strong> </li>
                <li>Maximum width of picture is <strong>1500 px. (recommended 1024 px)</strong></li>
                <li>Maximum height of picture is <strong>1500 px. (recommended 789 px)</strong></li>

        	    </ul>
        	</div>
            
            <form class="form" name="photo" action="UploadPhoto" enctype="multipart/form-data" method="post" id="crop-button">
              <div class="form-group">
                 <label for="">Select Image</label> 
				 <input type="file" id="fileChooser" name="image" size="30"/>
             </div>
             <div class="form-group">
                <button type="submit" name="upload" class="btn btn-primary" onclick="return ValidateFileUpload()" value="Upload"><span class="fa fa-user"></span> Upload</button>
            </div>
        </form>
		<SCRIPT type="text/javascript">
    function ValidateFileUpload() {
        var fuData = document.getElementById('fileChooser');
        var FileUploadPath = fuData.value;

//To check if user upload any file
        if (FileUploadPath == '') 
		{
            alert("Please upload an image");
			return false;
        } else 
		{
            var Extension = FileUploadPath.substring(
                    FileUploadPath.lastIndexOf('.') + 1).toLowerCase();

//The file uploaded is an image

if ( Extension == "png"|| Extension == "jpeg" || Extension == "jpg")
					{
						
						//file size verified
						if(fuData.files[0].size<3000000)
						{
							if(fuData.files[0].getWidth()<=1500)                                //change starts here
							{
								if(fuData.files[0].getHeight()<=1500)
									return true;
									else
									{
										alert("ensure height to be less than 1500 pixels ");
										return false;
									}
							}
							else
							 {
									alert("ensure width to be less than 1500 pixels ");
									return false;
							 }				
						}
						else
						{
							alert("file is too large");
							return false;
						}
					}



//The file upload is NOT an image
else {
                alert("Photo only allows file types of PNG, JPG, JPEG. ");
				return false;

            }
        }
    }
</SCRIPT>
  </body>
</html>
