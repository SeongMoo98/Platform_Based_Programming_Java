package Lambda_Expression.Variable_Capture;

public class LocalVariableCapture {
    public static void main(String [] args){
        String greeting = "Hello";
        //lambda expression은 lambda function 외부에 선언된 변수에 접근 가능
        MyFactory myFactory = (message) -> { return greeting+" : "+message; };

        System.out.println( myFactory.create("Java Lambda") );
    }
}
