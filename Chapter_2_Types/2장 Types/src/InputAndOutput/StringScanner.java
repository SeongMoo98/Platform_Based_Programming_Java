package InputAndOutput;

import java.util.Scanner;

public class StringScanner {
    public static void main(String[] args){
        final String message="Hello World\nWelcome Java!";
        final Scanner scanner=new Scanner(message);


        while(scanner.hasNext()){
            final String word=scanner.next();
            System.out.println(word);
        }
        scanner.close();

    }
}
