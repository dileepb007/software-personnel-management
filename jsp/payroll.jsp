<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'payroll.jsp' starting page</title>
    
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
	.tbm
	{
	 position:absolute;
	 left:5%;
	 top:70%;
	 right:5%;
	 width:90%;
	}
	    
		table 
	{
	    width:60%;
	}
	table, th, td {
	    border: 1px solid black;
	    border-collapse: collapse;
	}
	th, td {
	    padding: 15px;
	    text-align: center;
	}
	table tr:nth-child(even) {
	    background-color: #eee;
	}
	table tr:nth-child(odd) {
	   background-color: #fff;
	}
	table th 
	{
	    background-color:#343a40;
	    color: white;
	}
		 
	.blue-square-container 
	{
	  text-align:center;
	}
	.blue-square 
	{
	  background-color: #0074D9;
	  width: 100px;
	  height: 100px;
	  display: inline-block;
	}
	.button1 
	{
		border-radius:4px;
	    background-color: orange;
	    border: none;
	    color: white;
	    padding: 15px 25px;
	    text-align: center;
	    font-size: 16px;
		position:absolute;
		 left: 10%;
	   top: 20%;
	  transform: translate(-50%, -50%);
	    cursor: pointer;
	}
	.button3 
	{
		border-radius:4px;
	    background-color: orange;
	    border: none;
	    color: white;
	    padding: 15px 25px;
	    text-align: center;
	    font-size: 16px;
		position:absolute;
		 left: 25%;
	   top: 20%;
	  transform: translate(-50%, -50%);
	    cursor: pointer;
	}
	
	.button2 {
	border-radius:4px;
	    background-color: orange;
	    border: none;
	    color: white;
	    padding: 15px 25px;
	    text-align: center;
	    font-size: 16px;
		position:absolute;
		 left: 65%;
		  top: 50%;
	  transform: translate(-50%, -50%);
	    cursor: pointer;
	}
	
	.button1:hover {
	    background-color: black;
	}
	.button2:hover {
	    background-color: black;
	}
	
	.button3:hover {
	    background-color: black;
	}
	
	 .inp{
	 border-radius:4px;
	   padding: 15px 15px;
	   position:absolute;
		 left: 15%;
		  top: 50%;
		  transform: translate(-50%, -50%);
	 
	   }
	 
	
	  
	   .inp1{
	 border-radius:4px;
	   padding: 15px 15px;
	   position:absolute;
		 left: 40%;
		  top: 50%;
		  transform: translate(-50%, -50%);
	 
	   }
	
	 .text1
	 {
	     position:absolute;
	   left: 10%;
		  top: 40%;
		  transform: translate(-50%, -50%);
	 }
	 
	 .text2
	 {
	     position:absolute;
	   left: 30%;
		  top: 40%;
		  transform: translate(-50%, -50%);
	 }
	 
	/* The Modal (background) */
	.modal {
	    display: none; /* Hidden by default */
	    position: fixed; /* Stay in place */
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
	.modal-content {
	    background-color: #fefefe;
	    margin: auto;
	    padding: 20px;
	    border: 1px solid #888;
	    width: 50%;
	}
	
	/* The Close Button */
	.close {
	    color: #aaaaaa;
	    float: right;
	    font-size: 28px;
	    font-weight: bold;
	}
	
	.close:hover,
	.close:focus {
	    color: #000;
	    text-decoration: none;
	    cursor: pointer;
	}
	
	
	/* The Close1 Button */
	.close1 {
	    color: #aaaaaa;
	    float: right;
	    font-size: 28px;
	    font-weight: bold;
	}
	
	.close1:hover,
	.close1:focus {
	    color: #000;
	    text-decoration: none;
	    cursor: pointer;
		}
	</style>
  </head>
  
  <body>
  <!-- <form action="Attendance" method="post">
    <div class="blue-square-container">
	    <input type="submit" class="button1" id="MyBtn" value="check in" >
</form>
	    -->
	<!-- <input type="button" class="button1" value="check in" onclick="Worktime.checkin()" >-->
	
	 <!-- <button id="heyy" class="button2">view attendance</button> -->
	 <!--  <form action="Attendance1" method="post">
	<input type="submit" class="button3" id="B" value="check out"  >
	</form>
	-->
	<!-- <button id="B" class="button3">check out</button>-->
	
	  </div>
	
	  <div id="erase" class="tbm" class="blue-square-container" style="display:none">
	<table id="example" class="table table-striped table-bordered" style="width:100%">
	<div id="tbl">
								<thead id="hd">
									<tr>
									  <th>Payroll</th>
									</tr>
								</thead>
								<tbody id="bd">
								<%
								try
								{
									Double pay=(Double)request.getAttribute("Pay");
								
								%>					
								<tr>
								 <td><%=pay %></td>
								</tr>
								<% 
								}
								catch(Exception e)
								{
									System.out.println("in payroll jsp "+ e);
								}
								%>
								<!-- <tr>
								 <td>1</td>
								 <td>10/10/2018</td>
								 <td>11 AM</td>
								 <td>5 PM</td>
								</tr>
								<tr>
								 <td>1</td>
								 <td>10/10/2018</td>
								 <td>10 AM</td>
								 <td>5 PM</td>
								</tr>
								<tr>
								 <td>1</td>
								 <td>10/10/2018</td>
								 <td>10 AM</td>
								 <td>5 PM</td>
								</tr>
								<tr>
								 <td>1</td>
								 <td>10/10/2018</td>
								 <td>10 AM</td>
								 <td>5 PM</td>
								</tr>
								<tr>
								 <td>1</td>
								 <td>10/10/2018</td>
								 <td>10 AM</td>
								 <td>5 PM</td>
								</tr>
								<tr>
								 <td>1</td>
								 <td>10/10/2018</td>
								 <td>10 AM</td>
								 <td>5 PM</td>
								</tr>
								<tr>
								 <td>1</td>
								 <td>10/10/2018</td>
								 <td>10 AM</td>
								 <td>5 PM</td>
								</tr>
								<tr>
								 <td>1</td>
								 <td>10/10/2018</td>
								 <td>10 AM</td>
								 <td>5 PM</td>
								</tr>
								<tr>
								 <td>1</td>
								 <td>10/10/2018</td>
								 <td>10 AM</td>
								 <td>5 PM</td>
								</tr>
								<tr>
								 <td>1</td>
								 <td>10/10/2018</td>
								 <td>10 AM</td>
								 <td>5 PM</td>
								</tr>
								<tr>
								 <td>1</td>
								 <td>10/10/2018</td>
								 <td>10 AM</td>
								 <td>5 PM</td>
								</tr>
								<tr>
								 <td>1</td>
								 <td>10/10/2018</td>
								 <td>10 AM</td>
								 <td>5 PM</td>
								</tr>
								<tr>
								 <td>1</td>
								 <td>10/10/2018</td>
								 <td>10 AM</td>
								 <td>5 PM</td>
								</tr>
								<tr>
								 <td>1</td>
								 <td>10/10/2018</td>
								 <td>10 AM</td>
								 <td>5 PM</td>
								</tr>
								<tr>
								 <td>1</td>
								 <td>10/10/2018</td>
								 <td>10 AM</td>
								 <td>5 PM</td>
								</tr>
								<tr>
								 <td>1</td>
								 <td>10/10/2018</td>
								 <td>10 AM</td>
								 <td>5 PM</td>
								</tr>
								<tr>
								 <td>1</td>
								 <td>10/10/2018</td>
								 <td>10 AM</td>
								 <td>5 PM</td>
								</tr>
								<tr>
								 <td>1</td>
								 <td>10/10/2018</td>
								 <td>10 AM</td>
								 <td>5 PM</td>
								</tr>
								<tr>
								 <td>1</td>
								 <td>10/10/2018</td>
								 <td>10 AM</td>
								 <td>5 PM</td>
								</tr>
								<tr>
								 <td>1</td>
								 <td>10/10/2018</td>
								 <td>10 AM</td>
								 <td>5 PM</td>
								</tr>
								<tr>
								 <td>1</td>
								 <td>10/10/2018</td>
								 <td>10 AM</td>
								 <td>5 PM</td>
								</tr>
								<tr>
								 <td>1</td>
								 <td>10/10/2018</td>
								 <td>10 AM</td>
								 <td>5 PM</td>
								</tr>
								<tr>
								 <td>1</td>
								 <td>10/10/2018</td>
								 <td>10 AM</td>
								 <td>5 PM</td>
								</tr>
								<tr>
								 <td>1</td>
								 <td>10/10/2018</td>
								 <td>10 AM</td>
								 <td>5 PM</td>
								</tr>
								<tr>
								 <td>1</td>
								 <td>10/10/2018</td>
								 <td>10 AM</td>
								 <td>5 PM</td>
								</tr>-->
	     						</tbody>
							<tfoot>
	            <tr>
	                <th>Payroll</th>				
	            </tr>
	        </tfoot>
								</div>
							</table>
							</div>
	
	  <!-- The Modal -->
	  <div class="blue-square-container">
	<div id="myModal" class="modal">
	
	  <!-- Modal content -->
	  <div class="modal-content">
	    <span class="close">&times;</span>
	    <span>Done check in</span>
	  </div>
	
	</div>
	</div>
	 <div class="blue-square-container">
	<div id="mine" class="modal">
	
	  <!-- Modal content -->
	  <div class="modal-content">
	    <span class="close1">&times;</span>
	    <span>Done check out</span>
	  </div>
	
	</div>
	</div>
	<span class="text1">From</span><span class="text2">To</span>
	<form action="Payroll" method="post">
	
	<input class="inp" name="from" type="date" ></input>
	
	<input class="inp1" name="to" type="date" ></input>
	<input id="heyy" type="submit" class="button2" value="view payroll">
	</form>
				
	<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	
	<script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js "></script>
	
	 <script>
	 /*document.getElementById('heyy').addEventListener("click",function(){
	    document.getElementById("erase").style.display="block";
	});*/
	
	var popup = document.getElementById('myModal');
	
	// Get the button that opens the modal
	var btn = document.getElementById("myBtn");
	
	// Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close")[0];
	
	
	<%
	if(request.getAttribute("checkedin")=="true")
	{%>
	popup.style.display = "block";
	<%
	}
	%>
	// When the user clicks the button, open the modal 
	/* btn.onclick = function() {
	    popup.style.display = "block";
	} */
	
	// When the user clicks on <span> (x), close the popup
	span.onclick = function() 
	{
	    popup.style.display = "none";
	}
	
	 
	
	var popup1 = document.getElementById('myModal1');
	
	// Get the button that opens the modal
	var btn1 = document.getElementById("B");
	
	
	// When the user clicks the button, open the modal 
	<%
	if(request.getAttribute("checkedout")=="true")
	{%>
	document.getElementById('mine').style.display="block";
	<%
	}
	%>
	/*btn1.onclick = function()
	 {
	    document.getElementById('mine').style.display="block";
		}*/
	 
	
	var span1 = document.getElementsByClassName("close1")[0];
	
	span1.onclick = function() 
	{
	    document.getElementById('mine').style.display="none";
	}
	
	/*(document).ready(function() {
	    $('#example').DataTable();
	} );*/
	
	<%
	if(request.getAttribute("payroll")=="true")
	{
	%>
	    document.getElementById("erase").style.display="block";
	 <%
	 }
	 %>
	 
	 
	 </script>
  </body>
</html>