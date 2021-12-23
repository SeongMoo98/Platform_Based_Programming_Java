package String;

public class StringSplitExample {
    public static void main(String[] args){
        String message1="Hello\tWorld\t\tI\t\tLove\tJave";

        String[] words11=message1.split("\t");
        for(int i=0; i<words11.length; i++){
            System.out.println(i + ": ["+words11[i]+"]");
        }

        String[] words12=message1.split("\t+");
        for(int i=0; i<words12.length; i++){
            System.out.println(i + ": ["+words12[i]+"]");
        }


        String message2="Hello\tWorld\nLove   Jave";

        String[] words21=message2.split("\\s");
        for(int i=0; i<words21.length; i++){
            System.out.println(i + ": ["+words21[i]+"]");
        }

        String[] words22=message2.split("\\s+");
        for(int i=0; i<words22.length; i++){
            System.out.println(i + ": ["+words22[i]+"]");
        }
    }
}
