package WrapperClass;

public class Conversion2PrimitiveType {
    public static void main(String[]args){
        Integer integer1=new Integer(10);
        //Integer 객체를 int형 변수로 Conversion
        int intValue=integer1.intValue();

        //Interger 객체를 생성 후 short형으로 형 변환
        Integer integer2=Integer.valueOf(118);
        short shortIntValue=integer2.shortValue();

        //Interger 객체를 생성 후 long형으로 형 변환
        Integer integer3=integer1+integer2;
        long longintValue=integer3.longValue();

        //Interger 객체를 생성 후 byte형으로 형 변환
        //overflow
        byte byteValue=integer3.byteValue();
        System.out.println(byteValue);
    }
}
