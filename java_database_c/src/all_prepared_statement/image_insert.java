package all_prepared_statement;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;
import java.sql.*;
import java.io.*;


public class image_insert {
    public static void main(String[]ares)throws SQLException{
        String url="jdbc:mysql://localhost:3306/jdbc";
        String user="root";
        String pass="#bmwm5";
        String imagepath="C:\\Users\\chris\\OneDrive\\Pictures\\bmww.jpg";
        try{
            Connection con=DriverManager.getConnection(url,user,pass);
            String query="update image set photo=? where id=1";
            PreparedStatement pstmt=con.prepareStatement(query);
            FileInputStream file=new FileInputStream(imagepath);
            pstmt.setBinaryStream(1, file,file.available());
            pstmt.executeUpdate();

            System.out.println(" update sucessfully ");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
