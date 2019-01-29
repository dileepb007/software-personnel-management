<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="objects.EmpDetails"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Home</title>
    <% EmpDetails emp_details = (EmpDetails)session.getAttribute("emp_details");%>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/home.css">
	<script>
	function startTime() {
	    var today = new Date();
	    var d=today.getDate();
	    var mo=today.getMonth()+1;
	    var y=today.getFullYear();
	    var h = today.getHours();
	    var m = today.getMinutes();
	    var s = today.getSeconds();
	    var a = "AM";
	    var days = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
	    var day= days[today.getDay()];
	    if(h>12)
	    	{h=h-12;
	    	if(h>=12&& m>=0 &&s>=0)
	    	a="PM";
	    	}
	    m = checkTime(m);
	    s = checkTime(s);
	    document.getElementById('dat').innerHTML =
	    d+"-"+mo+"-"+y+" "+day;
	    document.getElementById('tim').innerHTML =
	    h + ":" + m + ":" + s + ":" + a;
    var t = setTimeout(startTime, 500);
	}
	function checkTime(i) {
    if (i < 10) {i = "0" + i};  // add zero in front of numbers < 10
    return i;
	}
</script>
<!-- style="padding-top:25%;
	color:#222d32" -->
  </head>
  
<body onload="startTime()"> 
<div id="centre_main" >
	<p id="para1" align="center">Welcome <%=emp_details.getFname()%> <%=emp_details.getLname()%></p>
	<div id="dat" align="center"></div>
	<div id="tim" align="center"></div>
</div>
</body>
</html>
