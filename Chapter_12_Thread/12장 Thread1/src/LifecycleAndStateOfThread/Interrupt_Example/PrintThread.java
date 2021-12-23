package LifecycleAndStateOfThread.Interrupt_Example;

public class PrintThread extends Thread{
    @Override
    public void run(){
        try{
            while(true){
                System.out.println(Thread.currentThread().getName()+" : 실행 중");
                //Non-Runnable한 상태에서 interrupt를 받아 Exception발생
                Thread.sleep(100);
            }
        }
        catch (InterruptedException e){ }

        System.out.println("실행정리");
    }
}
