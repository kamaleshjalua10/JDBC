package all_prepared_statement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class dy_delete_data {
    public static void main(String[]ares)throws SQLException{
        Scanner sc=new Scanner(System.in);
        String url="jdbc:mysql://localhost:3306/jdbc";
        String username="root";
        String password="bmw5serice";
        System.out.print(" Enter delete ID : ");
        int id=sc.nextInt();

        try{
            Connection con=DriverManager.getConnection(url,username,password);
            String query=" delete from kamalesh where id=?";
            PreparedStatement pstmt=con.prepareStatement(query);
            pstmt.setInt(1,id);
            int row=pstmt.executeUpdate();
            System.out.println(row +" row delete sucessfully ");

            con.close();
            pstmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
