package Stream_APIs;

import java.util.Arrays;
import java.util.List;

public class Distinct {
    public static void main(String[] args){

        List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
        //parameter : i, Expression : i % 2 == 0
        //distinct - 중복되는 데이터는 포함 x
        numbers.stream().filter( (i) -> i % 2 == 0).distinct().forEach(System.out::println);
    }
}
