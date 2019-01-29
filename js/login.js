function isNumberKey(evt)
{
    var charCode = (evt.which) ? evt.which : event.keyCode
    if (charCode > 31 && (charCode < 48 || charCode > 57))
        return false;
    return true;
}

function validate_login()
{
	return true;
}

function validate_signup()
{
	//gender validation
	
	var gender=$("#gender").val();
	if(gender=="select_gender")
		{
			alert("Select Gender");
			$("#gender").focus();
			return false;
		}
	
	
	//mobile number validation
	
	var mob = /^[6-9]{1}[0-9]{9}$/;
	var txtMobile = $("#mobile").val();
	if (mob.test(txtMobile.toString()) == false) {
	    alert("Please enter valid mobile number.");
	    $("#mobile").focus();
	    return false;
	}
      
    //password and confirm password validation
	var pswd,c_pswd;
	pswd=$("#password").val();
	c_pswd=$("#c_password").val();
	if(pswd!=c_pswd)
		{
			alert("Password and Confirm passwords are not same");
			$("#c_password").focus();
			return false;
		}
	
	//position validation
	var pos=$("#position").val();
	if(pos=="select_position")
		{
			alert("Select any position");
			$("#position").focus();
			return false;
		}
	return true;
}