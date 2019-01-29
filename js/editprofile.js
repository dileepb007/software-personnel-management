function isNumberKey(evt)
{
    var charCode = (evt.which) ? evt.which : event.keyCode
    if (charCode > 31 && (charCode < 48 || charCode > 57))
        return false;
    return true;
}

function validate_editprofile()
{
	if ($("#firstname").val()=="Null"||$("#firstname").val().trim()=="") 
	{
		alert("FIRSTNAME CANNOT BE NULL");
		$("#firstname").focus();
		return false;
	}
	if ($("#lastname").val()=="Null"||$("#lastname").val().trim()=="") 
	{
		alert("LASTNAME CANNOT BE NULL");
		$("#lastname").focus();
		return false;
	}
	var mob = /^[6-9]{1}[0-9]{9}$/;
	var txtMobile = $("#contno").val();
	if (mob.test(txtMobile.toString()) == false) 
	{
   		 alert("Please enter valid mobile number.");
   		 $("#contno").focus();
    	return false;
	}
	var dateString = document.getElementById('datepicker').value;
    var myDate = new Date(dateString);
    var today = new Date();
    if ( myDate > today ) { 
        alert("date of birth cannot be greater than current date");
        $("#datepicker").focus();
        //$('#id_dateOfBirth').after('<p>You cannot enter a date in the future!.</p>');
        return false;
    }
    var gender=$("#gender").val();
    if(gender=="Gender")
	{
		alert("Select Gender");
		$("#gender").focus();
		return false;
	}
	if ($("#streetaddress").val()=="Null"||$("#streetaddress").val().trim()=="") 
	{
		alert("STREETADDRESS CANNOT BE NULL");
		$("#streetaddress").focus();
		return false;
	}
	if ($("#city").val()=="Null"||$("#city").val().trim()=="") 
	{
		alert("CITY CANNOT BE NULL");
		$("#city").focus();
		return false;
	}
	if ($("#state").val()=="Null"||$("#state").val().trim()=="") 
	{
		alert("STATE CANNOT BE NULL");
		$("#state").focus();
		return false;
	}
	if ($("#code").val()=="Null"||$("#code").val().trim()=="") 
	{
		alert("CODE CANNOT BE NULL");
		$("#code").focus();
		return false;
	}
	if ($("#country").val()=="Null"||$("#country").val().trim()=="") 
	{
		alert("COUNTRY CANNOT BE NULL");
		$("#country").focus();
		return false;
	}
    var x=$("#resume").val();
    if ($("#resume").val()=="Null"||$("#resume").val().trim()=="") 
	{
		alert("PLEASE GIVE RESUME LINK");
		$("#resume").focus();
		return false;
	}
	return true;
}