package Operation;

import java.util.Scanner;

public class StringCompareMain {
    public static void main(String[] args){

        Scanner scanner=new Scanner(System.in);
        final String msg=scanner.nextLine();
        final String MSG=scanner.nextLine();

        boolean result;
        if(msg.equals(MSG)) {
            result=true;
            System.out.println(result);
        }
        else {
            result=false;
            System.out.println(result);
        }

        if(msg.equalsIgnoreCase(MSG))
        {
            result=true;
            System.out.println(result);
        }
        else {
            result=false;
            System.out.println(result);
        }

        final String MSG2=MSG;
        MSG2.toLowerCase();
        if(msg.equalsIgnoreCase(MSG2)) {
            result=true;
            System.out.println(result);
        }
        else {
            result=false;
            System.out.println(result);
        }


        final String msg2=msg.replace("easy","fun");
        if(MSG.equalsIgnoreCase(msg2))
        {
            result=true;
            System.out.println(result);
        }
        else{
            result=false;
            System.out.println(result);
        }

        scanner.close();

    }
}
