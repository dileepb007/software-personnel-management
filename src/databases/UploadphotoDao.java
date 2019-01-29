package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import objects.EmpDetails;

public class UploadphotoDao {
public static int insert_photo(String email,String pic) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
			
			String sql="update photo_table set photo=? where email=?";
			
			PreparedStatement stmt=con.prepareStatement(sql);
			
			/*System.out.println(sql);*/
			stmt.setString(1,pic);
			stmt.setString(2,email);
			if(stmt.executeUpdate()>0)
			{
				return 1;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
		
	}

public static String get_photo(String email) {
	
	String photo="";
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
		
		String sql="select * from photo_table where email=?";
		
		PreparedStatement stmt=con.prepareStatement(sql);
		
		/*System.out.println(sql);*/
		stmt.setString(1,email);
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next())
		{
			photo=rs.getString(2);
		}
		
		//System.out.println(photo);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return photo;
	
}
}
