<%@page import="databases.AddDate"%>
<%@page import="objects.Schedule"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%ArrayList<Schedule> s = AddDate.get_from_schedule_table((String)session.getAttribute("emp_email")); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'schedule.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<head>
<link rel="stylesheet" type="text/css" href="css/style1.css">
<link rel="stylesheet" type="text/css" href="css/style2.css">
<!-- <script>window.onclick = function(event) {
  if (!event.target.matches('.modal')) {
      if (modal.classList.contains('show')) {
       modal.classList.remove('show');
      }
}}</script> -->
<style>
.b1
{
	position:absolute;
	left:5%;
	top:5%;
}
.b2
{
	position:absolute;
	left:15%;
	top:5%;
}
.select
{
	 
    overflow:scroll;
}
.tbm
{
 position:absolute;
 left:5%;
 top:20%;
 right:5%;
 width:90%;
}
 .modal 
 {
    display: none; /* Hidden by default */
    position: absolute; /* Stay in place */
    z-index: 1; /* Sit on top */
    padding-top: 100px; /* Location of the box */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content 
{
    background-color:#ffff;
    margin: auto;
    padding: 10px;
    border: 1px solid #888;
	height:90%;
	top:0;
	bottom:90px;
    width: 35%;
}
div.polaroid 
{
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}
 

table th 
{
    background-color:#343a40;
    color: white;
}
.cla
{
 width:100px;
 background-color:#0370EA;
 border:1px solid #076BD2;
 border-radius:4px;
 padding:10px; 
 margin:10px 5px;
 padding-right:5px;
 padding-left:5px;
 color:#ffff;	
}


table, th, td 
{
    border: 1px solid black;
    border-collapse: collapse;
}
.show{display:block;}
table
{
width:40%;
-webkit-transition: width 2s;
}
th, td 
{	width:20%;
    padding: 5px;
    text-align: center;
}
.center-on-page {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%,-50%);
}

