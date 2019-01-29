package objects;

public class EmployeeObj {

	private String f_name;
	private String l_name;
	private String gender;
	private String email;
	private String mobile;
	private String pswd;
	private String c_pswd;
	private String pos;
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	public String getC_pswd() {
		return c_pswd;
	}
	public void setC_pswd(String c_pswd) {
		this.c_pswd = c_pswd;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	@Override
	public String toString() {
		return "EmployeeObj [f_name=" + f_name + ", l_name=" + l_name + ", gender=" + gender + ", email=" + email
				+ ", mobile=" + mobile + ", pswd=" + pswd + ", c_pswd=" + c_pswd + ", pos=" + pos + "]";
	}
	
	
}
