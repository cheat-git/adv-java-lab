import java.sql.*;

public class second {

    public static void main(String[] args) {
        Connection conn = null;
        String bank_id, bank_name, bank_type, amount;

        try {
        	Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/week4cie","root","");
            conn.setAutoCommit(false); // Set auto-commit to false

            PreparedStatement ps1 = conn.prepareStatement("insert into bank values(?,?,?,?)");
            ps1.setString(1, "1");
            ps1.setString(2, "thejas");
            ps1.setString(3, "saving");
            ps1.setString(4, "10000");
            int rs1 = ps1.executeUpdate();
            System.out.println("Inserted successfully\n");

            // Details of all the bank
            ResultSet rs2 = ps1.executeQuery("select * from bank");
            while (rs2.next()) {
                bank_id = rs2.getString(1);
                bank_name = rs2.getString(2);
                bank_type = rs2.getString(3);
                amount = rs2.getString(4);
                System.out.println("Bank details:\n" + bank_id + " " + bank_name + " " + bank_type + " " + amount);
            }

            // Displaying updated data (not committed yet)
            System.out.println("\nAfter Update (Not Committed):");
            Savepoint savepoint = conn.setSavepoint("savepoint1"); // savepoint

            // Demonstrating Rollback to Savepoint
            conn.rollback(savepoint);

            // Displaying data after rollback
            System.out.println("\nAfter Rollback:");
            ResultSet rs4 = ps1.executeQuery("select * from bank");
            while (rs4.next()) {
                bank_id = rs4.getString(1);
                bank_name = rs4.getString(2);
                bank_type = rs4.getString(3);
                amount = rs4.getString(4);
                System.out.println("Bank details:\n" + bank_id + " " + bank_name + " " + bank_type + " " + amount);
            }

            // Updating amount again
            PreparedStatement ps3 = conn.prepareStatement("UPDATE bank SET amount = 15000 WHERE bank_id = 1");
            int rs3 = ps3.executeUpdate();

            // Displaying updated data (not committed yet)
            System.out.println("\nAfter Second Update (Not Committed):");
            conn.rollback(savepoint); // rollback

            // Demonstrating Commit
            conn.commit();

            // Displaying data after commit
            System.out.println("\nAfter Commit:");
            ResultSet rs5 = ps1.executeQuery("select * from bank");

            while (rs5.next()) {
                bank_id = rs5.getString(1);
                bank_name = rs5.getString(2);
                bank_type = rs5.getString(3);
                amount = rs5.getString(4);
                System.out.println("Bank details:\n" + bank_id + " " + bank_name + " " + bank_type + " " + amount);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
