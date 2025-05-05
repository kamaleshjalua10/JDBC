package all_statement;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;


public class delete_data {
    public  static void main(String[]ares)throws SQLException{
        String url="jdbc:mysql://localhost:3306/jdbc";
        String username="root";
        String password="bmw5serice";
        String query="delete from kamalesh where id=9";

        try{
            Connection con=DriverManager.getConnection(url, username, password);
            Statement stmt=con.createStatement();
            int row=stmt.executeUpdate(query);
            System.out.println(row+" row delete sucessfully ");

            con.close();
            stmt.close();

        }catch(Exception e){
            e.printStackTrace();
        }


    }
    
}
