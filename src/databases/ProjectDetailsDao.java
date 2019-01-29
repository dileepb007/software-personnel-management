package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import objects.EmpProj;
import objects.EmployeeObj;

public class ProjectDetailsDao {
static String sql;
public static ArrayList<String> get_from_project_table(String p_name,String emp_id)
{
	ArrayList<String> l=new ArrayList<String>();
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
		
		sql="select * from project_table where p_name='"+p_name+"' and emp_id='"+emp_id+"'";
		
		Statement stmt=con.createStatement();
		
	
		ResultSet rs = stmt.executeQuery(sql);
		
		
		
		while(rs.next())
		{
			l.add(rs.getString(2));
		}
		rs.close();
		con.close();
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return l;
}
public static ArrayList<String> get_project_from_emp_project_table(String e_id)
{
	ArrayList<String> l=new ArrayList<String>();
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
		
		sql="select p_name from emp_project_table where emp_id='"+e_id+"'";
		
		Statement stmt=con.createStatement();
		
	
		ResultSet rs = stmt.executeQuery(sql);
		
		
		
		while(rs.next())
		{
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

	public static int insert_in_emp_project_table(String e_id,String p_name) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
			
			sql="insert into emp_project_table(emp_id,p_name) values(?,?)";
			
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1,e_id);
			stmt.setString(2,p_name);
			
			if(stmt.executeUpdate()>0)
			{
				stmt.close();
				con.close();
				return 1;
			}
	
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	public static int insert_in_project_table(String p_name) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
			
			sql="insert into project_table (p_name)  values(?)";
			
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1,p_name);
			if(stmt.executeUpdate()>0)
			{
				stmt.close();
				con.close();
				return 1;
			}
	
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public static int update_in_emp_project_table(String emp_id,String p_name,String m,String p) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
			
			sql="update emp_project_table set m_status=?,p_status=? where p_name=? and emp_id=?";
			
			PreparedStatement stmt=con.prepareStatement(sql);
			System.out.println(emp_id);
			System.out.println(p_name);
			System.out.println(m);
			System.out.println(p);
			stmt.setString(1,m);
			stmt.setString(2,p);
			stmt.setString(3,p_name);
			stmt.setString(4,emp_id);
			
			if(stmt.executeUpdate()>0)
			{
				stmt.close();
				con.close();
				return 1;
			}
	
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public static int insert_modules_in_emp_project_table(String e_id,String p_name,String m_name) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
			
			sql="insert into emp_project_table (emp_id,p_name,module) values(?,?,?)";
			
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1,e_id);
			stmt.setString(2,p_name);
			stmt.setString(3,m_name);
			if(stmt.executeUpdate()>0)
			{
				stmt.close();
				con.close();
				return 1;
			}
	
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public static ArrayList<EmpProj> get_from_emp_project_table(String e_id)
	{
		ArrayList<EmpProj> l=new ArrayList<EmpProj>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
			
			sql="select a.p_name,a.module,a.m_status,a.p_status,b.f_name,b.l_name,b.email,b.pos from emp_project_table a,EMPDETAILS_TABLE b where a.emp_id=b.email and a.emp_id='"+e_id+"'";
			
			Statement stmt=con.createStatement();
			
		
			ResultSet rs = stmt.executeQuery(sql);
			
			
			
			while(rs.next())
			{
				EmpProj obj = new EmpProj();
				obj.setP_name(rs.getString(1));
				obj.setP_status(rs.getString(4));
				obj.setM_status(rs.getString(3));
				obj.setModule(rs.getString(2));
				obj.setEmp_id(rs.getString(7));
				obj.setEmp_name(rs.getString(5)+" "+rs.getString(6));
				obj.setPos(rs.getString(8));
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
	public static ArrayList<EmpProj> get_pastprojects_from_emp_project_table(String e_id)
	{
		ArrayList<EmpProj> l=new ArrayList<EmpProj>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
			
			sql="select a.p_name,a.module,a.m_status,a.p_status,b.f_name,b.l_name,b.email,b.pos from emp_project_table a,EMPDETAILS_TABLE b where a.emp_id=b.email and a.emp_id='"+e_id+"' and p_status='yes'";
			
			Statement stmt=con.createStatement();
			
		
			ResultSet rs = stmt.executeQuery(sql);
			
			
			
			while(rs.next())
			{
				EmpProj obj = new EmpProj();
				obj.setP_name(rs.getString(1));
				obj.setP_status(rs.getString(4));
				obj.setM_status(rs.getString(3));
				obj.setModule(rs.getString(2));
				obj.setEmp_id(rs.getString(7));
				obj.setEmp_name(rs.getString(5)+" "+rs.getString(6));
				obj.setPos(rs.getString(8));
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
	public static boolean Check_emp_project_table(String p_name)
	{
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
			sql="select p_name from emp_project_table where p_name=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			
			stmt.setString(1,p_name);
		
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
	public static boolean Check_pro_in_emp_project_table(String p_name,String e_id)
	{
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dinesh","dinesh");
			sql="select p_name from emp_project_table where p_name=? and emp_id=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			
			stmt.setString(1,p_name);
		
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
