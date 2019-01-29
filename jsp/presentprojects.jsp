<%@page import="objects.EmpPar"%>
<%@page import="databases.EmpDetailsDao"%>
<%@page import="objects.EmpDetails"%>
<%@page import="databases.ProjectDetailsDao"%>
<%@page import="objects.EmpProj"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%-- <%@page import="objects.EmpDetails"%> --%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%--  <%
ArrayList<EmployeeObj> l=RegisterDao.get_empdetails_table();
 %> --%>
 
 
 <%ArrayList<String> names = EmpDetailsDao.get_all_downline((String)session.getAttribute("emp_email"));
 names.add((String)session.getAttribute("emp_email"));
 %>
 
 
 <%EmpDetails emp_details = (EmpDetails)session.getAttribute("emp_details");%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>Present Projects</title>
	<link rel="stylesheet" type="text/css" href="css/style1.css">
	<link rel="stylesheet" type="text/css" href="css/style2.css">
	<link rel="stylesheet" type="text/css" href="css/pp.css">
	<script src="js/pp.js"></script>
	<%-- <%EmpDetails emp_details = (EmpDetails)session.getAttribute("emp_details");%> --%>
<style>

.center-on-page {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%,-50%);
}



/* Transition */
.tbm
{
 position:relative;
 left:5%;
 top:0%;
 right:5%;
 width:90%;
}
 
.app{

 font-size:x-large;
 position:absolute;
 left:5%;
 top:10%;
 color:orange;
}
table th 
{
    background-color:#343a40;
    color: white;
}
.r{
position:relative;
background-color:orange;
border-radius:4px;
color:white;
padding:10px 20px;
cursor: pointer;
font-size: 16px;
 border: none;
}
.r:hover{
background-color:black;}

</style>



<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	
	<script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js "></script>
<script type="text/javascript">
<%if(request.getAttribute("project_insert")=="false"){%>
alert("project name already exists");
<%} else if(request.getAttribute("project_updated")=="true"){ %>
alert("updated successfully");
<%}else if(request.getAttribute("project_updated")=="false"){ %>
alert("Error in updating");
<%}
else if(request.getAttribute("module_updated")=="true"){ %>
alert("module updated successfully");
<%}else if(request.getAttribute("module_updated")=="false"){ %>
alert("Error in updating module");
<%}
%>
</script>
<script type="text/javascript">

 $(function(){
 
					$('#erase').hide();
					$('#erase').show(1000);
					$('#erase1').hide();
					$('#erase1').show(1000);
});


$(document).ready(function() {
    $('#example').DataTable();
} );
 </script>
 </head>
  <body>
    <h1>Present Projects</h1>
    <form method="post" action="update">
    <div id="tbl">
	<div id="erase" class="tbm" class="blue-square-container">
	<table id="example" class="table table-striped table-bordered" style="width:100%">
	
								<thead id="hd">
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
								<tbody id="bd">
								<%for(int i=0;i<names.size();i++){
								System.out.print("names "+names.get(i));
								ArrayList<EmpProj> proj=ProjectDetailsDao.get_from_emp_project_table(names.get(i));
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
								 <td><input type="text" name="m<%=obj.getEmp_id()+obj.getP_name() %>" value="<%=obj.getM_status()%>" <%if(!obj.getEmp_id().equals((String)session.getAttribute("emp_email"))){%>readonly="readonly"<%}%>></td>
								 <td><select name="p<%=obj.getEmp_id()+obj.getP_name() %>" style="min-width: 30%" <%if(obj.getPos().equals("software_employee")){%>readonly="readonly"<%}%>>
 					 				<option value="default" >--Select--</option>
 								 	<option value="yes" <%if(obj.getP_status().equals("yes")){%>selected<%}%>>Completed</option>
 					 				<option value="no" <%if(obj.getP_status().equals("no")){%>selected<%}%>>Incomplete</option>
 									</select></td>
								</tr>
								<%}} %>
								 </tbody>
    </table>
    <input type="submit" value="Submit" class="savebtn">
    </div>
	
	</div>
	
	</form>
	
	<%if(emp_details.getPosition().equals("project_manager")){ %>
	<div class="pro_man">
					
 					 <button  class="button1" onclick="myFunction1()">Add project</button>
 					 <form action="addproject" method="post">
 					 <div id="sel" class="dp1">
 					 <select name="t_id" style="min-width: 30%" onchange="addp()">
 					 <option value="default" >--select teamlead--</option>
 					 <%ArrayList<EmpPar> tl = EmpDetailsDao.get_downline((String)session.getAttribute("emp_email")) ;
 					 for(int k=0;k<tl.size();k++){
 					 EmpPar tld =  tl.get(k);
 					 %>
 					 <option value="<%=tld.getE_name()%>" ><%=tld.getP_name() %></option>
 					 <%}%>
 					 </select>
  					 </div>
					<div id="pro">
							
  							Project Name:
 							<input type="text" name="p_name"  id="p_name" placeholder=" Enter Project Name" style="min-width: 40%">
  							<br><br>
 							<input  type="submit" class="savebtn" value="Submit" onclick="return validate()">
 							<input type="button" value="cancel" onclick="cncl1()" class="cnlbtn">
						</div>
					</form>	
					</div> 
					 <%}%> 
<%if(emp_details.getPosition().equals("team_leader")){ %> 
	<div class="team_lead">
 					 <button onclick="myFunction()" class="dropbtn">Assign Modules</button>
 					 <form action="assignmodules" method ="post">
 					 <div id="sel1" class="dp2">
 					 <select name="p_id" style="min-width: 30%" onchange="module()">
 					 <option value="default" >--select project--</option>
 					 <%ArrayList<String> p = ProjectDetailsDao.get_project_from_emp_project_table((String)session.getAttribute("emp_email"));
 					 for(int k=0;k<p.size();k++){ %>
 					 <option value="<%=p.get(k)%>" ><%=p.get(k)%></option>
 					 <%} %>
 					 </select>
  					 </div>
						<div id="mod">
							<%ArrayList<EmpPar> sed = EmpDetailsDao.get_downline((String)session.getAttribute("emp_email"));
							for(int k=0;k<sed.size();k++){
							EmpPar se = sed.get(k);
							 %>
  							<%=se.getP_name()+":"%>
 							<input type="text" name="<%=se.getE_name() %>" placeholder=" Enter Module" style="min-width: 40%">
  							<br><br>
  							<%} %>
 							<input class="savebtn" type="submit" value="Submit">
 							<input type="button" value="cancel" onclick="cncl()" class="cnlbtn">
						</div>
						</form>
					</div>
	 <%}%>
  </body>
</html>
