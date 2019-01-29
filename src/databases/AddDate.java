package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import objects.Employee;
import objects.EmployeeObj;
import objects.Schedule;

public class AddDate {
public static int insert_to_schedule_table(String emp_id,String s_date,int from_h,int from_m,int to_h,int to_m,String event) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
			
			String sql = "insert into schedule_table values (?,?,?,?,?,?,?)";
			
			PreparedStatement stmt=con.prepareStatement(sql);
			
			stmt.setString(1,emp_id);
			stmt.setString(2,s_date);
			stmt.setInt(3,from_h);
			stmt.setInt(4,from_m);
			stmt.setInt(5,to_h);
			stmt.setInt(6,to_m);
			stmt.setString(7,event);
			if(stmt.executeUpdate()>0)
				{
					con.close();
					stmt.close();
					return 1;
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}

public static ArrayList<Schedule> get_from_schedule_table(String emp_id)
{
	ArrayList<Schedule> s=new ArrayList<Schedule>();
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
		
		String sql = "select * from schedule_table where emp_id = ? ";
		
		PreparedStatement stmt=con.prepareStatement(sql);
		
		stmt.setString(1,emp_id);
		
	
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next())
		{
			Schedule o=new Schedule();
			o.setS_date(rs.getString(2));
			o.setFrom_h(rs.getInt(3));
			o.setFrom_m(rs.getInt(4));
			o.setTo_h(rs.getInt(5));
			o.setTo_m(rs.getInt(6));
			o.setEvent(rs.getString(7));
			s.add(o);
		}
		rs.close();
		con.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	return s;
}

public static boolean get_from_schedule_table(String emp_id,String event)
{
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
		
		String sql = "select * from schedule_table where emp_id = ? and event =?";
		
		PreparedStatement stmt=con.prepareStatement(sql);
		
		stmt.setString(1,emp_id);
		stmt.setString(2,event);
	
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
}
