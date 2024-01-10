import java.sql.*;

public class third {

    public static void main(String[] args) {
        Connection conn = null;
        String movie_id, movie_name, movie_genre, movie_rating, movie_year;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/week3cie", "root", "");
            Statement stmt = conn.createStatement();

            // Display details of all movies from the table
            ResultSet rs1 = stmt.executeQuery("SELECT * FROM movie");
            while (rs1.next()) {
                movie_id = rs1.getString(1);
                movie_name = rs1.getString(2);
                movie_genre = rs1.getString(3);
                movie_rating = rs1.getString(4);
                movie_year = rs1.getString(5);
                System.out.println("Movie details:" + movie_id + " " + movie_name + " " + movie_genre + " " + movie_rating + " " + movie_year);
            }

            // Display details of the 2nd Movie from the table
            ResultSet rs2 = stmt.executeQuery("SELECT * FROM movie LIMIT 1 OFFSET 1");

            while (rs2.next()) {
                movie_id = rs2.getString(1);
                movie_name = rs2.getString(2);
                movie_genre = rs2.getString(3);
                movie_rating = rs2.getString(4);
                movie_year = rs2.getString(5);
                System.out.println("Details of the 2nd Movie:" + movie_id + " " + movie_name + " " + movie_genre + " " + movie_rating + " " + movie_year);
            }
            }
         catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
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
