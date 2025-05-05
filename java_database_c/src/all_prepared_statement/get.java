package all_prepared_statement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;


public class get {
    public static void main(String[]ares)throws SQLException{
        String url="jdbc:mysql://localhost:3306/jdbc";
        String username="root";
        String password="#bmwm5";
        int no=1;
        String n="kamalesh";
        String query="select id,name,age from kamalesh where id=? and name=?";

        try{
            Connection con=DriverManager.getConnection(url,username,password);
            PreparedStatement pstmt=con.prepareStatement(query);
            pstmt.setInt(1, no);
            pstmt.setString(2, n);
            ResultSet rs=pstmt.executeQuery();

            if(rs.next()){
            
                int age=rs.getInt("age");
                int sum=age+200;

                String q2=" update kamalesh set age= ? where id= ?";
                PreparedStatement pstmt2=con.prepareStatement(q2);
                pstmt2.setInt(1, sum);
                pstmt2.setInt(2, no);
                pstmt2.executeUpdate();
                System.out.println("successfully ");
            }
            else{
                System.out.println(" not Exist ");
            }
            con.close();
            pstmt.close();
            rs.close();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
