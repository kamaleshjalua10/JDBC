package all_statement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class connection_db {
    public static void main(String[]ares)throws ClassNotFoundException,SQLException{
        String url="jdbc:mysql://localhost:3306/jdbc";
        String username="root";
        String password="#bmwm5";

        // Driver manager
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println(" class founded ");
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println(e.getMessage());
        }

        // connect database 

        try{
            Connection con=DriverManager.getConnection(url, username, password);

            if(con.isClosed()){
                System.out.println(" connection is closed ");
            }
            else{
                System.out.println(" connection successfully ");
            }

            con.close();


        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
