package money_retrive;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
// import java.text.DecimalFormat;
import java.util.Scanner;

public class money_insert {
    public static void main(String[]ares)throws SQLException,ClassNotFoundException{

        Scanner sc=new Scanner(System.in);
        String url="jdbc:mysql://localhost:3306/amount";
        String name="root";
        String pass="#bmwm5";
       
        // try{
        //     Class.forName("com.mysql.cj.jdbc.Driver");
        //     System.out.println("class found");
        // }catch(ClassNotFoundException e ){
        //     System.out.println(e.getMessage());
        //     System.out.println("class not fount ");
        // }

        try{
            System.out.print("Enter id  : ");
            long id=sc.nextLong();

            System.out.println(" enter amount : ");
            BigDecimal amou= sc.nextBigDecimal();
         
            Connection con=DriverManager.getConnection(url,name, pass);
            String query="insert into money(id,cash)values(?,?)";
           PreparedStatement pstmt= con.prepareStatement(query);
            pstmt.setLong(1, id);
            pstmt.setBigDecimal(2, amou);

            int row=pstmt.executeUpdate();

            System.out.println(row +" row data supmited");

        }catch(Exception e){
            System.out.println(e.getMessage());
            

        }
    


    }
    
}
