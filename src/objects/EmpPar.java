package objects;



public class EmpPar {

	private String e_name;
	private String p_name;
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	@Override
	public String toString() {
		return "EmpPar [e_name=" + e_name + ", p_name=" + p_name + "]";
	}
	
}
