package LifecycleAndStateOfThread;

/**
 * join()
 * 현재 Thread를 멈추고 호출받은 t Thread의 작업이 끝날때까지 기다린다
 * t.join() - 현재 Thread가 t Thread가 종료 될 때까지 실행을 일지중지
 **/
public class JoinThreadTest {
    static void message(String message){
        String name = Thread.currentThread().getName();
        System.out.format("%s : %s%n", name, message);
    }

    private static class MessageLoop implements Runnable{
        @Override
        public void run(){
            String importantInfo[] = {"message1", "message2", "message3", "message4" };
            try{
                for(int i=0; i<importantInfo.length; i++) {
                    Thread.sleep(4000);
                    message(importantInfo[i]);
                }
            }
            catch (InterruptedException e){
                message("I wasn't done!");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //change 10 to 20
        long patience = 1000 * 10;
        message("Starting MessageLoop thread");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());
        t.start();
        message("Waiting for MessageLoop thread to finish");
        while (t.isAlive()) {
            message("Still waiting...");
            t.join(1000);
            if (((System.currentTimeMillis() - startTime) > patience) && t.isAlive()) {
                message("Tired of waiting!");
                t.interrupt();
                t.join();
            }
        }
        message("Finally!");
    }
}
