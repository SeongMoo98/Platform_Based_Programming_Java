package Stream_APIs;

import java.util.Arrays;
import java.util.List;

public class Reducing {
    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(4,5,3,9);
        int sum = 0;
        for(int x : numbers){
            sum += x;
        }
        System.out.println(sum);

        //reduce - arguments : initial value, BinaryOperator<T>
        //initial value - 초기값
        //BinaryOperator<T> - (T,T) -> T - stream에서 초기값에서부터 BinatyOperation 진행
        //==> 결과값은 1개
        int sum2= numbers.stream().reduce(0, (a,b)->a+b);
        System.out.println(sum2);
    }
}
