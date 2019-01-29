package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

public class Payroll1 {
	
	public static Double retrieve_attr(String email, String from, String to) throws ClassNotFoundException, SQLException 
	{
		Double pay=0.0;
		try
		{
			
			System.out.println("hi1");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
			
			String from1=from.substring(8)+"-"+from.charAt(5)+from.charAt(6)+"-"+from.charAt(0)+from.charAt(1)+from.charAt(2)+from.charAt(3);
			String to1=to.substring(8)+"-"+to.charAt(5)+to.charAt(6)+"-"+to.charAt(0)+to.charAt(1)+to.charAt(2)+to.charAt(3);
			System.out.println("From1"+from1+"to1"+to1);
			String sql="select sum(extract(hour from leave-enter) + extract(minute from leave-enter)/60 + extract(second from leave-enter)/3600) from e_attendance where email='"+email+"' and "+
				"((cast(enter as date) BETWEEN '"+from1+"' AND '"+to1+"') OR "+ 
				"(cast(leave as date) BETWEEN '"+from1+"' AND '"+to1+"') OR "+
				"(cast(enter as date) <= '"+from1+"' AND cast(leave as date) >= '"+to1+"'))";
			System.out.println(sql);
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			
			//rs.next();
			String time=" ";
			while(rs.next())
			{
				time=rs.getString(1);
				System.out.println(time);
			}
			System.out.println(time);
			
			Double m=Double.parseDouble(time);
			
			System.out.println("Time:"+m);
			
		    pay=Payrollpay.retrieve_attr1(email);
		    pay=pay*m;
		    System.out.println("Payments:"+pay);
		}
		catch(Exception e)
		{
			System.out.println("In Payroll1");
			e.printStackTrace();
		}
		
		return pay;
	}
}