package money_retrive;

import java.math.BigDecimal;
// import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class money_get {
    public  static void main(String[]ares) throws SQLException ,ClassNotFoundException,NumberFormatException{
        int data=100;
        String url="jdbc:mysql://localhost:3306/amount";
        String name="root";
        String pass="#bmwm5";
        String query="select cash from money where id=1234567891";


        try{
            Connection con=DriverManager.getConnection(url, name, pass);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);

            while(rs.next()){
                // long idd=rs.getLong("id");
                BigDecimal cashs=rs.getBigDecimal("cash");
                //  Deposite      and  Creadit 

                // BigDecimal kj= BigDecimal.valueOf(data);

                // BigDecimal rk=cashs.add(kj);

                BigDecimal rk2=cashs.add(BigDecimal.valueOf(data));
               
                
                // System.out.println(" ID : "+ idd);
                System.out.println(" CASH : "+ cashs);
                System.out.println(rk2);
                
                System.out.println("------------------");

            }
          

        }catch(Exception e){

            System.out.println(e.getMessage());

        }

    }
    
}
