package Operation;

import java.util.Scanner;

public class OperatorMain {
    public static void main(String[]args){
        final Scanner scanner =new Scanner(System.in);
        final int dividend=scanner.nextInt();
        final int divisor=scanner.nextInt();

        System.out.print(dividend+" / "+divisor+" = ");
        System.out.printf("%.3f\n",(float)dividend/(float)divisor);

        System.out.print(dividend+" = "+(dividend/divisor)+" x "+divisor + " + "+(dividend%divisor));
        scanner.close();
    }
}
