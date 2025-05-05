package all_statement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;


public class get_db {
    public static void main(String[]ares)throws SQLException{
        String url="jdbc:mysql://localhost:3306/jdbc";
        String username="root";
        String password="#bmwm5";
        String query="select * from kamalesh";

        try{
            Connection con=DriverManager.getConnection(url,username,password);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);

            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                int age=rs.getInt("age");
                String city=rs.getString("city");
                String salary=rs.getString("salary");


                System.out.println();
                System.out.println("----------------");
                System.out.println();
                System.out.println(" ID     : "+id);
                System.out.println(" Name   : "+name);
                System.out.println(" Age    : "+age);
                System.out.println(" City   : "+city);
                System.out.println(" Salary : "+salary);
            }
            con.close();
            stmt.close();
            rs.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
