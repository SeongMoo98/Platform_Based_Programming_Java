package Stream_from.Range_Iterate_Generate;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Range_Iterate_Generate {
    public static void main(String[] args){
        int[] numbers={1,2,3,4,5,6,7,8,9,10};
        IntStream number1= Arrays.stream(numbers);
        number1.forEach(System.out::print);
        System.out.println();

        //근데 왜 IntStream으로 접근하는거지??
        IntStream.range(1,5).forEach(System.out::print);
        System.out.println();

        IntStream.rangeClosed(1,5).forEach(System.out::print);
        System.out.println();

        Stream.iterate(0, n->n+2).limit(5).forEach(System.out::print);
        System.out.println();

        Stream.generate(()->1).limit(5).forEach(System.out::print);


    }
}
