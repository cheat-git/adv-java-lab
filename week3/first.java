package week3;
import java.sql.*;
import java.util.*;
public class first {

	public static void main(String[] args) {
	Connection conn=null;
	Scanner sc=new Scanner(System.in);
	String    dep_id;
	String    dep_name;
	String    established;
	String    h_name;
	String    n_employees;
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/week3cie","root","");
	Statement stmt1=conn.createStatement();
	ResultSet rs1=stmt1.executeQuery("select * from department");
	while(rs1.next())
	{
		dep_id=rs1.getString(1);
	    dep_name=rs1.getString(2);
	    established=rs1.getString(3);
	    h_name=rs1.getString(4);
	    n_employees=rs1.getString(5);
	    System.out.println("department details:\n"+dep_id+" "+dep_name+" "+established+" "+h_name+" "+n_employees);
	}
	//Display details of all the Departments which are established in the year 2000 using 
	//PreparedStatement object. Read the value from the user and display appropriate 
	//message
	
	PreparedStatement ps1=conn.prepareStatement("select * from department where established=(?)");
	System.out.println("Enter the year of establish to ge details:");
	String year=sc.next();
	ps1.setString(1, year);
	ResultSet rs2=ps1.executeQuery();
	while(rs2.next())
	{
		dep_id=rs2.getString(1);
	    dep_name=rs2.getString(2);
	    established=rs2.getString(3);
	    h_name=rs2.getString(4);
	    n_employees=rs2.getString(5);
	    System.out.println("department details:\n"+dep_id+" "+dep_name+" "+established+" "+h_name+" "+n_employees);
	}
	
	//Display details of all the Departments by reading Dept_ID and Department Name from 
	//the user using PreparedStatement object
	PreparedStatement ps2=conn.prepareStatement("select * from department where dep_id=(?) and dep_name=(?) ");
	System.out.println("Enter the dep id to ge details:");
	String depa_id=sc.next();
	System.out.println("Enter the dep name to ge details:");
	String depa_name=sc.next();
	ps2.setString(1, depa_id);
	ps2.setString(2, depa_name);
	ResultSet rs3=ps2.executeQuery();
	while(rs3.next())
	{
		dep_id=rs3.getString(1);
	    dep_name=rs3.getString(2);
	    established=rs3.getString(3);
	    h_name=rs3.getString(4);
	    n_employees=rs3.getString(5);
	    System.out.println("department details:\n"+dep_id+" "+dep_name+" "+established+" "+h_name+" "+n_employees);
	}
	
	//v. Insert a new row using PreparedStatement object. Display the details
	PreparedStatement ps3=conn.prepareStatement("insert into department values(?,?,?,?,?)");
	System.out.println("Enter the dep id to ge details:");
	String depar_id=sc.next();
	System.out.println("Enter the dep name to ge details:");
	String depar_name=sc.next();
	System.out.println("Enter the dep esta to ge details:");
	String esta=sc.next();
	System.out.println("Enter the dep hname to ge details:");
	String hname=sc.next();
	System.out.println("Enter the dep nemploy to ge details:");
	String nemploy=sc.next();
	ps3.setString(1,depar_id);
	ps3.setString(2,depar_name);
	ps3.setString(3,esta);
	ps3.setString(4,hname);
	ps3.setString(5,nemploy);
	int rs4 = ps3.executeUpdate();
	ResultSet rs5 = stmt1.executeQuery("SELECT * FROM department WHERE dep_id ='"+depar_id+"'");
	while(rs5.next())
	{
		dep_id=rs5.getString(1);
	    dep_name=rs5.getString(2);
	    established=rs5.getString(3);
	    h_name=rs5.getString(4);
	    n_employees=rs5.getString(5);
	    System.out.println("department details new row added:\n"+dep_id+" "+dep_name+" "+established+" "+h_name+" "+n_employees);
	}
	}
	catch(Exception e)
	{
		System.err.println("Exception:"+e.getMessage());
	}
	}
}
