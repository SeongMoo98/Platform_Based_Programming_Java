package Stream_from.Collection_Array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Collection_Array {
    public static void main(String[] args){
        //Collection.stream() - list는 그래도 두고 stream을 새로 만들어서 Inner Iterator로 접근
        List<String> list1 = Arrays.asList("Modern ", "Java ", "in ", "Action ");
        list1.stream().forEach(System.out::print);
        System.out.println();
        list1.stream().forEach(System.out::print); //두번 해도 상관없다 - 왜냐면 list는 계속 존재하고있기 때문에
        System.out.println();


        //Arrays.stream() of Stream.of()
        String[] strings = {"Modern ", "Java ", "in ", "Action "};
        Stream<String> stream1 = Arrays.stream(strings);
        stream1.forEach(System.out::print);
        //stream1.forEach(System.out::print);   //Stream은 한번 사용하면 다시 접근 x
        System.out.println();


        Stream<String> stream2 = Stream.of("Modern ", "Java ", "in ", "Action ");
        stream2.forEach(System.out::print);
        //stream2.forEach(System.out::print);   //Stream은 한번 사용하면 다시 접근 x
        System.out.println();


        //Integer
        int[] numbers={1,2,3,4,5};
        IntStream number1=Arrays.stream(numbers);
        number1.forEach(System.out::print);

    }
}
