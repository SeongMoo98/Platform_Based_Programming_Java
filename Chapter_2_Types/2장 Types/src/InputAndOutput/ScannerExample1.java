package InputAndOutput;

import java.util.Scanner;

public class ScannerExample1 {
    public static void main(String[] args){
        final Scanner scanner=new Scanner(System.in);

        System.out.print("What is your name? ");
        final String name=scanner.nextLine();

        System.out.print("How old are you? ");
        final int age=scanner.nextInt();

        System.out.println("Hello"+name+". Next year, you'll be"+(age+1));

        scanner.close();
    }
}
