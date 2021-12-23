package Array;
import java.util.Scanner;

public class FinalVariableParameter {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        final int n=scanner.nextInt();
        scanner.close();
        //final local variable cannot be assigned!! - 이게 무슨소리고?
        System.out.printf("Factorial of "+n+": %,20d",factorial(n));
    }
    public static long factorial(final int v){
        long result=1;
        for(int i=2; i<=v; i++) result*=i;
        return result;
    }

}
