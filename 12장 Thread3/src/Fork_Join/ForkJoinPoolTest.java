package Fork_Join;
/**
 * Fork/Join Framework
 * implementation of the ExecutorService interface
 * Task를 broken into smaller pieces recursively
 * ==> 언제 단일 Thread로 처리할지 종료조건이 필요하다
 *
 * ForkJoinPool class
 * ForkJoinTask Process를 execute한다
 * Task를 ForkJoinTask의 subclass로
 *
 */

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class ForkJoinPoolTest {
    public static void main(String[] args){
        //Long Array(0~100,000)생성
        long[] numbers = LongStream.rangeClosed(1,100_000).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Long result = forkJoinPool.invoke(task);
        System.out.println(result);
        //System.out.println((new ForkJoinPool()).invoke(task));
    }
}
