package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Deletedate {
	public static int delete_from_reg_table(String e_id,String event) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
			
			String sql="delete from schedule_table where emp_id=? and event=?";
			
			PreparedStatement stmt=con.prepareStatement(sql);
			
			/*System.out.println(sql);*/
			stmt.setString(1,e_id);
			stmt.setString(2,event);
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
}
