package LifecycleAndStateOfThread.Interrupt_Example;


public class InterruptExample {
    public static void main(String[] args){
        Thread t = new Thread(new PrintThread());
        t.start();
        try{
            //Main Thread - Non-Runnable한 상태
            //==>scheduler가 t 실행
            Thread.sleep(1000);
        }
        catch (InterruptedException e) { }

        //1초 지난 후 Interrupt 예약
        t.interrupt();
    }
}
