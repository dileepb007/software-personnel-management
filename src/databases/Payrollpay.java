package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Payrollpay {
	
	public static Double retrieve_attr1(String email) throws ClassNotFoundException, SQLException 
	{
		Double pay=0.0;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
			String sql="select pay from payroll where email='"+email+"'";
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			System.out.println(email);
			System.out.println(sql);
			String pays=" ";
			while(rs.next())
			{
				System.out.println("ho");
				pays=rs.getString(1);
				System.out.println(pays);
			}
			System.out.println(pays);
			pay=Double.parseDouble(pays);
			System.out.println("Payment:"+pay);
			
			//con.close();
		}
		catch(Exception e)
		{
			System.out.println("In payrollpay");
			e.printStackTrace();
		}
		//pay=2000.0;
		return pay;
	}

}