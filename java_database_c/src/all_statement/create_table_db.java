package all_statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class create_table_db {
    public static void main(String[]ares)throws SQLException{
        String url="jdbc:mysql://localhost:3306/jdbc";
        String username="root";
        String password="bmw5serice";
        String query="create table kamalesh(id int(10) primary key,name varchar(200) not null,age int(30),city varchar(100) not null)";

        try {
            Connection con=DriverManager.getConnection(url, username, password);   
            Statement stmt=con.createStatement();
            stmt.executeUpdate(query);
            System.out.println(" create Table sucessfully ");

            con.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
