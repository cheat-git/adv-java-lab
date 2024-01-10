import java.sql.*;
public class first {

	public static void main(String[] args) {
		Connection conn =null;
		String cus_id,cus_name,type_amount,amount;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/week4cie","root","");
			Statement stmt=conn.createStatement();
			PreparedStatement ps1=conn.prepareStatement("insert into customer values(?,?,?,?)");
			int rs1=ps1.executeUpdate("insert into customer values('1','thejas','cust1','100')");
			System.out.println("inserted successfully\n");
		
			//details of the all the customers
			ResultSet rs2=stmt.executeQuery("select * from customer");
			while(rs2.next())
			{
				cus_id=rs2.getString(1);
				cus_name=rs2.getString(2);
				type_amount=rs2.getString(3);
				amount=rs2.getString(4);
			    System.out.println("customer details:\n"+cus_id+" "+cus_name+" "+type_amount+" "+amount);
			}
		
			//Demonstrate the details of the database by using DatabaseMetaData
		    DatabaseMetaData metaData=conn.getMetaData();
            System.out.println("\nDatabase Metadata:");
            System.out.println("Database Name: " + metaData.getDatabaseProductName());
            System.out.println("Database Version: " + metaData.getDatabaseProductVersion());
            System.out.println("Driver Name: " +metaData.getDriverName());
            System.out.println("Driver Version: " + metaData.getDriverVersion());
			 
            //Demonstrate the details of the ResultSet by using ResultSetMetaData
            ResultSetMetaData rsMetaData=rs2.getMetaData();
            int columnCount=rsMetaData.getColumnCount();
            for(int i=1;i<=columnCount;i++)
            {
            	System.out.println("column"+i+":"+rsMetaData.getColumnName(i)+"(type:"+rsMetaData.getColumnTypeName(i)+")");
            }
		}
		catch(Exception e)
		{
			System.err.println("Exception:"+e.getMessage());
		}
	}
	
    }


