<%@page import="databases.EmpDetailsDao"%>
<%@page import="objects.DataUpline"%>
<%@page import="databases.RegisterDao"%>
<%@page import="objects.EmployeeObj"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
ArrayList<EmployeeObj> l=RegisterDao.get_empdetails_table();
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'registered.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/style1.css">
<link rel="stylesheet" type="text/css" href="css/style2.css">
<style>

 
.cl{
    padding:3px;
    margin: 0;
    -webkit-border-radius:4px;
    -moz-border-radius:4px;
    border-radius:4px;
    background:#343a40;
    color:white;
    border:none;
    outline:none;
    display: inline-block;
    -webkit-appearance:none;
    -moz-appearance:none;
    appearance:none;
    cursor:pointer;
}
.center-on-page {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%,-50%);
}

input[type="radio"] {
  position: absolute;
  opacity: 0;
  z-index: 0;
}
label {
  position: relative;
  display: inline-block;
  margin-right: 10px;
  margin-bottom: 10px;
  padding-left: 30px;
  padding-right: 10px;
  line-height: 36px;
  cursor: pointer;
}
label::before {
  content: " ";
  position: absolute;
  top: 6px;
  left: 0;
  display: block;
  width: 24px;
  height: 24px;
  border: 2px solid #8e44ad;
  border-radius: 4px;
  z-index: -1;
}
input[type="radio"] + label::before {
  border-radius: 18px;
}
/* Checked */
input[type="radio"]:checked + label {
  padding-left: 10px;
  color: #fff;
}

