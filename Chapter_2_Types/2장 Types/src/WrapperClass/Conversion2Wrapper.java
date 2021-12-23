package WrapperClass;

public class Conversion2Wrapper {
    public static void main(String[] args){
        //1.using constructor
        //Integer 객체로 생성
        Integer integer1=new Integer(10);
        System.out.println(integer1);

        //2.using static factory mathod : valueOf()
        //The static factory valueOd(int) is generally a better choice
        //as it is likely to yield significantly better space and time performance
        Integer integer2 = Integer.valueOf(20);
        System.out.println(integer2);

        System.out.println(integer1+integer2);
    }
}
