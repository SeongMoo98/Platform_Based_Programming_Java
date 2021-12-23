package LocalClass;

public class LocalClassExample {
    static String regularExpression="[^0-9]";

    public static void validatePhoneNumber(String number1, String number2){
        final int numberLength=10;

        class PhoneNumber{
            String formattedNumber = null;
            PhoneNumber(String number){
                //regularExpression을 ""으로 바꾸고
                String currentNumber=number.replaceAll(regularExpression,"");
                //number의 길이가 올바르면 formattedNumber로 리턴
                if(currentNumber.length()==numberLength){
                    formattedNumber=currentNumber;
                }
                else{
                    formattedNumber=null;
                }
            }
            public String getNumber(){
                return formattedNumber;
            }
        }

        PhoneNumber myNumber1=new PhoneNumber(number1);
        PhoneNumber myNumber2=new PhoneNumber(number2);
        if(myNumber1.getNumber()==null){
            System.out.println("First number is invalid");
        }
        else{
            System.out.println("First number is " + myNumber1.getNumber());
        }
        if(myNumber2.getNumber()==null){
            System.out.println("Second number is invalid");
        }
        else{
            System.out.println("Second number is " + myNumber2.getNumber());
        }
    }


    public static void main(String[] args){
        validatePhoneNumber("123-456-7890","456-7890");
    }

}
