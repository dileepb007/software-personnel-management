<%@page import="objects.EmpPar"%>
<%@page import="databases.EmpDetailsDao"%>
<%@page import="objects.EmpDetails"%>
<%@page import="databases.ProjectDetailsDao"%>
<%@page import="objects.EmpProj"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <%ArrayList<String> names = EmpDetailsDao.get_all_downline((String)session.getAttribute("emp_email"));
 names.add((String)session.getAttribute("emp_email"));
 %>
 
 
 <%EmpDetails emp_details = (EmpDetails)session.getAttribute("emp_details");%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>Projects</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>



<!--webfonts-->
<link href="//fonts.googleapis.com/css?family=PT+Sans:400,400i,700,700i&amp;subset=cyrillic,cyrillic-ext,latin-ext" rel="stylesheet">
<!--//webfonts--> 


<link href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css">
  </head>
  
<body>
	<table class="table" id="mytable" style="width:100%">
							<thead>
								<tr>
								 <th>S.no</th>
									<th>Project Name</th>
									<th>Employee ID</th>
									<th>Employee</th>
									<th>Position</th>
									<th>Module</th>
									<th>Module status</th>
									<th>Project status</th>
								</tr>
							</thead>
							<tbody>
								<%for(int i=0;i<names.size();i++){
								System.out.print("names "+names.get(i));
								ArrayList<EmpProj> proj=ProjectDetailsDao.get_pastprojects_from_emp_project_table(names.get(i));
								for(int j=0;j<proj.size();j++){
								EmpProj obj=proj.get(j);
								 %>
								<tr>
		 						<td><%=i+j+1 %></td>
								 <td><%=obj.getP_name() %></td>
								 <td><%=obj.getEmp_id() %></td>
								 <td><%=obj.getEmp_name() %></td>
								 <td><%=obj.getPos()%></td>
								 <td><%=obj.getModule() %></td>
								 <td><%=obj.getM_status() %></td>
								 <td><%=obj.getP_status()%></td>
								</tr>
								<%}} %>
							</tbody>
						</table>
					<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
					<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
					<script>$(document).ready(function() {
    				$('#mytable').DataTable();
					} );
					</script>
</body>
</html>
