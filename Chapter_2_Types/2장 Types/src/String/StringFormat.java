package String;

public class StringFormat {
    public static void main(String[] args){
        String str1=String.format("%d",101);
        String str2=String.format("|%15d|",101);
        String str3=String.format("|%-15s|","Hello, Java");
        String str4=String.format("|%015f|",101.00);
        String str5=String.format("|%15.2f|",101.00);


        String str6=String.format("%x",101);

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
        System.out.println(str5);
        System.out.println(str6);
    }
}