</style>
<script type="text/javascript">
<%if(request.getAttribute("added")=="true"){%>
alert("Schedule added");
<%} else if(request.getAttribute("added")=="false"){ %>
alert("Error in adding Schedule");
<%}else if(request.getAttribute("present")=="true"){ %>
alert("Event already exists");
<%}else if(request.getAttribute("deleted")=="true"){%>
alert("Schedule deleted");
<%} else if(request.getAttribute("added")=="false"){ %>
alert("Error in deleting Schedule");
<%}%>
</script>
  </head>
  
  <body>
  
   
     
      <button id="btn" class="cla b1"><span style=
      "font-size:12px;font-family:Arial;font-weight:bold;color:#fff;white-space:nowrap;display:block; text-align:center">
      Add Event</button>
	  
	  <button id="btn1" class="cla b2"><span style=
      "font-size:12px;font-family:Arial;font-weight:bold;color:#fff;white-space:nowrap;display:block; text-align:center">
      Delete Events</button>
	  <div id="erase" class="tbm" class="blue-square-container" style="display:block">
	  <table id="example" class="table table-striped table-bordered" style="width:100%">

	  <div id="tbl">
							<thead id="hd">
								<tr>
								  <th >Date</th>
								  <th>From</th>
								  <th>To</th>
									<th>Event</th>
								</tr>
							</thead>
							<tbody id="bd">
							<%for(int i=0;i<s.size();i++){ Schedule sc=s.get(i); %>
							 <tr>
								  <td><%=sc.getS_date() %></td>
								  <td><%=sc.getFrom_h() %>:<%=sc.getFrom_m() %></td>
								  <td><%=sc.getTo_h() %>:<%=sc.getTo_m() %></td>
									<td><%=sc.getEvent() %></td>
								</tr><%} %>
							 </tbody>
				</div>
				</table>
				</div>
				
				<div id="erase1" style="display:none" class="tbm" class="blue-square-container" >
				<form action="removeschedule" method="post">
				 <table id="example1"  class="table table-striped table-bordered" style="width:100%">

				<div id="tbl1">
							<thead id="hd1">
								<tr>
								  <th >Date</th>
								  <th>From</th>
								  <th>To</th>
									<th>Event</th>
									<th>Delete</th>
								</tr>
							</thead>
							<tbody id="bd1">
							 <%for(int i=0;i<s.size();i++){ Schedule sc=s.get(i); %>
							 <tr>
								  <td><%=sc.getS_date() %></td>
								  <td><%=sc.getFrom_h() %>:<%=sc.getFrom_m() %></td>
								  <td><%=sc.getTo_h() %>:<%=sc.getTo_m() %></td>
									<td><%=sc.getEvent() %></td>
									<td><input type="checkbox" name="check" value="<%=sc.getEvent()%>"></input></td>
								</tr><%} %>
							 
							
							 </tbody>
				</div>
				</table>
				<button style="display:none"id="btn2" class="cla"><span style=
      "font-size:12px;position:relative;top:20%;left:10%;font-family:Arial;font-weight:bold;color:#fff;white-space:nowrap;display:block;text-align:center">
      Delete</button>
      </form>
		</div>
	  		 
				
					
				<div id="myModal" class="modal " >

					<!-- Modal content -->
				<div  style="font-family:Arial;" class="modal-content polaroid" >
					
					<form action="addschedule" method="post">
					
					<label >Enter date</label><br>
					<input style="left:90%" type="date" name="date"></input><br><br>
					<label > From time</label><br>
					<select id="id1" name="from_h" size="1" position="absolute">
						<option value="selected">Hour</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>
						<option value="19">19</option>
						<option value="20">20</option>
						<option value="21">21</option>
						<option value="22">22</option>
						<option value="23">23</option>
						<option value="24">24</option>
					</select>
					<select id="id2" name="from_m">
						<option value="selected">Minute</option>
						<option value="0">00</option>
						<option value="15">15</option>
						<option value="30">30</option>
						<option value="45">45</option>
					</select>
					<!--<select>
						<option value="">AM</option>
						<option value="">PM</option>
					</select>-->
					
					<br>
					<label > To time</label><br>
					<select id="id3" size="1" position="absolute" name="to_h" onclick="size=(size!=1)?5:1;" ...>
						<option value="selected">Hour</option>
						 <option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>
						<option value="19">19</option>
						<option value="20">20</option>
						<option value="21">21</option>
						<option value="22">22</option>
						<option value="23">23</option>
						<option value="24">24</option>
					</select>
						<select id="id4" name="to_m">
						<option value="selected">Minute</option>
						<option value="0">00</option>
						<option value="15">15</option>
						<option value="30">30</option>
						<option value="45">45</option>
					</select>
					<!--<select>
						<option>AM</option>
						<option>PM</option>
					</select>--><br><br>
					<label >Event Description</label><br>
					<textarea cols="40" rows="2" name="event" placeholder="Enter event"></textarea><br>
					<input type="submit" onclick="return myfunc()" value="Add Event" class="cla" ></input>
					
					</form>
				
				</div>
				
				</div>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	
	<script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js "></script>

<script>

var popup = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("btn");
var btn1 = document.getElementById("btn1");
 

// When the user clicks the button, open the modal 
btn.onclick = function() {
	/* popup.classList.toggle("show"); */
     popup.style.display = "block"; 
}
btn1.onclick = function() 
{

 var btn2 = document.getElementById("btn2");
 btn2.style.display="block";
 var e = document.getElementById("erase");
 e.style.display="none";
 var e1 = document.getElementById("erase1");
 e1.style.display="block";
 
}
function myfunc()
{
	var e=document.getElementById('id1');
	var h1=e.options[e.selectedIndex].value;
	
	e=document.getElementById('id2');
	var m1=e.options[e.selectedIndex].value;
	
	e=document.getElementById('id3');
	var h2=e.options[e.selectedIndex].value;
	
	e=document.getElementById('id4');
	var m2=e.options[e.selectedIndex].value;
	
	if(h1<h2)
	{
		return true;
	}
	else if(h1==h2)
	{
		if(m1>m2)
		{
		
		alert('please check time format');
		return false;
		}
		else
		return true;
	}
	else
	{
		alert('please check time format');
		return false;
	}
}
$(document).ready(function()
{	
	
    $('#example').DataTable();
	$('#example1').DataTable(); 
} );
</script>
				
  </body>
</html>
