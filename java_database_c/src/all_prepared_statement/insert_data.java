package all_prepared_statement;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class insert_data {
    public static void main(String[]ares)throws SQLException{
        String url="jdbc:mysql://localhost:3306/jdbc";
        String username="root";
        String password="#bmwm5";
 
        try{
            Connection con=DriverManager.getConnection(url, username, password);
            String query="insert into kamalesh(id,name,age,city,salary)values(?,?,?,?,?)";    
            PreparedStatement pstmt=con.prepareStatement(query);
  
            pstmt.setInt(1, 6);
            pstmt.setString(2, "sandy");
            pstmt.setInt(3, 23);
            pstmt.setString(4,"laluageria");
            pstmt.setString(5,"75000");

            pstmt.executeUpdate();

            System.out.println("sucessfully");
            con.close();
            pstmt.close();

        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
