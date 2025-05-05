import java.sql.Date;

public class convert_datatype {
    public static void main(String[]args){

        String no="2000000";

        int no2=Integer.parseInt(no);
        System.out.println(no2+100);


        long val=Integer.valueOf(no);
        System.out.println(val+10);

       

    }
}
