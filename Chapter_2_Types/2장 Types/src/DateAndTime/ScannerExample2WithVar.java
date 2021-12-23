package DateAndTime;

import java.util.Scanner;

public class ScannerExample2WithVar {
    public static void main(String[] args){
        final var scanner=new Scanner(System.in);

        System.out.println("Enter two Integers!");
        final var n1=scanner.nextInt();
        final var n2=scanner.nextInt();
        System.out.println("Enter operator : [+,-]!");
        final var strOp=scanner.next();
        scanner.close();

        final var charOp=strOp.charAt(0);
        var result=0;
        switch (charOp){
            case '+':result=n1+n2; break;
            case '-':result=n1-n2; break;
            default:break;
        }
        System.out.println(result);
    }
}
