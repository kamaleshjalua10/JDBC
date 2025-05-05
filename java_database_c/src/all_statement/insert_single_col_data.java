package all_statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;


public class insert_single_col_data {
    public static void main (String[]ares)throws SQLException{
        String url="jdbc:mysql://localhost:3306/jdbc";
        String username="root";
        String password="bmw5serice";
        String query="update kamalesh set salary ='100000' where id=1";

        try{
            Connection con=DriverManager.getConnection(url,username,password);
            Statement stmt=con.createStatement();
            stmt.executeUpdate(query);
            System.out.println(" insert sucessfully ");

            con.close();
            stmt.close();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }


    }
}
