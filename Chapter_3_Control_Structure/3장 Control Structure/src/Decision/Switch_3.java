package Decision;

import java.util.ArrayList;
import java.util.List;

public class Switch_3 {
    public static void main(String[] args){
        final List<String> futureMonths=new ArrayList<>();
        final int month=8;
        switch (month){
            case 1:futureMonths.add("January");
            case 2:futureMonths.add("February");
            case 3:futureMonths.add("March");
            case 4:futureMonths.add("April");
            case 5:futureMonths.add("May");
            case 6:futureMonths.add("June");
            case 7:futureMonths.add("July");
            case 8:futureMonths.add("August");
            case 9:futureMonths.add("September");
            case 10:futureMonths.add("October");
            case 11:futureMonths.add("November");
            case 12:futureMonths.add("December");
                break;
            default: break;
        }
        for(final String monthName:futureMonths){
            System.out.println(monthName);
        }
    }
}
