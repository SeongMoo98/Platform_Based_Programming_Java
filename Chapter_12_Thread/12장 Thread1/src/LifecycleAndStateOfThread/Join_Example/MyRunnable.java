package LifecycleAndStateOfThread.Join_Example;

public class MyRunnable implements Runnable{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+" ");
    }
}
