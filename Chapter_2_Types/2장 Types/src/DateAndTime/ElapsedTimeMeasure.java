package DateAndTime;

import java.util.Date;

public class ElapsedTimeMeasure {
    public static void main(String[] args){
        try{
            final long start=System.currentTimeMillis();
            System.out.println(new Date());

            Thread.sleep(3*1000);
            System.out.println(new Date());

            final long end=System.currentTimeMillis();
            System.out.println("Difference is : "+(end-start));
        }
        catch(Exception e){
            System.out.println("Got an Exception!");
        }

    }
}
