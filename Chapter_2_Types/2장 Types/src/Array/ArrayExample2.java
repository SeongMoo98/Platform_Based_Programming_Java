package Array;

import java.util.Random;

public class ArrayExample2 {
    public static void main(String[] args){
        Random oRandom=new Random();
        int[] ia=new int[101];
        for(int i=0; i<ia.length; i++){
            ia[i]=oRandom.nextInt(100); //[0~~100);
            System.out.println(ia[i]);
        }

        int sum=0;
        for(int v : ia){
            sum+=v;
        }
        System.out.println(sum);
    }
}
