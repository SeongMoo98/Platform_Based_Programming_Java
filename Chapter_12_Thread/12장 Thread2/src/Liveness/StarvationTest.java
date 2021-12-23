package Liveness;
/**
 * Liveness
 * concurrent application's ability execute in a timely manner
 *
 * Problems - DeadLock, Starvation
 * DeadLock
 * 두 개 이상의 Thread가 서로를 Waiting 하면서 blocked 되어있는 상태
 * 서로가 lock이 해제되기를 기다리는 상태
 *
 * Starvation, livelock
 * Greedy Thread에 의해 Shared Resources를 사용할 수 없다
 * ==>Multiple Threads 중 실행이 잘 되지 않는 Thread가 존재한다
 * unable to gain regular access ro shared resources
 */

import javax.swing.*;
import java.awt.*;

public class StarvationTest {
    private static Object sharedObj = new Object(); //Monitor Lock
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static void createAndShowGUI(){
        JFrame frame = new JFrame("Starvation Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(300,200));
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));

        for(int i=0; i<5; i++){
            ProgrssThread progressThread = new ProgrssThread();
            frame.add(progressThread.getProgressComponent());
            progressThread.start();
        }
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    private static class ProgrssThread extends Thread {
        JProgressBar progressBar;
        ProgrssThread(){
            progressBar = new JProgressBar();
            progressBar.setString(this.getName());
            progressBar.setStringPainted(true);
        }
        JComponent getProgressComponent(){
            return progressBar;
        }

        @Override
        public void run(){
            int c = 0;
            while(true){
                synchronized (sharedObj){
                    if(c==100) c=0;
                    progressBar.setValue(++c);
                    try{
                        Thread.sleep(100); //greedy
                    }
                    catch (InterruptedException e){

                    }
                }
            }
        }
    }
}
