package Decision;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Switch_5 {
    private static final Map<String,String> typeOfDayMap=new HashMap<>();

    static {
        typeOfDayMap.put("MONDAY","Start of work week");
        typeOfDayMap.put("TUESDAY","Midweek");
        typeOfDayMap.put("WEDNESDAY","Midweek");
        typeOfDayMap.put("THURSDAY","Midweek");
        typeOfDayMap.put("FRIDAY","End of work week");
        typeOfDayMap.put("SATURDAY","Weekend");
        typeOfDayMap.put("SUNDAY","Weekend");
    }

    public static void main(String[] args){
        final String dayOfWeek=args[0];
        final String typeOfDay=getTypeOfDay(dayOfWeek);
        System.out.printf("10s is %20s%n",dayOfWeek,typeOfDay);
    }

    private static String getTypeOfDay(final String dayOfWeek){
        String typeOfDay=typeOfDayMap.get(dayOfWeek.toUpperCase());
        return ( typeOfDay != null) ? typeOfDay : "Invalid day of the week";
    }

}
