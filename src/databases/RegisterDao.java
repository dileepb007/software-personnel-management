package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import objects.Employee;
import objects.EmployeeObj;
public class RegisterDao {
	static String sql;
	public static  ArrayList<EmployeeObj> get_empdetails_table()
	{
		
		ArrayList<EmployeeObj> l=new ArrayList<EmployeeObj>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
			
			sql="select * from registered_table";
			
			Statement stmt=con.createStatement();
			
		
			ResultSet rs = stmt.executeQuery(sql);
			
			
			
			while(rs.next())
			{
				
				EmployeeObj obj = new EmployeeObj();
				obj.setF_name(rs.getString(1));
				obj.setL_name(rs.getString(2));
				obj.setGender(rs.getString(3));
				obj.setEmail(rs.getString(4));
				obj.setMobile(rs.getString(5));
				obj.setPswd(rs.getString(6));
				obj.setPos(rs.getString(7));
				obj.toString();
				l.add(obj);
		
			}
			rs.close();
			con.close();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
	public static void insert_to_login_table(EmployeeObj obj) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
			
			sql="insert into login_table values (?,?,?,?,1)";
			
			PreparedStatement stmt=con.prepareStatement(sql);
			
			stmt.setString(1,"null");
			stmt.setString(2,obj.getEmail());
			stmt.setString(3,obj.getPswd());
			stmt.setString(4,obj.getPos());
			stmt.executeUpdate();
			
			stmt.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void insert_to_empdetails_table(EmployeeObj obj) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
			
			sql="insert into empdetails_table(f_name,l_name,email,mobile,gender,pos,view_flag) values (?,?,?,?,?,?,1)";
			
			PreparedStatement stmt=con.prepareStatement(sql);
			
			stmt.setString(1,obj.getF_name());
			stmt.setString(2,obj.getL_name());
			stmt.setString(3,obj.getEmail());
			stmt.setString(4,obj.getMobile());
			stmt.setString(5,obj.getGender());
			stmt.setString(6,obj.getPos());
			stmt.executeUpdate();
			
			stmt.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
public static void insert_to_photo_table(String email) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
			
			sql="insert into photo_table(email) values (?)";
			
			PreparedStatement stmt=con.prepareStatement(sql);
			
			stmt.setString(1,email);
			stmt.executeUpdate();
			
			stmt.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
public static void insert_to_hierarchy_table(String email,String pos,String par,String name) {
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
		
		sql="insert into hierarchy_table values (?,?,?,?,1)";
		
		PreparedStatement stmt=con.prepareStatement(sql);
		
		stmt.setString(1,email);
		stmt.setString(2,pos);
		stmt.setString(3,name);
		stmt.setString(4,par);
		stmt.executeUpdate();
		
		stmt.close();
		con.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

	public static void delete_from_reg_table(String email) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
			
			sql="delete from registered_table where email=?";
			
			PreparedStatement stmt=con.prepareStatement(sql);
			
			stmt.setString(1,email);
			
			stmt.executeUpdate();
			
			stmt.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
