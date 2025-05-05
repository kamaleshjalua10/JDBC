package all_prepared_statement;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
// import java.sql.SQLException;
import java.sql.Connection;
import java.util.Scanner;


public class dynamic_insert {

    public static void main (String[]ares)throws Exception{
        Scanner sc=new Scanner(System.in);

        String url="jdbc:mysql://localhost:3306/jdbc";
        String username="root";
        String password="bmw5serice";
       
        
        System.out.print(" Enter id : ");
        int id=sc.nextInt();

        System.out.print(" Enter name : ");
        String name=sc.next();

        System.out.print(" Enter age : ");
        int age=sc.nextInt();

        System.out.print(" Enter city : ");
        String city=sc.next();

        System.out.print(" Enter salary : ");
        String salary=sc.next();

        try{
            Connection con=DriverManager.getConnection(url, username, password);
            String query="insert into kamalesh(id,name,age,city,salary)values(?,?,?,?,?)";
                  
            PreparedStatement pstmt=con.prepareStatement(query);
  
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);
            pstmt.setString(4,city);
            pstmt.setString(5,salary);
            

            int row =pstmt.executeUpdate();

            System.out.println(row+"row data insert sucessfully");
            con.close();
            pstmt.close();

        }catch(Exception e){
            e.printStackTrace();
        }


    }
}

