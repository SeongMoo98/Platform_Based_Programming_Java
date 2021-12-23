package ExecutingThread;

/*
 * Extends Thread
 * Thread를 Creating하고 Executing하는 두번째
 * Thread를 상속받아 run() 오버라이딩
 * Thread class는 Runnable interface를 implements한다
 * ==>Subclass Thread can provide its own implementation of run()
 */

public class HelloThread extends Thread{
    public static void main(String[] args){

        (new HelloThread()).start();
    }

    @Override
    public void run(){
        System.out.println("Hello from a Thread");
    }

}
