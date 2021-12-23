package InputAndOutput;

import java.util.Scanner;

public class ScannerExample3 {
    public static void main(String[] args){

        final Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            final int n = scanner.nextInt();
            System.out.println(n);
        }

        scanner.close();
    }
}
