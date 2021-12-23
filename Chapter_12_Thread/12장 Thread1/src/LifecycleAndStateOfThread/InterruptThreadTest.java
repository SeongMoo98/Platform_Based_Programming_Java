package LifecycleAndStateOfThread;


/**
  * Interrupt - 실행 중인 프로그램(Main Thread)을 일시 중단하고 다른 프로그램을 끼워 넣어( t.interrupt() )실행시키는 것
  * 처리가 끝나면 원래의 프로그램으로 되돌아가서 계속 실행
  * ==>mainThread를 실행하다가 t Thread를 실행시킨다 ==> run가 종료되면 다시 main Thread로
  *
  * t.interrupt()가 호출되면 호출된 t Thread에 인터럽트가 "예약"되는데 이는 InterruptException을 발생시키겠다는 뜻
  * interrupt가 예약된 메소드는 계속 실행되다가
  * sleep()이나 wait(), join() 같은 메소드들을 만나면(즉 Non-Runnable한 상태가 되면)
  * 즉시 InterruptedException 발생 시키고 이를 통해 run() 메소드를 정상 종료
  *
  * t.interrupt() - 다른 Thread에서 t.interrupt()를 호출
  * interrupt가 예약된 t Thread가 Non-Runnable한 상태(sleep(), wait(), join()등 WAIT, TIMED_WAIT상태)가 되면
  * InterruptedException을 발생 ==> run()종료
  * Runnable State에서 interrupt()를 호출하면 InterruptExcption예외가 예약
  */


import java.util.Scanner;
public class InterruptThreadTest {
    private static class SimpleRunnable implements Runnable{
        public void run(){
            String threadName = Thread.currentThread().getName();;
            int i = 0;
            try{
                while(!Thread.interrupted()){
                    System.out.printf("%s : %d%n",threadName, i);
                    i++;
                    //Non-Runnable한 상태가 되어 interrupt가 되면  InterruptException이 발생해서 run종료
                    Thread.sleep(3000);
                }
            }
            catch (InterruptedException e){
                System.out.println("InterruptException 발생");
            }

        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new SimpleRunnable());
        t.start();
        //main Thread는 입력을 받기 위해 대기중 ==> Blocked 상태이다
        //==>thread가 실행된다
        //입출력 함수를 호출(BLOCKED상태)하여 Non-Runnable 상태이면 InterruptException발생
        Scanner scanner = new Scanner(System.in);
        //Scanner를 처리하는 Thread는 Runnable -> Waiting
        //입력을 하면 interrupt 발생
        String line= scanner.nextLine();

        //t에 Interrupt 예약
        //t가 Non-Runnable state가 되면 Exception 발생
        //==>run() method 종료
        t.interrupt();
        t.join();
        System.out.println("입력 : " + line + ", MainThread 종료");
    }
}
