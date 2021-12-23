package LifecycleAndStateOfThread.Join_Example;


public class JoinTest{

    public static void main(String[] args){
        //Thread의 실행 순서를 알 수 없다
//        Thread thread1 = new Thread(new MyRunnable());
//        Thread thread2 = new Thread(new MyRunnable());
//        Thread thread3 = new Thread(new MyRunnable());
//        Thread thread4 = new Thread(new MyRunnable());
//        thread1.start(); thread2.start(); thread3.start(); thread4.start();

        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable());
        Thread thread3 = new Thread(new MyRunnable());
        Thread thread4 = new Thread(new MyRunnable());

        try{
            thread1.start();
            thread1.join();

            thread2.start();
            thread2.join();

            thread3.start();
            thread3.join();

            thread4.start();
            thread4.join();
        }
        catch(InterruptedException e){
            System.err.println(e);
        }

    }
}
