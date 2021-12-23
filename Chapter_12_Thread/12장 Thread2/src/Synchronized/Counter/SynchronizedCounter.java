package Synchronized.Counter;
/**
 * Synchronized
 * Synchronized Method, Synchronized block
 *
 * happens-before-relationship을 establish해준다
 * ==> 2개의 Thread로 동시에 접근할 수 없다
 *
 * Synchronized Method
 * 자신이 포함된 객체에 Lock을 건다
 *
 * Synchronized block
 * intrinsic lock, monitor lock을 통해 함수(객체)단위가 아니라
 * 호출된 객체(intrinsic lock)에만 걸린다
 * ==>Thread가 가지고 있는 lock 객체가 다르다면 동시실행 가능하다
 */

public class SynchronizedCounter {

    //Intrinsic lock
    //private int c1; private int c2;
    //private Object lock1 = new Object();
    //private Object lock2 = new Object();
    //public void increment() { synchronized (lock1){c1++;}

    private int c = 0;
    public synchronized void increment(){c++;}
    public synchronized void decrement(){c--;}
    public synchronized void value(){  System.out.print(c+" "); }
}

