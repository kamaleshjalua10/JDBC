package all_statement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class rename_col {
    public static void main(String[]ares)throws SQLException{

        String url="jdbc:mysql://localhost:3306/jdbc";
        String username="root";
        String password="bmw5serice";
        String query="alter table kamalesh rename column msalary to salary";

        try{
            Connection con=DriverManager.getConnection(url,username,password);
            Statement stmt=con.createStatement();
            stmt.executeUpdate(query);
            System.out.println(" rename sucessfully");

            con.close();
            stmt.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
