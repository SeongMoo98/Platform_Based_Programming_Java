package Loop;

import java.util.ArrayList;
import java.util.List;

public class ForLoop_3 {
    public static void main(String[] args){
        final List<String> messages=new ArrayList<>();
        messages.add("Hello");
        messages.add("자바\tGreat");
        messages.add("\t10 !");

        int wordCount=0, charCount=0;
        for(final String message:messages){
            System.out.println(message);
            wordCount++;
            charCount+=message.trim().length();
        }

        System.out.println("Word : "+wordCount+", Chars : "+charCount);
    }
}
