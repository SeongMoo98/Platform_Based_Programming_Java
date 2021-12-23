import java.util.Scanner;


public class FactorialMain {
    public static void main(String[]args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num =scan.nextInt();
        for(int i=1; i<=10; i++) {
            System.out.println("Factorial of "+i+" = "+getFactorial(i));
        }

    }

    private static long getFactorial(final int n) {
        long factRes=1L;
        for(int j=1; j<=n;j++) {
            factRes*=j;
        }
        return factRes;
    }

}
