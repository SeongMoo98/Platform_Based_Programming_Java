package Loop;

public class ForLoop_2 {
    public static void main(String[] args){
        final int[] numbers=new int[10];
        for(int i=0; i<numbers.length; i++){
            numbers[i]=i;
        }
        for(final int i: numbers){
            System.out.printf("value of x : %d%n",i);
        }
    }
}