input[type="radio"]:checked + label::before {
  top: 0;
  width: 100%;
  height: 100%;
  background: #8e44ad;
}
/* Transition */
label,
label::before {
  -webkit-transition: .25s all ease;
  -o-transition: .25s all ease;
  transition: .25s all ease;
}
.tbm
{
 position:absolute;
 left:5%;
 top:20%;
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


</style>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	
	<script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js "></script>

<script type="text/javascript">

 $(function(){
 
 
 $('input[type="radio"]').click(function(){
        var $rad = $(this);
        
        // if this was previously checked
        if ($rad.data('waschecked') == true)
        {
            $rad.prop('checked', false);
            $rad.data('waschecked', false);
            <%for(int i=0;i<l.size();i++){EmployeeObj o = l.get(i);%>
            $("#<%=o.getMobile()%>").hide();
            <%}%>
        }
        else
        {
            $rad.data('waschecked', true);
        	<%for(int i=0;i<l.size();i++){EmployeeObj o = l.get(i);%>
        	if($('input[name="<%=o.getEmail()%>"]:checked').val()=="approve")
            $('<%="#"+o.getMobile()%>').show();
            else
            $('#<%=o.getMobile()%>').hide();
            <%}%>
        }
        // remove was checked from other radios
        $rad.siblings('input[type="radio"]').data('waschecked', false);
    });
});


$(document).ready(function() {

					$('#erase').hide();
					$('#erase').show(1000);
					$('#erase1').hide();
					$('#erase1').show(1000);
    $('#example').DataTable();
} );
 </script>
  </head>
  
  <body>
  	
  	<script>
     <%if(request.getAttribute("edited")=="true"){%>
     alert("updated successfully");
     <%request.removeAttribute("edited");}%>
     </script>
  
  	<span class="app">Applications</span>
    
    <span id="erase1" class="app">Applications</span>

	<div id="erase" class="tbm" class="blue-square-container">
	<form action="Store" method="post">
	<table id="example" class="table table-striped table-bordered" style="width:100%">
	
	<div id="tbl">
								<thead id="hd">
									<tr>
									 
									  <th>Username</th>
									  <th>EMail Id</th>
									  <th>Contact</th>
										<th>Role</th>
										<th>Actions</th>
									</tr>
								</thead>
								<tbody id="bd">
								<%for(int i=0;i<l.size();i++){
								EmployeeObj o = l.get(i); %>
								<tr>
								 
								 <td><%=o.getF_name()+o.getL_name() %></td>
								 <td><%=o.getEmail() %></td>
								 <td><%=o.getMobile() %></td>
								 <td><%=o.getPos()%></td>
								<td>
									
									 
	  <input type="radio" name="<%=o.getEmail()%>" id="<%=o.getEmail()+"a"%>" value="approve"></input>
	  <label for="<%=o.getEmail()+"a"%>">Approve</label>
	  <input type="radio" name="<%=o.getEmail()%>" id="<%=o.getEmail()+"b"%>" value="deny"></input>
	  <label for="<%=o.getEmail()+"b"%>">Deny</label><br>
	  <div id="<%=o.getMobile()%>"  style="display:none" >
	  <span class="cl">Appoint under : </span>
	  <select name="upline">
	  <option value="select">--select upline--</option>
	  <%if(o.getPos().equals("software_employee")){
	  ArrayList<DataUpline> d = EmpDetailsDao.get_data_upline("team_leader");
	  for(int k=0;k<d.size();k++){ DataUpline u = d.get(k);
	   %>
	  
	  <option value="<%=u.getEmail()%>"><%=u.getF_name()+" "+u.getL_name() %></option>
	  <%}
	   }
	   else if(o.getPos().equals("team_leader")){
	  ArrayList<DataUpline> d = EmpDetailsDao.get_data_upline("project_manager");
	 
	  for(int k=0;k<d.size();k++){ DataUpline u = d.get(k);
	  %>
	  <option value="<%=u.getEmail()%>"><%=u.getF_name()+" "+u.getL_name() %></option>
	  <%} } else if(o.getPos().equals("project_manager")){
	 
	   ArrayList<DataUpline> d = EmpDetailsDao.get_data_upline("administrator");
	  for(int k=0;k<d.size();k++){ DataUpline u = d.get(k);
	  %>
	  <option value="<%=u.getEmail()%>"><%=u.getF_name()+" "+u.getL_name() %></option>
	  <%} } else if(o.getPos().equals("admin")){
	   ArrayList<DataUpline> d = EmpDetailsDao.get_data_upline("administrator");
	  for(int k=0;k<d.size();k++){ DataUpline u = d.get(k);
	  %>
	   <option value="<%=u.getEmail()%>"><%=u.getF_name()+" "+u.getL_name() %></option>
	   <%} }%>
	  </select>
	  </div>
	  
								</td>
								
								</tr><%} %>
	<!-- 							<tr>
								 <td>1</td>
								 <td>bhaskar</td>
								 <td>bhaskar@gmail.com</td>
								 <td>9490452155</td>
								 <td>web dev</td>
								<td>
									
									
	  <input type="radio" name="rb1" id="rb1"></input>
	  <label for="rb1">Approve</label>
	  <input type="radio" name="rb1" id="rb2"></input>
	  <label for="rb2">Deny</label>
								</td>
								</tr>
								<tr>
								 <td>1</td>
								 <td>bhaskar</td>
								 <td>bhaskar@gmail.com</td>
								 <td>9490452155</td>
								 <td>web dev</td>
								<td>
									
									
	  <input type="radio" name="rb1" id="rb1"></input>
	  <label for="rb1">Approve</label>
	  <input type="radio" name="rb1" id="rb2"></input>
	  <label for="rb2">Deny</label>
								</td>
								</tr>
								<tr>
								 <td>1</td>
								 <td>bhaskar</td>
								 <td>bhaskar@gmail.com</td>
								 <td>9490452155</td>
								 <td>web dev</td>
								<td>
									
									
	  <input type="radio" name="rb1" id="rb1"></input>
	  <label for="rb1">Approve</label>
	  <input type="radio" name="rb1" id="rb2"></input>
	  <label for="rb2">Deny</label>
								</td>
								</tr>
								<tr>
								 <td>1</td>
								 <td>bhaskar</td>
								 <td>bhaskar@gmail.com</td>
								 <td>9490452155</td>
								 <td>web dev</td>
								<td>
									
									
	  <input type="radio" name="rb1" id="rb1"></input>
	  <label for="rb1">Approve</label>
	  <input type="radio" name="rb1" id="rb2"></input>
	  <label for="rb2">Deny</label>
								</td>
								</tr>
							
								<tr>
								 <td>1</td>
								 <td>bhaskar</td>
								 <td>bhaskar@gmail.com</td>
								 <td>9490452155</td>
								 <td>web dev</td>
								<td>
									
									
	  <input type="radio" name="rb1" id="rb1"></input>
	  <label for="rb1">Approve</label>
	  <input type="radio" name="rb1" id="rb2"></input>
	  <label for="rb2">Deny</label>
								</td> -->
								
								 </tbody>
	</div>
	</table>
	<input class="r" type="submit" value="submit">
	</form>
	</div>
  </body>
</html>
