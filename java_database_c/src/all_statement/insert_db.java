package all_statement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class insert_db {
    public static void main(String[]ares)throws ClassNotFoundException,SQLException{
        String url="jdbc:mysql://localhost:3306/jdbc";
        String username="root";
        String password="#bmwm5";
        String query="insert into kamalesh(id,name,age,city) values (1,'kamalesh',20,'tamluk'),(2,'siba',21,'moyna'),(3,'suva',22,'laluageria'),(4,'mini',23,'tamluk')";

        try{
            Connection con=DriverManager.getConnection(url,username,password);
           
            Statement stmt=con.createStatement();
            stmt.executeUpdate(query);
            System.out.println(" data insert sucessfully");


            con.close();
            stmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
