<%@page import="databases.EmpDetailsDao"%>
<%@page import="objects.EmpDetails"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%ArrayList<String> names = EmpDetailsDao.get_all_downline((String)session.getAttribute("emp_email"));
	
ArrayList<EmpDetails> det = EmpDetailsDao.get_all_downline_details(names);

 %>

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
	
	<link rel="stylesheet" type="text/css" href="css/downline.css">
	

<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<script type="text/javascript">
 <%if(request.getAttribute("remove")=="true"){%>
 alert("deleted successfully");
 <%}%>
</script>


<!--webfonts-->
<link href="//fonts.googleapis.com/css?family=PT+Sans:400,400i,700,700i&amp;subset=cyrillic,cyrillic-ext,latin-ext" rel="stylesheet">
<!--//webfonts--> 

<link href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css">
  </head>
  
<body>

  <div class="btnn">
						<button type="submit" onclick='show(2)'>View</button>
						
						<button type="submit" onclick='edit()'>Edit</button>
					
				<!--  	<button type="submit" onclick='add()'>Add</button> -->
					</div>
					
				
						
					<div>&nbsp;</div>
					
					<div id="table2" style="display:none;width:100%">
					<h2 style="color:#000099;">Employee Downline</h2>
	<table id="mytable1" class="display">
							<thead>
                    <tr>
                      <th>Name</th>
                      <th>Position</th>
                      <th>Gender</th>
                      <th>ID</th>
                      <th>Mobile</th>
                      <th>Team</th>
                    </tr>
                  </thead>
                  <tfoot>
                    <tr>
                      <th>Name</th>
                      <th>Position</th>
                      <th>Gender</th>
                      <th>ID</th>
                      <th>Mobile</th>
                      <th>Team</th>
                    </tr>
                  </tfoot>
                  <tbody>
                  <%for(int i=0;i<det.size();i++){
                  EmpDetails ov = det.get(i); %>
                    <tr>
                      <td><%=ov.getFname()+" "+ov.getLname() %></td>
                     <td><%=ov.getPosition() %></td>
                     <td><%=ov.getGender() %></td>
                     <td><%=ov.getEmail() %></td>
                     <td><%=ov.getMobile() %></td>
                     <td><%=EmpDetailsDao.get_upline(ov.getEmail()) %></td>
                    </tr><%} %>
                   
            
                  </tbody>
                  </table>
                  </div>
					<div id="table1" style="display:none;width:100%">
					<h2 style="color:#000099;">Employee Downline</h2>
<form action="remove" method="post">
	<table id="mytable" class="display">
					  <thead>
                    <tr>
                    <th>Check</th>
                      <th>Name</th>
                      <th>Position</th>
                      <th>Gender</th>
                      <th>ID</th>
                      <th>Mobile</th>
                      <th>Team</th>
                      
                    </tr>
                  </thead>
                 <!--  <button id="button" class="poi"> x</button>-->
                  <tbody>
                   
                    
                       <%for(int i=0;i<det.size();i++){
                  EmpDetails ov = det.get(i); %>
                    <tr>
                     <td><input type="checkbox" name="checkedRows" value="<%=ov.getEmail() %>"></td>
                      <td><%=ov.getFname()+" "+ov.getLname() %></td>
                     <td><%=ov.getPosition() %></td>
                     <td><%=ov.getGender() %></td>
                     <td><%=ov.getEmail() %></td>
                     <td><%=ov.getMobile() %></td>
                     <td><%=EmpDetailsDao.get_upline(ov.getEmail()) %></td>
                    </tr><%} %>
                     
                  
                  </tbody>
						</table>
				<!--  <INPUT type="button" value="Delete Row" onclick="deleteRow("mytable")" />-->
				<!--  <input type="button" id="btnDelete" value="Delete Selected Rows" onclick="removeSampleRow('mytable')">-->
					 <!--  <button id="btnDelete" onclick="deleteRows();">Delete Row</button>	-->
						<input class="r" type="submit" value="Delete Rows" onclick="deleteRows();">
						</form>
						</div>
						
						   <div id="three-col" style="display:none;width:100%">
    <div class="col1">
        <label for="Name"></label> 
        <input id="name" name="Name" type="text" placeholder="Name">
    

    
        <label for="designation"></label>
        <input id="designation" name="Designation" type="text" placeholder="Designation" >
    
   
        <label for="team"></label>
        <input id="team" name="Team" type="text" placeholder="Team" >
    </div>
    <div>&nbsp</div>
    <div class="btnn">
    <button type="submit">Submit</button>
    </div>
</div>
								<!--	$('body').on('click', 'input.deleteDep', function() {
   $(this).parents('tr').remove().draw();  
});-->
<!--  $(document).ready(function() {
    				$('#mytable').DataTable();
					} );-->
					<!--  	$(document).ready(function() { var table = $('#mytable').DataTable(); $('#mytable tbody').on( 'click', 'tr', function () { if ( $(this).hasClass('selected') ) { $(this).removeClass('selected'); } else { table.$('tr.selected').removeClass('selected'); $(this).addClass('selected'); } } ); $('#button').click( function () { table.row('.selected').remove().draw( false ); } );-->
						<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
				<!--  	<script src="https://code.jquery.com/jquery-3.3.1.js"></script> -->
					<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
					<script>
					var table1 = $('#mytable1').DataTable();
var table = $('#mytable').DataTable();

	
						function show(nr) {
						
   /* document.getElementById("table2").style.display="none";*/
    document.getElementById("table"+nr).style.display="block";
 /*   document.getElementById("table1").style.visibility="hidden";*/
  document.getElementById("table1").style.display="none";
 
   
}
					function edit()
					{
					
				/*	document.getElementById("table1").style.display="none";*/
					 document.getElementById("table1").style.display="block";
					/* document.getElementById("table2").style.visibility="hidden";*/
					 document.getElementById("table2").style.display="none";
					  document.getElementById("three-col").style.display="none";
					}
		
				/*		 function getSelectedRows() {
					            var selectedRows = []
					            $('input[type=checkbox]').each(function () {
					                if ($(this).is(":checked")) {
					                    selectedRows.push($(this));
					                }
					            });
					            return selectedRows;
					        }
					        function deleteRows() {
					            var selectedRows = getSelectedRows();
					            for (var i = 0; i < selectedRows.length; i++) {
					                $(selectedRows[i]).parent().parent().remove();
					            }
					        }*/
					</script>
					
</body>
</html>