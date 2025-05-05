package myproject;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbc_carsystem {

    public static void homepage(Connection lcon,Scanner lsc)throws SQLException{
        while(true){
            System.out.println();
            System.out.println(" --------------------  HOME PAGE  -----------------");
            System.out.println(" 1 : insert data    2: delete data     3 : get data");
            System.out.println(" 4 : update data    5 :exit");
            System.out.print(" Enter Choice : ");
            int choice=lsc.nextInt();
            switch(choice){
                case 1:insertdata(lcon,lsc);
                    break;
                case 2: deletedata(lcon,lsc);
                    break;    
                case 3:getdata(lcon);
                    break; 
                case 4: updatedata(lcon,lsc);
                    break;
                case 5:return;    
              
                default:System.out.println(" Enter valid Option ");

            }
            
        }

    }

    public static void insertdata(Connection icon,Scanner isc)throws SQLException{
        System.out.print(" Enter car ID : ");
        int cid=isc.nextInt();
        try{
        String insquery="select c_id from cartable where c_id=?";
        PreparedStatement instmt=icon.prepareStatement(insquery);
        instmt.setInt(1, cid);
        ResultSet rs=instmt.executeQuery();
            if(rs.next()){    
                System.out.println(" ID Aldrady Exits ");
            }
            else{
             
            System.out.print(" Enter car Name : ");
            String cname=isc.next();
            System.out.print(" Enter car Owner name : ");
            String cowner=isc.next();
            System.out.print(" Enter car Price : ");
            double cprice=isc.nextDouble();
            System.out.print(" Enter car Country : ");
            String ccountry=isc.next();

            
                String query="insert into cartable(c_id,c_name,c_owner,c_price,c_country) values(?,?,?,?,?)";
                PreparedStatement pstmt=icon.prepareStatement(query);
                pstmt.setInt(1, cid);
                pstmt.setString(2, cname);
                pstmt.setString(3, cowner);
                pstmt.setDouble(4, cprice);
                pstmt.setString(5, ccountry);

                int row =pstmt.executeUpdate();
        
                System.out.println(" data insert sucessfully ");
            }

        }catch(Exception e){
            e.printStackTrace();
        
        }

    }

    public static void deletedata(Connection dcon,Scanner dsc)throws SQLException{       
        System.out.print(" enter delete id : ");
        int id=dsc.nextInt();
        try{
            String query="select c_id from cartable where c_id=?";
            PreparedStatement pstmt=dcon.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs=pstmt.executeQuery();
          
            if(rs.next()){
                String deleteq="delete from cartable where c_id=?";
                PreparedStatement pstmt2=dcon.prepareStatement(deleteq);
                pstmt2.setInt(1,id);
                pstmt2.executeUpdate();
                System.out.println(" delete  sucessfully ");
            }
            else{
                System.out.println(" Invalid  CAR  ID   ");
            }
    
       }catch(Exception e){
        e.printStackTrace();
       }
    }

    public static void getdata(Connection gcon)throws SQLException{

        try{       
            String query="select * from cartable";
            Statement stmt=gcon.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println(" C_Id      |     C_Name      |    C_Owner     |    C_Price     |    C_Country    |");
            System.out.println("----------------------------------------------------------------------------------");
            while(rs.next()){
                int id=rs.getInt("c_id");
                String name=rs.getString("c_name");
                String owner=rs.getString("c_owner");
                double price=rs.getDouble("c_price");
                String country=rs.getString("c_country");

                System.out.print("  " +id +"        ");
                System.out.print("  |   "+name+"          ");
                System.out.print("|  "+owner+"      ");
                System.out.print("|  "+price+"     ");
                System.out.print(" |  "+country);
                System.out.println();
            }
      
        }catch(Exception e){
            e.printStackTrace();
        }

    }
 
    public static void updatedata(Connection ucon,Scanner usc)throws SQLException{

        System.out.println(" Enter car ID : ");
        int carid=usc.nextInt();
        try{
            String checkquery=" select c_id from cartable where c_id=?";
            PreparedStatement cstmt=ucon.prepareStatement(checkquery);
            cstmt.setInt(1, carid);
            ResultSet rs=cstmt.executeQuery();

            if(rs.next()){
                System.out.println();
                System.out.println("--------------     UPDATE TYPE   -------------------");
                System.out.println(" 1 : Car Name update     2 : Owner Name update    3 : Car price Update ");
                System.out.println(" 4 : Car Country update  5 : Update continue      6 : Home page ");
                System.out.print(" Enter choice : ");
                int choice=usc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print(" Enter new car Name : ");
                        String carname=usc.next();
                        String carnamequery="update cartable set c_name = ? where c_id =?";
                        PreparedStatement cnamepstmt=ucon.prepareStatement(carnamequery);
                        cnamepstmt.setString(1, carname);
                        cnamepstmt.setInt(2, carid);
                        cnamepstmt.executeUpdate();
                        System.out.println(" Car Name update sucessfully ");

                     break;
                    case 2:
                        System.out.print(" Enter new owner name : ");
                        String owner=usc.next();
                        String ownerquery=" update cartable set c_owner=? where c_id=?";
                        PreparedStatement ownerpstmt=ucon.prepareStatement(ownerquery);
                        ownerpstmt.setString(1,owner);
                        ownerpstmt.setInt(2,carid);
                        ownerpstmt.executeUpdate();
                        System.out.println(" Owner name update sucessfully ");
                                
                    break;
                    case 3:
                    System.out.print(" Enter new price : ");
                    Double price=usc.nextDouble();
                    String pricequery=" update cartable set c_price=? where c_id=?";
                    PreparedStatement pricepstmt=ucon.prepareStatement(pricequery);
                    pricepstmt.setDouble(1, price);
                    pricepstmt.setInt(2,carid);
                    pricepstmt.executeUpdate();
                    System.out.println(" Price update sucessfully ");
                        
                        break;
                    case 4:
                    System.out.print(" Enter new Country : ");
                    String country=usc.next();
                    String countryquery=" update cartable set c_country=? where c_id=?";
                    PreparedStatement countrypstmt=ucon.prepareStatement(countryquery);
                    countrypstmt.setString(1, country);
                    countrypstmt.setInt(2,carid);
                    countrypstmt.executeUpdate();
                    System.out.println(" Price update sucessfully ");
                        break;
                    case 5:updatedata(ucon, usc);
                        break;
                    case 6:homepage(ucon, usc); 
                    break;                            
                    default:System.out.println(" Enter valid option ");
                        break;                       
                }
            }
            else{
                System.out.println(" Invalid  CAR  ID  ");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }            
    }
 
    public static void main(String[]ares)throws SQLException{

        String url="jdbc:mysql://localhost:3306/myproject";
        String username="root";
        String password="bmw5serice";

        try{
            Scanner sc=new Scanner(System.in);
            Connection con=DriverManager.getConnection(url, username, password);

            homepage(con,sc);

        }catch(Exception e){
            e.printStackTrace();
        }


    }


}
