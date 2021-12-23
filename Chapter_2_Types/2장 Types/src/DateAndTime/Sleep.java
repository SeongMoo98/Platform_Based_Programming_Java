package DateAndTime;

import java.util.Date;

public class Sleep {
    public static void main(String[]args){

        try{
            System.out.println(new Date());
            Thread.sleep(3*1000); //Throw InterruptedException
            System.out.println(new Date());
        }
        catch(Exception e){
            System.out.println("Got an Exception!");
        }
        finally {
            System.out.println("end");
        }
    }
}
