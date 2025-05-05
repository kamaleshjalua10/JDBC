package myproject;



    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    
    public class check {
    
        public static void main(String[] args) {
            // Database credentials
            String jdbcURL = "jdbc:mysql://localhost:3306/myproject";
            String dbUser = "root";
            String dbPassword = "bmw5serice";
    
            // Input ID to be matched
            int inputID = 1;
    
            // SQL query to check if the ID exists
            String sql = "SELECT c_id FROM cartable WHERE c_id = ?";
    
            try {
                // Establish a connection to the database
                Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
    
                // Create a PreparedStatement
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, inputID);
    
                // Execute the query
                ResultSet resultSet = statement.executeQuery();
    
                // Check if the ID exists
                if (resultSet.next()) {
                    System.out.println("ID " + inputID + " exists in the database.");
                } else {
                    System.out.println("ID " + inputID + " does not exist in the database.");
                }
    
                // Close the resources
                resultSet.close();
                statement.close();
                connection.close();
    
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


