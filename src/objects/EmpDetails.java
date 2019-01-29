package objects;

public class EmpDetails {
	
	@Override
	public String toString() {
		return "EmpDetails [fname=" + fname + ", lname=" + lname + ", email=" + email + ", mobile=" + mobile + ", dob="
				+ dob + ", gender=" + gender + ", position=" + position + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", pincode=" + pincode + ", country=" + country + ", resume=" + resume + "]";
	}
	private String fname;
	private String lname;
	private String email;
	private String mobile;
	private String dob;
	private String gender;
	private String position;
	private String address;
	private String city;
	private String state;
	private String pincode;
	private String country;
	private String resume;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}

}
