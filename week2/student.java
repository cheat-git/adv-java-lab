package week2_cie;
import java.sql.*;
public class student {

    public static void main(String args[]) {
        Connection con = null;
        String name,usn,sem,cgpa;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/week2cie", "root", "");
            Statement stm=con.createStatement();
            //i.Display details of all the students using Statement Object.
            ResultSet rs=stm.executeQuery("select * from student1");
            while(rs.next())
            {
            	name=rs.getString(1);
            	usn=rs.getString(2);
            	sem=rs.getString(3);
            	cgpa=rs.getString(4);
            	System.out.println("name     usn     sem    cgpa");
            	System.out.println(name+" "+usn+" "+sem+" "+cgpa);
            }
           // ii.Display details of all the students who are in the 5th Semester
            
            ResultSet rs1=stm.executeQuery("select * from student1 where sem='5th'");
            while(rs1.next())
            {
            	name=rs1.getString(1);
            	usn=rs1.getString(2);
            	sem=rs1.getString(3);
            	cgpa=rs1.getString(4);
            	System.out.println("name     usn     sem    cgpa");
            	System.out.println(name+" "+usn+" "+sem+" "+cgpa);
            }
            //iii.Display details of all the students who have CGPA above 8.0 and are in 5th Semester
            
            ResultSet rs2=stm.executeQuery("select * from student1 where  cgpa>='8'and sem='5th'");
            while(rs2.next())
            {
            	name=rs2.getString(1);
            	usn=rs2.getString(2);
            	sem=rs2.getString(3);
            	cgpa=rs2.getString(4);
            	System.out.println("name     usn     sem    cgpa");
            	System.out.println(name+" "+usn+" "+sem+" "+cgpa);
            }
            //iv. Display the total number of students who have CGPA above 8.0
            ResultSet rs3=stm.executeQuery("select count(*) from student1 where cgpa>'8'");
            while(rs3.next())
            {
            	int count=rs3.getInt(1);
            	System.out.println(count);
            }
        }
             catch(Exception e) {
            System.err.println("Exception: " + e.getMessage());
        } 
    }
    }
