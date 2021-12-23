package Operation;

import java.util.Scanner;

public class TypeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();

        int str2int = Integer.parseInt(str);
        float int2float = (float) str2int;
        // printType() 호출`
        printType(str);
        // 형변환 ( String --> int)
        System.out.println("Type conversion to int...");
        printType(str2int);
        // 형변환 ( int --> float)
        System.out.println("Type conversion iny to float...");
        printType(int2float);
    }
    private static void printType (String x){
        System.out.println(x + " is a string");
    }
    private static void printType ( int x){
        System.out.println(x + " is an int");
    }
    private static void printType ( float x){
        System.out.println(x + " is a float");
    }


}




