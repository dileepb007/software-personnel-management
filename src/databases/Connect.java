package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import methods.DateConvert;

public class Connect {
	
	public static ResultSet retrieve_att(String email, String from, String to) throws ClassNotFoundException, SQLException 
	{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
		
		//String email=(String)session.getAttribute("emp_email");
		 
		//String sql="select extract(hour from enter), extract(minute from enter), extract(second from enter),extract(hour from leave),extract(minute from leave), extract(second from leave) from e_attendance where email=? and extract(day from Date ?)=extract(day from enter) and extract(month from Date ?)=extract(month from enter) and extract(year from Date ?)=extract(year from enter);";
		
		
		/*String sql="select extract(hour from enter), extract(minute from enter), extract(second from enter), extract(hour from leave), extract(minute from leave), extract(second from leave), ent,lea, extract(day from enter), extract(month from enter),extract(year from enter) from e_attendance where email='"+email+"' and extract(year from Date '"+from+"')=extract(year from enter) intersect"+
" select extract(hour from enter), extract(minute from enter), extract(second from enter), extract(hour from leave), extract(minute from leave), extract(second from leave), ent,lea, extract(day from enter), extract(month from enter),extract(year from enter) from e_attendance where email='"+email+"' and extract(day from Date '"+from+"')=extract(day from enter) intersect"+
" select extract(hour from enter), extract(minute from enter), extract(second from enter), extract(hour from leave), extract(minute from leave), extract(second from leave), ent,lea, extract(day from enter), extract(month from enter),extract(year from enter) from e_attendance where email='"+email+"' and extract(month from Date '"+from+"')=extract(month from enter)";*/
		
		//System.out.println(from.charAt(9)+"From");
		String from1=from.substring(8)+"-"+from.charAt(5)+from.charAt(6)+"-"+from.charAt(0)+from.charAt(1)+from.charAt(2)+from.charAt(3);
		String to1=to.substring(8)+"-"+to.charAt(5)+to.charAt(6)+"-"+to.charAt(0)+to.charAt(1)+to.charAt(2)+to.charAt(3);
		String d=from1;
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
		from1=d;
		d=to1;
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
		to1=d;
		
		System.out.println(from1+"From1"+to1+"To1");
		String sql1="SELECT extract(hour from enter), extract(minute from enter), extract(second from enter), extract(hour from leave), extract(minute from leave), extract(second from leave), ent,lea, extract(day from enter), extract(month from enter),extract(year from enter), (extract(hour from leave-enter) + extract(minute from leave-enter)/60 + extract(second from leave-enter)/3600) from e_attendance where email='"+email+"' and "+
				"((cast(enter as date) BETWEEN '"+from1+"' AND '"+to1+"') OR "+ 
"(cast(leave as date) BETWEEN '"+from1+"' AND '"+to1+"') OR "+
"(cast(enter as date) <= '"+from1+"' AND cast(leave as date) >= '"+to1+"'))";
		
		//String sql1="SELECT extract(hour from enter), extract(minute from enter), extract(second from enter), extract(hour from leave), extract(minute from leave), extract(second from leave), ent,lea, extract(day from enter), extract(month from enter),extract(year from enter), (extract(hour from leave-enter) + extract(minute from leave-enter)/60 + extract(second from leave-enter)/3600) from e_attendance where email='"+email+"' and (cast(enter as date) between '"+from1+"' and '"+to1+"') and (cast(leave as date) between '"+from1+"' and '"+to1+"') " ;
		
		
		PreparedStatement stmt=con.prepareStatement(sql1);
		
		System.out.println(sql1+" SQL");
		
		ResultSet rs=stmt.executeQuery();
		String lea,ent;
		//con.close();
		return rs;
		
	}

}