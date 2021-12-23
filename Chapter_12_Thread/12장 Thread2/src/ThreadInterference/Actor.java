package ThreadInterference;
/**
 * Thread Interference Error
 *
 * Mutiple Thread가 Shared data를 동시에 reference 할 때
 * Shared Data : Sharing access to fields, Object reference fields
 *
 * Thread의 작업들이 언제 멈추고 언제 실행할지 모른다
 * 1) Memory Read
 * 2) Data Update
 * 3) Memory Write
 *
 * ==> 한 Thread가 Memory에 write하기 전에 Read를 하면
 * Memory의 값은 변경이 안된 상태다
 */


/**
 * Memory Consistency Errors
 * Cache data만 update하고 Memory의 data는 update하지 않는다
 * 작업이 끝나면 Cache Data 한번에 Memory write
 *
 * ==>Cache가 Memoey에 write하기 전 다른 Thread에서 Read를 하면 값이 처리가 되어있지 않다.
 *
 * Happens-Before Relationship
 * sort of ordering(실행순서), visibility - A Thread에서 변경된게 B Thread에서 보여야한다
 * Memory에 Write로 변화가 발생하면 그 변화를 Guarantee해준다
 *
 * synchronized block
 * synchronize block을 나갈때 모두 update한다
 *
 * volatile
 * write 한 값을 read할 때 갱신됨을 보장한다
 *
 * ==> T1 Thread에서 visible한 것들은 모두 T2 Thread가 Read하기 전 Write한다
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Actor implements Runnable{
    private String name;
    private Counter counter;
    private List<Integer> results =new ArrayList<>();
    public Actor(String name, Counter counter){
        this.name=name; this.counter=counter;
    }
    public List<Integer> gerResult(){ return results;}

    @Override
    public void run() {
        for(int i=0; i<100; i++) {
            counter.increment();
            results.add(counter.value());
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        //Actor은 counter Object를 Sharing
        Actor actor1 = new Actor("Actor1", counter);
        Actor actor2 = new Actor("Actor2", counter);
        Thread t1 = new Thread(actor1);
        Thread t2 = new Thread(actor2);
        //run()에서 공유된 counter올 동시에 접근
        t1.start();
        t2.start();
        //Main Thread에서 t1,t2가 끝날때 까지 기다린다
        t1.join();
        t2.join();
        var stream = actor1.gerResult().parallelStream();
        List<Integer> result = Stream.concat(stream, actor2.gerResult().stream()).collect(Collectors.toList());
        System.out.println(result);
        //예상 결과 [1, 2, 3, 4, ...]
    }
}
class Counter {
    private int c =0;
    public void increment(){c++;}
    public void decrement(){c--;}
    public int value() {return c;}
}


