package DateAndTime;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
    public static void main(String[] args){
        final Date now=new Date();
        final SimpleDateFormat format=
                new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        System.out.println("Current Date : "+format.format(now));
    }
}
