package Decision;

import java.util.Locale;

public class Switch_4 {
    public static void main(String[] args){
        final String dayOfWeek=args[0];
        final String typeOfDay=getTypeOfDay(dayOfWeek);
        System.out.printf("10s is %20s%n",dayOfWeek,typeOfDay);
    }

    private static String getTypeOfDay(final String dayOfWeek){
        String typeOfDay;
        switch (dayOfWeek.toUpperCase()){
            case"MONDAY": typeOfDay="Start of work week"; break;
            case"TUESDAY":
            case"WEDNESDAY":
            case"THURSDAY": typeOfDay="Midweek"; break;
            case"FRIDAY": typeOfDay="End of work week"; break;
            case"SATURDAY":
            case"SUNDAY":typeOfDay="Weekend"; break;
            default:
                typeOfDay="Invalid day of the week";
                break;
        }
        return typeOfDay;
    }
}
