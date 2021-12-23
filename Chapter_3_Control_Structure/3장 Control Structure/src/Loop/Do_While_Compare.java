package Loop;

import java.util.Scanner;

public class Do_While_Compare {
    public static void main(String[]args){
        int num1,sum1=0;
        Scanner scanner=new Scanner(System.in);
        do{
            System.out.println("Enter Number :");
            num1=scanner.nextInt();
            sum1+=num1;
        }while(num1<10);
        System.out.println(sum1);

        int num2,sum2=0;
        //while은 조건을 먼저 체크한다
        num2=scanner.nextInt();
        while(num2<10){
            System.out.println("Enter Number : ");
            num2=scanner.nextInt();
            sum2+=num2;
        }
        System.out.println(sum2);


    }
}
