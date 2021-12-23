package Decision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Switch_2 {
    public static void main(String[] args){
        final String[] monthStrs={"January","February","March","April",
        "May","June","July","August","September","October","November","December"};


        final int month=8;
        System.out.println(monthStrs[month-1]);

        final List<String> monthList= Arrays.asList(monthStrs);
        System.out.println(monthList.get(month-1));
    }

}
