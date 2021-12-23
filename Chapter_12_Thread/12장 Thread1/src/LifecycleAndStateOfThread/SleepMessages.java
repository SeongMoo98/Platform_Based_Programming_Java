package LifecycleAndStateOfThread;

import javax.swing.plaf.nimbus.State;

/*
 * Thread.sleep(ms)
 * State : Runnable -> Waiting
 * 스레드가 일정 시간동안 멈춘다
 * 이때 다른 Thread가 작업을 한다
 */
public class SleepMessages {
    public static void main(String[] args){
        String messages[] = {  "1st message", "2nd message", "3rd message", "4th message" } ;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        });
        thread.start();
        for(String message : messages){
            //Pause for 1 seconds; but not guaranteed!
            try {
                System.out.println(Thread.currentThread().getState());
                System.out.println(thread.getState());
                Thread.sleep(1000); //Thread Waiting 상태
            }
            catch (InterruptedException e) {
                System.err.println(e);
            }
            System.out.println(message);
        }
    }
}
