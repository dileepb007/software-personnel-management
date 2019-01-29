<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script>
	<%if(request.getAttribute("project_update")=="true"){ %>
	alert("updated successfully");
	<%}else if(request.getAttribute("project_update")=="false"){%>
	alert("project is not alloted ");
	<%}%>
	
	</script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--<title>File Upload Widget Flat Resposive Website Template | Home :: w3layouts</title>-->
	<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
	<!-- Custom Theme files -->
	<link href="css/fileupload.css" rel="stylesheet" type="text/css" media="all" />
	<!-- Custom Theme files -->
	<script src="js/jquery.min.js"></script>
	<!-- Custom Theme files -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="File Upload Widget Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
	Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		

	
	
	
  </head>
  
  <body>
	   <SCRIPT type="text/javascript">
    function ValidateFileUpload() {
//To check if user upload any file
		if($("#title").val().trim()=="")
		{
			alert("project title cannot be empty");
			return false;
		}
        /*if(document.getElementById("filechooser").value) 
        {
   				alert("file entered");
   				return true;
   			}
   				else
   				{
   					alert("enter any file");
   				return false;
   			    }
        	return true;*/
    }
</SCRIPT>
<h1>UPLOAD PROJECT DETAILS</h1>
<!--<div id="no_of_pojects">
<form id="no1">
	<input type="text" id="no2" value="Enter no of projects" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Enter no of projects';}" />
	<input type="submit" id="no3" name="Submit">
</form>
</div>-->
<div class="upload">
			<!--<h3>Select File</h3>-->
		<div class="login-form">
			<form id="upload" method="post" action="fileupload"  enctype="multipart/form-data">
				<div>
					<span>Project title :</span>
						<input type="text" id="title" class="title"required="" name="pttl" onfocus="this.value = '';" onblur="if (this.value == '')" />
				</div>
				<!--<div>
					<span>Description</span>
						<input type="text" class="describe" value="Eg: The one in the Bahamas" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Eg: The one in the Bahamas';}" />
				</div>-->
				<div id="drop">
				<a>Upload files</a>
				<input id="filechooser" type="file" name="upl" multiple />
			</div>

				
				<ul>
				<!-- The file uploads will be shown here -->
				</ul>
				<br>
				<input type="submit" name="submit" onclick="return ValidateFileUpload()" >
			</form>
		</div>
	
			
	<!-- JavaScript Includes -->
		<script src="js/jquery.knob.js"></script>
	<!-- JavaScript Includes -->

	<!-- jQuery File Upload Dependencies -->
		<script src="js/jquery.ui.widget.js"></script>
		<script src="js/jquery.iframe-transport.js"></script>
		<script src="js/jquery.fileupload.js"></script>
	<!-- jQuery File Upload Dependencies -->
		
	<!-- Main JavaScript file -->
		<script src="js/script.js"></script>
	<!-- Main JavaScript file -->
	
</div>

<!--<div class="footer">
     <p>Copyright &copy; 2015 File Upload Widget. All Rights Reserved | Design by <a href="http://w3layouts.com">W3layouts</a></p>
</div>-->
	
  </body>
</html>
