import java.sql.*;
import java.util.*;
public class second {

	public static void main(String[] args) {
		Connection conn=null;
		String sub_code,sub_name,department	,credits;
		Scanner sc=new Scanner(System.in);
		try 
		{
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/week3cie","root","");
	    Statement stmt=conn.createStatement();
	    
	    //Update the Name of the subject from “adv java lab” to “adv Java 
	    //Programming Lab” with Code as 3.
	    int rs2=stmt.executeUpdate("update subject set sub_name='adv Java' where sub_code='1'");
	    System.out.println("updated successfully:");
	    ResultSet rs1=stmt.executeQuery("select * from subject");
	    while(rs1.next())
		{
	    	sub_code=rs1.getString(1);
	    	sub_name=rs1.getString(2);
	    	department=rs1.getString(3);
	    	credits=rs1.getString(4);
		    System.out.println("subject details:\n"+sub_code+" "+sub_name+" "+department+" "+credits);
		}
	    
	    //. Delete the subject “System Programming” from the table. Use PreparedStatement
	    PreparedStatement ps1=conn.prepareStatement("select * from subject where sub_code='?' and sub_name='?'" );
	    int rs3=ps1.executeUpdate("delete from subject where sub_code=2 and sub_name='ai aand ml'");
	    System.out.println("deleted successfully:");
	    ResultSet rs4=ps1.executeQuery("select * from subject");
		 while(rs4.next())
			{
		    	sub_code=rs4.getString(1);
		    	sub_name=rs4.getString(2);
		    	department=rs4.getString(3);
		    	credits=rs4.getString(4);
			    System.out.println("subject details:\n"+sub_code+" "+sub_name+" "+department+" "+credits);
			}
		 
		// . Display details of all the Subjects.
		    ResultSet rs5=stmt.executeQuery("select * from subject");
		    while(rs5.next())
			{
		    	sub_code=rs5.getString(1);
		    	sub_name=rs5.getString(2);
		    	department=rs5.getString(3);
		    	credits=rs5.getString(4);
			    System.out.println("subject details:\n"+sub_code+" "+sub_name+" "+department+" "+credits);
			}
		    

	   }
		catch(Exception e)
		{
			System.err.println("Exception:"+e.getMessage());
		}
	}

}
