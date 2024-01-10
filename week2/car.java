import java.sql.*;
import java.util.*;

public class car {
    public static void main(String args[]) {
        Connection con = null;
        String model, name, price, year;
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/week2cie", "root", "");
            Statement stm = con.createStatement();

            // Taking user input
            System.out.println("Enter car model:");
            model = sc.next();
            System.out.println("Enter car name:");
            name = sc.next();
            System.out.println("Enter car price:");
            price = sc.next();
            System.out.println("Enter car year:");
            year = sc.next();

            // Inserting data into the Car table
            String insertQuery = "INSERT INTO Car (Model, Name, Price, Year) VALUES ('" + model + "', '" + name + "', '" + price + "', '" + year + "')";
            int rs = stm.executeUpdate(insertQuery);
            System.out.println("Number of rows inserted: " + rs);

            // Updating data in the Car table
            String newPrice = "1000000";
            String model1 = "abcd";
            String updateQuery = "UPDATE Car SET Price='" + newPrice + "' WHERE Model='" + model1 + "'";
            int rs1 = stm.executeUpdate(updateQuery);
            System.out.println("Number of rows updated: " + rs1);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
