package InputAndOutput;

import java.util.Scanner;

public class ScannerExample2 {
    public static void main(String[]args){
        final Scanner scanner=new Scanner(System.in);

        System.out.println("Enter two Integers! ");
        final int n1=scanner.nextInt();
        final int n2=scanner.nextInt();
        System.out.println("Enter operator: [+,-] ! ");
        final String strOp=scanner.next();
        scanner.close();

        final char charOp=strOp.charAt(0);
        int result;
        switch (charOp){
            case '+': result=n1+n2; break;
            case '-': result=n1-n2; break;
            default: result=0; break;
        }
        System.out.println(result);

    }
}
