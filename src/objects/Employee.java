package objects;

public class Employee {
	
	private String email;
	private String pswd;
	private String id;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Employee [email=" + email + ", pswd=" + pswd + ", id=" + id + "]";
	}
	
	
}
