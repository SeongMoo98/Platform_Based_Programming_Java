package Array;

import java.util.Arrays;

public class ArraysExample {
    public static void main(String[] args){
        int[] array1=new int[10];
        for(int i=0; i<array1.length; i++)
            array1[i]=i;
        System.out.println(Arrays.binarySearch(array1,7));

        //array2의 길이를 10으로 한다 - 크기가 안맞으면 잘라내거나 남는부분을 10으로 채운
        int[] array2=Arrays.copyOf(array1,10);
        for(int v: array2) System.out.print(v+" ");
        System.out.println(Arrays.equals(array1,array2));


        int[] array3=Arrays.copyOfRange(array1,2,5);
        System.out.println();
        for(int v:array3) System.out.println(Arrays.equals(array1,array3));


        int[] array4=new int[5];
        Arrays.fill(array4,7);
        System.out.println();
        for(int v : array4) System.out.println(v+" ");

        System.out.println();
        System.out.println(Arrays.asList("Hello", "Java"));




    }
}
