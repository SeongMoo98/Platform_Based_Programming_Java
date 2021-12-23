package String;

public class NumberBetweenString {
    public static void main(String[] args){
        //1) String==>Number
        String intString="100", floatString="1.234F";


        //valuOf() return Wrapper Object
        int a = Integer.valueOf(intString);
        float b=Float.valueOf(floatString);
        System.out.println(a+" "+b);

        //or use parseXX()
        a=Integer.parseInt(intString);
        b=Float.parseFloat(floatString);


        //2) Number==>String
        Integer intValue=100;
        String strI=intValue.toString();
        System.out.println(strI);

        float f=1.234F;
        String strF=Float.valueOf(f).toString();
        System.out.println(strF);
    }
}
