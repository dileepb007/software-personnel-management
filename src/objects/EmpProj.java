package objects;

public class EmpProj {
	private String p_name;
	private String emp_id;
	private String emp_name;
	private String pos;
	private String module;
	private String p_status;
	private String m_status;
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getP_status() {
		return p_status;
	}
	public void setP_status(String p_status) {
		this.p_status = p_status;
	}
	public String getM_status() {
		return m_status;
	}
	public void setM_status(String m_status) {
		this.m_status = m_status;
	}
	@Override
	public String toString() {
		return "EmpProj [p_name=" + p_name + ", emp_id=" + emp_id + ", emp_name=" + emp_name + ", pos=" + pos
				+ ", module=" + module + ", p_status=" + p_status + ", m_status=" + m_status + "]";
	}
	
	
}
