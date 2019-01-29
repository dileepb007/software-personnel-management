<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
  <head>
    <base href="<%=basePath%>">
    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

      <title>Grass login & Sign up Form a Flat Responsive Widget Template :: w3layouts </title>
      <!-- Meta tags -->
      <meta name="viewport" content="width=device-width, initial-scale=1" />
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
      <meta name="keywords" content="Grass login & Sign up Form Responsive Widget, Audio and Video players, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design"
         />
      <script>
         addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); }
      </script>
      <!-- Meta tags -->
      <!-- font-awesome icons -->
      <link href="css/font.css" rel="stylesheet" type="text/css" media="all">
      <!-- //font-awesome icons -->
      <!--stylesheets-->
      <link href="css/login.css" rel='stylesheet' type='text/css' media="all">
      <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
      <!--//style sheet end here-->
      <script src='js/login.js' type="text/javascript"></script>
      <link href="//fonts.googleapis.com/css?family=Barlow:300,400,500" rel="stylesheet">
   <script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"51561",secure:"51566"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
   <body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-3" data-genuitec-path="/spms/WebRoot/jsp/login.jsp">
     
     <script>
     <%if(request.getAttribute("id_bool")=="false"){%>
     alert("email or password is incorrect");
     <%request.removeAttribute("id_bool");}%>
     </script>
     
      <h1 class="header-w3ls" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-3" data-genuitec-path="/spms/WebRoot/jsp/login.jsp">
         Login & Sign up Form
      </h1>
      <div class="art-bothside">
         <div class="sap_tabs">
            <div id="horizontalTab">
               <ul class="resp-tabs-list">
                  <li class="resp-tab-item"><span>Login</span></li>
                  <li class="resp-tab-item"><span>Sign Up</span></li>
               </ul>
               <div class="clearfix"> </div>
               <div class="resp-tabs-container">
                  <div class="tab-1 resp-tab-content">
                     <div class="swm-right-w3ls">
                        <form action="Verify" method="get">
                           <div class="main">
                              <div class="icon-head-wthree">
                                 <h2>Login Here</h2>
                              </div>
                              <div class="form-left-w3l">
                                 <input type="email" name="email_login" placeholder="Email" required="">
                              </div>
                              <div class="form-right-w3ls ">
                                 <input type="password" name="password_login" placeholder="Password" required="">
                              </div>
                              <div class="btnn">
                                 <button type="submit" onclick="return validate_login()">LogIn</button><br>
                                 <a href="#" class="for">Forgot password...?</a>  
                              </div>
                           </div>
                        </form>
                     </div>
                  </div>
                  
                  <script>
                  	<%if(request.getAttribute("f_name_bool")=="false"){%> 
                  	alert("Please fill first name");
                  	$("#f_name").focus();
                  	<%request.removeAttribute("f_name_bool");
                  	}
                  	else if(request.getAttribute("l_name_bool")=="false"){%> 
                  	alert("Please fill last name");
                  	$("#l_name").focus();
                  	<%
                  	request.removeAttribute("l_name_bool");
                  	}
                  	else if(request.getAttribute("gender_bool")=="false"){%> 
                  	alert("Gender not selected");
                  	$("#gender").focus();
                  	<%request.removeAttribute("gender_bool");
                  	}
                  	else if(request.getAttribute("email_bool")=="false"){%>
                  	alert("Enter valid email address");
                  	$("#email").focus();
                  	<%request.removeAttribute("email_bool");
                  	}
                  	else if(request.getAttribute("mobile_bool")=="false"){%>
                  	alert("Please enter valid phone number");
                  	 $("#mobile").focus();
                  	<%request.removeAttribute("mobile_bool");
                  	}
                  	else if(request.getAttribute("password_bool")=="false"){%>
                  	alert("please enter password");
                  	$("#password").focus();
                  	<%request.removeAttribute("password_bool");
                  	}
                  	else if(request.getAttribute("c_passsword_bool")=="false"){%>
                  	alert("password and confirm password doesn't match");
                  	$("#c_password").focus();
                  	<%request.removeAttribute("c_password_bool");
                  	}
                  	else if(request.getAttribute("position_bool")=="false"){%>
                  	alert("Select any position");
                  	$("#position").focus();
                  	<%request.removeAttribute("position_bool");
                  	}
                  	else if(request.getAttribute("registered_bool")=="false"){%>
                  	alert("Already registered");
                  	<%request.removeAttribute("registered_bool");}
                  	else if(request.getAttribute("registered_bool")=="true"){%>
                  	alert("Sucessfully registered");
                  	<%request.removeAttribute("registered_bool");}%>
                  </script> 
                  <div class="tab-1 resp-tab-content">
                     <div class="swm-left-w3ls">
                        <form action="Verify" method="post" onsubmit="return ">
                           <div class="main">
                              <div class="icon-head-wthree">
                                 <h2>Sign Up Here</h2>
                              </div>
                              <div class="form-left-to-w3l">
                                 <input type="text" name="f_name" id="f_name" placeholder="First Name" required="">
                              </div>
                              <div class="form-left-to-w3l">
                                 <input type="text" name="l_name" id="l_name" placeholder="Last Name" required="">
                              </div>
                              <div >
                              	 <select id="gender" class="gender" name="gender">
  									<option value="select_gender">--Select Gender--</option>
  									<option value="male">Male</option>
  									<option value="female">Female</option>
  									<option value="others">Others</option>
								 </select>
                              </div>
                              <div class="form-left-w3l">
                                 <input type="email" name="email" placeholder="Email" required="">
                              </div>
                              <div class="form-left-w3l">
                                 <input type="tel" name="mobile" id="mobile"  placeholder="Mobile Number" max="10" onkeypress="return isNumberKey(event)"required="">
                              </div>
                              <div class="form-right-w3ls ">
                                 <input type="password" name="password" id="password" placeholder="Password" required="">
                              </div>
                              <div class="form-right-w3ls ">
                                 <input type="password" name="c_password" id="c_password" placeholder="confirm password" required="">
                              </div>
                              <div >
                              	 <select id="position" class="position" name="position">
  									<option value="select_position">--Select Position--</option>
  									<option value="software_employee">Software Employee</option>
  									<option value="team_leader">Team Leader</option>
  									<option value="project_manager">Project Manager</option>
  									<option value="administrator">Admin</option>
								 </select>
                              </div>
                              <div class="btnn">
                                 <button type="submit" onclick="return validate_signup()">Sign Up</button><br>
                              </div>
                           </div>
                        </form>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
      <!-- <div class="social-icons"> 
         <ul>
            <li>
               <a href="#">
               <span class="fab fa-facebook-f"></span>
               </a>
            </li>
            <li>
               <a href="#">
               <span class="fab fa-google-plus-g"></span>
               </a>
            </li>
            <li>
               <a href="#">
               <span class="fab fa-twitter"></span>
               </a>
            </li>
         </ul>
      </div>-->
      <div class="copy">
         <p>&copy;2018 Login & Sign up Form. All Rights Reserved | Design by Dinesh and team</p>
      </div>
      <!--js working-->
      <script src='js/jquery-2.2.3.min.js'></script>
      <!--//js working-->
      <script src="js/easyResponsiveTabs.js"></script>
      <script>
         $(document).ready(function () {
         	$('#horizontalTab').easyResponsiveTabs({
         		type: 'default', //Types: default, vertical, accordion           
         		width: 'auto', //auto or any width like 600px
         		fit: true // 100% fit in a container
         	});
         });
      </script>
   </body>
</html>
