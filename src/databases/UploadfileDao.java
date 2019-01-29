package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UploadfileDao {
	static String sql;
	public static int insert_file(String project,String file,String emp_id) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
			
			sql="insert into project_table values (?,?,?)";
			
			PreparedStatement stmt=con.prepareStatement(sql);
			
			stmt.setString(1,project);
			stmt.setString(2,file);
			stmt.setString(3,emp_id);
			
			return stmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	public static void delete_file(String project) {
		sql="delete from project_table where p_name=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
			
			PreparedStatement stmt=con.prepareStatement(sql);
			
			stmt.setString(1,project);
		
			stmt.executeUpdate();
			
			stmt.close();
			con.close();
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static boolean check_project(String project)
	{
		sql="select * from project_table where p_name=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
			
			PreparedStatement stmt=con.prepareStatement(sql);
			
			stmt.setString(1,project);
		
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
