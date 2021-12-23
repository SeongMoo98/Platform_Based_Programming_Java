package Loop;

import java.util.Scanner;

public class WhileLoop_3 {
    public static void main(String[] args){
        final String inputString="10 20 30 50";
        final Scanner scanner=new Scanner(inputString);

        int sum=0;
        while(scanner.hasNext() && (sum<=50)){
            final int value=scanner.nextInt();
            sum+=value;
        }
        scanner.close();

        System.out.println(sum);
    }
}
