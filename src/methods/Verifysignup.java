package methods;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verifysignup {
	
	public static boolean isValidEmail(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    } 
	
	public static boolean isValidMobile(String s) 
    { 
        // The given argument to compile() method  
        // is regular expression. With the help of  
        // regular expression we can validate mobile 
        // number.   
        // 2) Then contains 7 or 8 or 9. 
        // 3) Then contains 9 digits 
        Pattern p = Pattern.compile("[6-9][0-9]{9}"); 
  
        // Pattern class contains matcher() method 
        // to find matching between given number  
        // and regular expression 
        Matcher m = p.matcher(s); 
        return (m.find() && m.group().equals(s)); 
    }
	
	public static boolean verifyF_name(String f_name) {
		
		if(f_name.trim()==null)
		{
			return false;
		}
		return true;
	}
	public static boolean verifyL_name(String l_name) {
		
		if(l_name.trim()==null)
		{
			return false;
		}
		return true;
	}
	public static boolean verifyGender(String gender) {
	
		if(gender.equals("select_gender"))
		{
			return false;
		}
		return true;
	}
	public static boolean verifyEmail(String email) {
		
		return isValidEmail(email);
	}
	public static boolean verifyMobile(String mobile) {
		
		return isValidMobile(mobile);
		
	}
	public static boolean verifyPassword(String pswd) {
		if(pswd.trim()==null)
		{
			return false;
		}
		return true;
	}
	public static boolean verifyC_Password(String c_pswd,String pswd) {
		if(c_pswd.trim()==null||!pswd.equals(c_pswd))
		{
			return false;
		}
		return true;
	}
	public static boolean verifyPosition(String pos) {
		
		if(pos.equals("select_position"))
		{
			return false;
		}
		return true;
	}
}
