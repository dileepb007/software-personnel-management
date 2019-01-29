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
    
    <title>My JSP 'editprofile.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- metatags-->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="Sports Camp Registration Form a Flat Responsive Widget,Login form widgets, Sign up Web 	forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
	function hideURLbar(){ window.scrollTo(0,1); } </script>
	 <script src='js/editprofile.js' type="text/javascript"></script>
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Meta tag Keywords -->
	<!-- css files -->
	<link rel="stylesheet" href="css/jquery-ui.css"/>
	<link href="css/editprofile.css" rel="stylesheet" type="text/css" media="all"/><!--stylesheet-css-->
	<link href="//fonts.googleapis.com/css?family=Josefin+Sans:100,100i,300,300i,400,400i,600,600i,700,700i" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=PT+Sans:400,400i,700,700i" rel="stylesheet">
	<% EmpDetails emp_details = (EmpDetails)session.getAttribute("emp_details");%>
	<%-- <%System.out.println(emp_details.toString()); %> --%>
	<!-- //css files -->

  </head>
  
  <body>
	<div class="w3l-main">
		<div class="w3l-from">
			<script>
  				<%if(request.getAttribute("updated")=="true"){%>
  					alert("Profile page updated successfully");
  				<%}else if(request.getAttribute("updated")=="false")
  				{%>
					alert("Error in updating profile page");  	
  				<%}%>
  			</script>
  			
			<form action="Editprofile" method="post" >	
				<div class="w3l-user">
					<label class="head">First Name<span class="w3l-star"> * </span></label>
					<input type="text" name="firstname" id="firstname" required="" value="<%=emp_details.getFname()%>">
				</div>
				<div class="w3l-user">
					<label class="head">Last Name<span class="w3l-star"> * </span></label>
					<input type="text" name="lastname" id="lastname" placeholder="" required="" value="<%=emp_details.getLname()%>">
				</div>
				<div class="w3l-mail">
					<label class="head">Email<span class="w3l-star"> * </span></label>
					<input type="email" name="email" placeholder="" required="" value=<%=session.getAttribute("emp_email") %> readonly="readonly">
				</div>
				<div class="clear"></div>
				<div class="w3l-details1">
					<div class="w3l-num">
						<label class="head">Contact Number<span class="w3l-star"> * </span></label>
						<input type="text"  id="contno" name="mobile" placeholder="" required="" value="<%=emp_details.getMobile()%>">
					</div>
					<div class="w3l-date">
						<label class="head">Date of Birth<span class="w3l-star"> * </span></label>
							<div class="styled-input">
								<input class="date" id="datepicker" name="dob" type="text" <%if(emp_details.getDob()==null){%>value="DD/MM/YYYY"<%}else{ %>value="<%=emp_details.getDob()%>"<%}%> onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'DD/MM/YYYY';}" required="">
							</div>
						</div>	
				<div class="clear"></div>
				<div class="gender">
					<label class="head">gender<span class="w3l-star"> * </span></label>	
						<select class="form-control" id="gender" name="gender" required="">
							<option value="Gender">Gender</option>
							<option value="Male" <%if(emp_details.getGender().equals("Male")){%>selected<%}%>>Male</option>
							<option value="Female" <%if(emp_details.getGender().equals("Female")){%>selected<%}%>>Female</option>
						</select>
				</div>
				<div class="w3l-sym">
						<label class="head">Position<span class="w3l-star"> * </span></label>
						<input type="text" name="position" placeholder="" required="" value="<%=emp_details.getPosition()%>" readonly="readonly">
				</div>
				<div class="clear"></div>
				</div>
				<div class="w3l-user">
					<label class="head">Street Address<span class="w3l-star"> * </span></label>
					<input type="text" name="address" id="streetaddress" placeholder="" required="" value="<%=emp_details.getAddress()%>">
				</div>
				<div class="w3l-num">
						<label class="head">City<span class="w3l-star"> * </span></label>
						<input type="text"  id="city" name="city" placeholder="" required="" value="<%=emp_details.getCity()%>">
					</div>
				<div class="w3l-sym">
						<label class="head">State<span class="w3l-star"> * </span></label>
						<input type="text" id="state" name="state" placeholder="" required="" value="<%=emp_details.getState()%>">
				</div>
				<div class="clear"></div>
				<div class="w3l-num">
						<label class="head">Postal / Zip Code<span class="w3l-star"> * </span></label>
						<input type="text"  id="code" name="pincode" placeholder="" required="" value="<%=emp_details.getPincode()%>">
					</div>
				<div class="w3l-sym">
						<label class="head">Country<span class="w3l-star"> * </span></label>
						<input type="text" id="country" name="country" placeholder="" required="" value="<%=emp_details.getCountry()%>">
				</div>	
				<!--<div class="w3l-options2">
				<label class="head">Country<span class="w3l-star"> * </span></label>	
					<select class="category2" required="">
							<option value=""></option>
							<option value="">Country-1</option>
							<option value="">Country-2</option>
							<option value="">Country-3</option>
							<option value="">Country-4</option>
							
						</select>
				</div>-->
				<div class="clear"></div>
				<div class="w3l-user">
					<label class="head">Resume Link<span class="w3l-star"> * </span></label>
					<input type="text" name="resume" id="resume" placeholder="" required="" value="<%=emp_details.getResume()%>">
				</div>
				<div class="clear"></div>
				<!--<div class="w3l-lef1">
					<h3>Parent/Guardian Information</h3>
				<div class="w3l-user">
					<label class="head">Name<span class="w3l-star"> * </span></label>
					<input type="text" name="Username" placeholder="" required="">
				</div>
				
					<div class="w3l-num">
						<label class="head">Home Number<span class="w3l-star"> * </span></label>
						<input type="text"  name="Home Number" placeholder="" required="">
					</div>
				<div class="w3l-sym">
						<label class="head">Emergency Number<span class="w3l-star"> * </span></label>
						<input type="text" name="Emergency Number" placeholder="" required="">
				</div>
				<div class="clear"></div>
				</div>	-->
				<div class="w3l-rem">
					<!--<div class="w3l-right">
						<label class="w3l-set2">Relationship</label>
						<textarea></textarea>
					</div>-->
					<div class="btn">
						<input type="submit" onclick="return validate_editprofile()" name="submit" value="Submit"/>
					</div>
				</div>
				<div class="clear"></div>
			</form>
		</div>
	</div>
		<!--<footer>&copy; 2018 Sports Camp Registration Form. All Rights Reserved | Design by <a href="http://w3layouts.com/"> W3layouts</a>
		</footer>-->
		<!-- Default-JavaScript --> <script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>
	
	<!-- Calendar -->
	<script src="js/jquery-ui.js"></script>
		<script>
			$(function() {
			$( "#datepicker,#datepicker1" ).datepicker({dateFormat:'dd-M-yy'});
			});
		</script>
	<!-- //Calendar -->
  </body>
</html>
