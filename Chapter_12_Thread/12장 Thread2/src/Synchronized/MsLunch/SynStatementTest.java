package Synchronized.MsLunch;

public class SynStatementTest {
    public static void main(String[] args){
        Thread thread1 = new Thread(new Task());
        Thread thread2 = new Thread(new Task());

        thread1.start();
        thread2.start();
    }
}

class MsLunch {
    private long c1,c2;
    //intrinsic,monitor lock
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    //synchronize block - 함수 단위가 아니라
    //호출된 객체(intrinsic object)에만 lock이 걸림
    public void inc1(){ synchronized (lock1) { c1++;} }
    public void inc2(){
        synchronized (lock2) { c2++; }
    }

    public long getc1(){ synchronized (lock1) { return c1; } }
    public long getc2(){ synchronized (lock2) { return c2; } }
}

class Task implements Runnable{
    MsLunch msLunch= new MsLunch();

    @Override
    public void run(){
        for(int i=0; i<200; i++){
            msLunch.inc1();
        }
        System.out.println(msLunch.getc1());

        for(int i=0; i<100; i++){
            msLunch.inc2();
        }
        System.out.println(msLunch.getc2());
    }
}
