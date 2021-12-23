package BasicMethods.toString과equals;

public class UsefulMethods {
    public static void main(String[] args){
        var r1=new Rectangle4(0,0,10,10);
        var r2=new Rectangle4(0,0,10,20);

        //r1,r2 객체가 toString 함수로 convert to String
        System.out.println("R1 : "+r1);
        System.out.println("R2 : "+r2);

        var msg= r1.equals(r2) ? "They are the same." : "They are not the same.";
        System.out.println(msg);
    }
}
