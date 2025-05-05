package myproject;

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.Statement;

    
    public class rename {
        public static void main(String[] args) {
            // Database credentials
            String url = "jdbc:mysql://localhost:3306/myproject";
            String user = "root";
            String password = "bmw5serice";
    
            // SQL statement to rename the column
            String renameColumnSQL = "ALTER TABLE cartable RENAME COLUMN carid TO c_id";
    
            try {
                // 1. Load the JDBC driver (optional for newer versions of Java)
                // Class.forName("com.mysql.cj.jdbc.Driver");
    
                // 2. Establish a connection
                Connection conn = DriverManager.getConnection(url, user, password);
    
                // 3. Create a prepared statement
                Statement pstmt = conn.createStatement();
    
                // 4. Set the parameters for the prepared statement
                // pstmt.setString(1, "c_id");
                // pstmt.setString(2, "carid");
    
                // 5. Execute the SQL statement
                pstmt.executeUpdate(renameColumnSQL);
    
                System.out.println("Column renamed successfully!");
    
                // 6. Close the resources
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }









    
