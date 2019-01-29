package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import methods.DateConvert;
import objects.EmpDetails;
import objects.Employee;
import objects.EmployeeObj;

public class LoginDao {

	
	static String sql="select * from registered_table where email=?";
	public static boolean Check_reg_table(String email)
	{
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
			
			PreparedStatement stmt=con.prepareStatement(sql);
			
			stmt.setString(1,email);
		
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next())
			{
				rs.close();
				con.close();
				return true;
			}
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return false;
	}
	
	public static void insert_to_reg_table(EmployeeObj obj) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
			
			sql="insert into registered_table values (?,?,?,?,?,?,?)";
			
			PreparedStatement stmt=con.prepareStatement(sql);
			
			stmt.setString(1,obj.getF_name());
			stmt.setString(2,obj.getL_name());
			stmt.setString(3,obj.getGender());
			stmt.setString(4,obj.getEmail());
			stmt.setString(5,obj.getMobile());
			stmt.setString(6,obj.getPswd());
			stmt.setString(7,obj.getPos());
			stmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static boolean check_in_login_table(Employee emp)
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
			
			sql="select * from login_table where email = ? and pswd = ? and view_flag=1";
			
			PreparedStatement stmt=con.prepareStatement(sql);
			
			stmt.setString(1,emp.getEmail());
			stmt.setString(2, emp.getPswd());
		
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next())
			{
				rs.close();
				con.close();
				return true;
			}
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return false;
	}
	public static EmpDetails get_empdetails_table(Employee emp)
	{
		
		EmpDetails emp_details=new EmpDetails();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
			
			sql="select * from empdetails_table where email = ? and view_flag=1";
			
			PreparedStatement stmt=con.prepareStatement(sql);
			
			stmt.setString(1,emp.getEmail());
		
			ResultSet rs = stmt.executeQuery();
			
			
			
			if(rs.next())
			{
				
				emp_details.setFname(rs.getString(1));
				emp_details.setLname(rs.getString(2));
				emp_details.setEmail(rs.getString(3));
				emp_details.setMobile(rs.getString(4));
				emp_details.setDob(rs.getString(5));
				//System.out.println(emp_details.getDob());
				if(emp_details.getDob()!=null){
				emp_details.setDob(DateConvert.convert_date("yyyy-mm-dd", "dd-mm-yyyy",emp_details.getDob()));
				
				String d=emp_details.getDob();
				
				d=d.replaceAll("-01-","-jan-");
				d=d.replaceAll("-02-","-feb-");
				d=d.replaceAll("-03-","-mar-");
				d=d.replaceAll("-04-","-apr-");
				d=d.replaceAll("-05-","-may-");
				d=d.replaceAll("-06-","-jun-");
				d=d.replaceAll("-07-","-jul-");
				d=d.replaceAll("-08-","-aug-");
				d=d.replaceAll("-09-","-sep-");
				d=d.replaceAll("-10-","-oct-");
				d=d.replaceAll("-11-","-nov-");
				d=d.replaceAll("-12-","-dec-");
				emp_details.setDob(d);
				}
				
				
				emp_details.setGender(rs.getString(6));
				emp_details.setPosition(rs.getString(7));
				emp_details.setAddress(rs.getString(8));
				emp_details.setCity(rs.getString(9));
				emp_details.setState(rs.getString(10));
				emp_details.setPincode(rs.getString(11));
				emp_details.setCountry(rs.getString(12));
				emp_details.setResume(rs.getString(13));
				
				/*System.out.println(emp_details.toString());*/
				
				rs.close();
				con.close();
				
			}
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp_details;
	}
	
public static void delete_in_login_table(String e_id) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
			
			sql="update login_table set view_flag=0 where email = ?";
			
			PreparedStatement stmt=con.prepareStatement(sql);
			
			stmt.setString(1,e_id);
			
			stmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
