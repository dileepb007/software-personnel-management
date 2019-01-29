<%@page import="databases.UploadphotoDao"%>
<%@page import="objects.EmpDetails"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
  	<%EmpDetails emp_details = (EmpDetails)session.getAttribute("emp_details");%>  
  	<%-- <%System.out.println(emp_details.toString()); %> --%>
    <title>userprofile</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="Glance Design Dashboard Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
	SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

	<!-- Bootstrap Core CSS -->
	<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />

	<!-- Custom CSS -->
	<link href="css/style.css" rel='stylesheet' type='text/css' />

	<!-- font-awesome icons CSS -->
	<link href="css/font-awesome.css" rel="stylesheet"> 
	<!-- //font-awesome icons CSS-->

	<!-- side nav css file -->
	<link href='css/SidebarNav.min.css' media='all' rel='stylesheet' type='text/css'/>
	<!-- //side nav css file -->
	<!-- js-->
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/modernizr.custom.js"></script>
	
	<!--webfonts-->
	<link href="//fonts.googleapis.com/css?family=PT+Sans:400,400i,700,700i&amp;subset=cyrillic,cyrillic-ext,latin-ext" rel="stylesheet">
	<!--//webfonts-->
  </head>
  
  <body class="cbp-spmenu-push">
	<div class="main-content">
	<div class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
		<!--left-fixed -navigation-->
		<aside class="sidebar-left">
      	<nav class="navbar navbar-inverse">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".collapse" aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            </button>
            <h1><a class="navbar-brand" href="jsp/userprofile.jsp"><span class="fa fa-area-chart"></span>DIPSUB<span class="dashboard_text">Employee Page</span></a></h1>
          </div>
          <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="sidebar-menu">
               <li class="treeview">
                <a href="jsp/userprofile.jsp">
                <i class="fa fa-home"></i> <span>HOME</span>
                </a>
              </li>
             <li class="treeview">
                <a href="jsp/editprofile.jsp" target="myframe">
                <i class="fa fa-user circle"></i> <span>Profile</span>
                </a>
              </li>
              <li class="treeview">
                <a href="jsp/uploadphoto.jsp" target="myframe">
                <i class="fa fa-picture-o"></i> <span>Upload Photo</span>
                </a>
              </li>
			  <li class="treeview">
                <a href="jsp/attendance.jsp" target="myframe">
                <i class="fa fa-pie-chart"></i><span>Attendance</span>
                </a>
              </li>
			    <li class="treeview">
                <a href="#">
                <i class="fa fa-folder"></i>
                <span>Documents</span>
                <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                  <li><a href="jsp/fileupload.jsp" target="myframe"><i class="fa fa-angle-right"></i>Upload Documents</a></li>
                  <li><a href="jsp/viewdocs.jsp" target="myframe"><i class="fa fa-angle-right"></i>View documents</a></li>
                </ul>
              </li>
			    <li class="treeview">
                <a href="#">
                <i class="fa fa-inr"></i><span>Payroll</span></a>				
              </li>
			    <li class="treeview">
                <a href="#">
                <i class="fa fa-book"></i>
                <span>Projects</span>
                <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                  <li><a href="jsp/presentprojects.jsp" target="myframe"><i class="fa fa-angle-right"></i>Running Projects</a></li>
                  <li><a href="jsp/pastprojects.jsp" target="myframe"><i class="fa fa-angle-right"></i> Past Projects</a></li>
                </ul>
              </li>
              
			    <li class="treeview">
                <a href="jsp/schedule.jsp" target="myframe">
                <i class="fa fa-calendar-check-o"></i><span>Schedule</span></a>
               </li>
               <%if(!emp_details.getPosition().equals("software_employee")){ %>
			    <li class="treeview" >
                <a href="jsp/downline.jsp" target="myframe">
                <i class="fa fa-users"></i><span>Downlines</span></a>
               </li><%}%>
               <%if(emp_details.getPosition().equals("administrator")){ %>
			    <li class="treeview" >
                <a href="jsp/registered.jsp" target="myframe">
                <i class="fa fa-edit"></i><span>Registered employees</span></a>
               </li><%}%>
            </ul>
          </div>
          <!-- /.navbar-collapse -->
      </nav>
    </aside>
	</div>
	
	<!--left-fixed -navigation-->
		
		<!-- header-starts -->
		<div class="sticky-header header-section ">
			<div class="header-right">
			<div class="profile_details">		
					<ul>
						<li class="dropdown profile_details_drop">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
								<div class="profile_img">	
									<span class="prfil-img"><img src="<%="images/"+UploadphotoDao.get_photo((String)session.getAttribute("emp_email")) %>" width="50" height="50" alt=""> </span> 
									<div class="user-name">
										<p><%=session.getAttribute("emp_email") %></p>
										<span><%=emp_details.getPosition()%></span>
									</div>
									<i class="fa fa-angle-down lnr"></i>
									<i class="fa fa-angle-up lnr"></i>
									<div class="clearfix"></div>	
								</div>	
							</a>
							<ul class="dropdown-menu drp-mnu">
								<form action="Logout" method="post"> 
								<button type="submit" style="background-color: Transparent;border: none;cursor:pointer;"><li> <a href="jsp/login.jsp"><i class="fa fa-sign-out"></i> Logout</a> </li>
								</form>
							</ul>
						</li>
					</ul>
				</div>
				<div class="clearfix"> </div>				
			</div>
			<div class="clearfix"> </div>	
		</div>
		
	
	  <!--main content -->
	  <div id="page-wrapper">
	    <div class="main-page" style="margin:5% 0% 0% 1%;">
	    	<iframe name="myframe" width="100%" height="93%"scrolling="auto" src="jsp/home.jsp"></iframe>
		</div></div>
	  </div>
	  
	</div>
	</div>
	
       	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
	<!--//scrolling js-->
	
	<!-- side nav js -->
	<script src='js/SidebarNav.min.js' type='text/javascript'></script>
	<script>
      $('.sidebar-menu').SidebarNav()
    </script>
	<!-- //side nav js --> 
 </script>
	<!-- new added graphs chart js-->
	 <script src="js/bootstrap.js"> </script>
	 
   </body>
</html>
