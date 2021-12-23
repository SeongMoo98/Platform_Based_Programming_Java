package InputAndOutput;

import java.util.Scanner;

public class ScannerException {
    public static void main(String[] args){
        final Scanner scanner=new Scanner(System.in);

        try{
            while(scanner.hasNext()) {
                final int n = scanner.nextInt();
                System.out.println(n);
            }
        }
        catch (Exception e){
            System.out.println("Exception : "+e);
            System.out.println("정수 형태의 문자열을 입력하세요!");
        }
        finally {
            scanner.close();
        }
    }
}
