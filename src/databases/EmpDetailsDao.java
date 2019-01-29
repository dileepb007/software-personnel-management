package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import methods.DateConvert;
import objects.DataUpline;
import objects.EmpDetails;
import objects.EmpPar;
import objects.EmployeeObj;

public class EmpDetailsDao {

public static int insert_to_reg_table(EmpDetails obj) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
			
			String sql="update empdetails_table set F_NAME=?,L_NAME=?,MOBILE=?,DOB=?,GENDER=?,POS=?,ADDRESS=?,CITY=?,STATE=?,PINCODE=?,COUNTRY=?,RESUME=? where EMAIL=?";
			
			PreparedStatement stmt=con.prepareStatement(sql);
			
			/*System.out.println(sql);*/
			stmt.setString(1,obj.getFname());
			stmt.setString(2,obj.getLname());
			stmt.setString(3,obj.getMobile());
			stmt.setString(4,obj.getDob());
			stmt.setString(5,obj.getGender());
			stmt.setString(6,obj.getPosition());
			stmt.setString(7,obj.getAddress());
			stmt.setString(8,obj.getCity());
			stmt.setString(9,obj.getState());
			stmt.setString(10,obj.getPincode());
			stmt.setString(11,obj.getCountry());
			stmt.setString(12,obj.getResume());
			stmt.setString(13,obj.getEmail());
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

public static int delete_from_reg_table(String e_id) {
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
		
		String sql="update empdetails_table set view_flag=0 where EMAIL=?";
		
		PreparedStatement stmt=con.prepareStatement(sql);
		
		/*System.out.println(sql);*/
		stmt.setString(1,e_id);
		
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

public static int delete_from_hierarchy_table(String e_id) {
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
		
		String sql="update hierarchy_table set view_flag=0 where emp_id=?";
		
		PreparedStatement stmt=con.prepareStatement(sql);
		
		/*System.out.println(sql);*/
		stmt.setString(1,e_id);
		
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

public static  ArrayList<EmpPar> get_downline(String e_id)
{
	
	ArrayList<EmpPar> l=new ArrayList<EmpPar>();
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
		
		String sql="select emp_id,emp_name from hierarchy_table where par_id=? and view_flag = 1";
		
		PreparedStatement stmt=con.prepareStatement(sql);
		
		stmt.setString(1,e_id);
		ResultSet rs = stmt.executeQuery();
		//System.out.println("entered "+e_id);
		
		
		while(rs.next())
		{
			EmpPar o = new EmpPar();
			o.setE_name(rs.getString(1));
			
			o.setP_name(rs.getString(2));
			l.add(o);
	
		}
		rs.close();
		con.close();
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return l;
}
public static  ArrayList<String> get_all_downline(String e_id)
{
	
	ArrayList<String> l=new ArrayList<String>();
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
		
		String sql="WITH EXPL (par_id, EMP_ID, EMP_NAME,view_flag) AS (SELECT ROOT.par_id, ROOT.EMP_ID, ROOT.EMP_NAME,root.view_flag FROM   HIERARCHY_TABLE   ROOT WHERE  ROOT.par_id = ? UNION ALL SELECT CHILD.par_id, CHILD.EMP_ID, CHILD.EMP_NAME,child.view_flag FROM EXPL PARENT, HIERARCHY_TABLE CHILD WHERE  PARENT.EMP_ID = CHILD.par_id ) SELECT  DISTINCT  EMP_ID FROM EXPL where view_flag=1 ORDER BY  EMP_ID";
		
		PreparedStatement stmt=con.prepareStatement(sql);
		
		stmt.setString(1,e_id);
		ResultSet rs = stmt.executeQuery();
		
		
		//System.out.println("hi");
		while(rs.next())
		{
		   // System.out.println(rs.getString(1));
			l.add(rs.getString(1));
	
		}
		rs.close();
		con.close();
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return l;
}

public static  ArrayList<EmpDetails> get_all_downline_details(ArrayList<String> l)
{
	
	ArrayList<EmpDetails> obj=new ArrayList<EmpDetails>();
	for(int i=0;i<l.size();i++)
	{
		EmpDetails emp_details=new EmpDetails();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
			
			String sql = "select * from empdetails_table where email = ? and view_flag=1";
			
			PreparedStatement stmt=con.prepareStatement(sql);
			
			stmt.setString(1,l.get(i));
		
			ResultSet rs = stmt.executeQuery();
			
			
			
			if(rs.next())
			{
				
				emp_details.setFname(rs.getString(1));
				emp_details.setLname(rs.getString(2));
				emp_details.setEmail(rs.getString(3));
				emp_details.setMobile(rs.getString(4));
				/*emp_details.setDob(rs.getString(5));
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
				*/
				
				emp_details.setGender(rs.getString(6));
				emp_details.setPosition(rs.getString(7));
				/*emp_details.setAddress(rs.getString(8));
				emp_details.setCity(rs.getString(9));
				emp_details.setState(rs.getString(10));
				emp_details.setPincode(rs.getString(11));
				emp_details.setCountry(rs.getString(12));
				emp_details.setResume(rs.getString(13));*/
				
				/*System.out.println(emp_details.toString());*/
				obj.add(emp_details);
				rs.close();
				con.close();
				
			}
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	return obj;
}

public static  String get_upline(String e_id)
{
	
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
		
		String sql="select f.emp_name from Hierarchy_table e,Hierarchy_table f where e.par_id=f.emp_id and e.emp_id=? and e.view_flag=1";
		
		PreparedStatement stmt=con.prepareStatement(sql);
		
		stmt.setString(1,e_id);
		ResultSet rs = stmt.executeQuery();
		
		
		
		if(rs.next())
		{
		
			return rs.getString(1);
	
		}
		rs.close();
		con.close();
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return " ";
}
public static  ArrayList<DataUpline> get_data_upline(String pos)
{
	
	ArrayList<DataUpline> l=new ArrayList<DataUpline>();
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
		
		String sql=" select f_name,l_name,email from empdetails_table where pos=? and view_flag=1";
		
		PreparedStatement stmt=con.prepareStatement(sql);
		
		stmt.setString(1,pos);
		ResultSet rs = stmt.executeQuery();
		
		
		
		while(rs.next())
		{
		
			DataUpline u = new DataUpline();
			u.setEmail(rs.getString(3));
			u.setF_name(rs.getString(1));
			u.setL_name(rs.getString(2));
			l.add(u);
	
		}
		rs.close();
		con.close();
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return l;
}

}
