package Loop;

import java.util.ArrayList;
import java.util.List;

public class ForLoop_4 {
    public static void main(String[] args){
        final List<String> messages=new ArrayList<>();

        messages.add("Hello");
        messages.add("Java");

        for(final String message: messages){
            final char[] charArray=message.toCharArray();
            for(final char aChar : charArray){
                System.out.print(Character.toUpperCase(aChar));
            }
            System.out.println();
        }
    }

}
