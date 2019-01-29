package objects;

public class Schedule {
	String emp_id;
	String s_date;
	int from_h;
	int from_m;
	int to_h;
	int to_m;
	String event;
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getS_date() {
		return s_date;
	}
	public void setS_date(String s_date) {
		this.s_date = s_date;
	}
	public int getFrom_h() {
		return from_h;
	}
	public void setFrom_h(int from_h) {
		this.from_h = from_h;
	}
	public int getFrom_m() {
		return from_m;
	}
	public void setFrom_m(int from_m) {
		this.from_m = from_m;
	}
	public int getTo_h() {
		return to_h;
	}
	public void setTo_h(int to_h) {
		this.to_h = to_h;
	}
	public int getTo_m() {
		return to_m;
	}
	public void setTo_m(int to_m) {
		this.to_m = to_m;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	@Override
	public String toString() {
		return "Schedule [emp_id=" + emp_id + ", s_date=" + s_date + ", from_h=" + from_h + ", from_m=" + from_m
				+ ", to_h=" + to_h + ", to_m=" + to_m + ", event=" + event + "]";
	}
	
}
