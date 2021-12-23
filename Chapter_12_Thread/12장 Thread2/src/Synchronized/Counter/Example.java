package Synchronized.Counter;

import java.util.ArrayList;
import java.util.List;

public class Example{
    public List<Integer> list = new ArrayList<>();
    public static void main(String[] args){
        SynchronizedCounter counter = new SynchronizedCounter();
        CounterThread thread1 = new CounterThread(counter);
        CounterThread thread2 = new CounterThread(counter);

        thread1.start();
        thread2.start();
    }

}
class CounterThread extends Thread{
    protected SynchronizedCounter counter = null;
    public CounterThread(SynchronizedCounter counter){
        this.counter = counter;
    }

    @Override
    public void run(){
        for(int i=0; i<100; i++){
            counter.increment();
            counter.value();
        }
    }
}




