package ParallelStreams;
/**
 * Parallel Stream
 * Stream을 mutiple chunks로 split해서 each chunk를 각각 다른 Thread로 처힌
 * ==>Multicore processor의 작업을 자동으로 분할하고 모든 작업을 동일하게 수행할 수 있다
 *
 * Collection에서 parallelStream() 메소드를 호출하여 Collection을 병렬 스트림으로 처리할 수 있다
 *
 *
 * 유의사항 - algorithm과 shared state에 따라 error가 발생할 수 있다
 * 1. 항상 성능에 개선이 있는건 아니다
 * 2. AutoBoxing에 유의 - 성능을 떨어트릴 수 있다
 * 3. Sorting 되어 있다고 가정된 Operation 등등은 예상치 못한 결과를 얻을 수 있다
 * 4. ParallelStream과 잘 맞는 DataStructure가 존재한다 (ArrayList, IntStream ...)
 */

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStreamTest {
    public static void main(String[] args){
        System.out.println(iterativeSum(100_000));
        System.out.println(sequentialSum(100_000));
        System.out.println(parallelSum(100_000));
        System.out.println(sideEffectSum(100_000));
    }
    //for문 순회
    public static long iterativeSum(long n){
        long result = 0;
        for(long i = 1L; i <= n; i++){
            result += i;
        }
        return result;
    }
    //Iterator로 sequential하게 순회
    public static long sequentialSum(long n){
        //return LongStream.rangeClosed(1,n).reduce(0L,Long::sum);
        return Stream.iterate(1L, i->i+1).limit(n).reduce(0L, Long::sum);
    }
    //Stream.parallel로 parallelStream으로 연산
    public static long parallelSum(long n){
        return Stream.iterate(1L, i->i+1).
                limit(n).parallel().reduce(0L,Long::sum);
        //return LongStream.rangeClosed(1,n).parallel().reduce(0L,Long::sum);
    }

    //parallel에서 error가 발생할 수 있다
    public static long sideEffectSum(long n){
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1,n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }

    private static class Accumulator{
        public long total = 0;
        public void add(long value) { total += value; }
    }
}
