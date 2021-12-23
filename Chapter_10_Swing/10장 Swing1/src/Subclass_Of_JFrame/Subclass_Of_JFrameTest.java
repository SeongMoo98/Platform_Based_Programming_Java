package Subclass_Of_JFrame;

import javax.swing.*;

public class Subclass_Of_JFrameTest {
    public static void main(String[]args){
        System.out.println(Thread.currentThread().getName());
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
    private static void createAndShowGUI(){
        System.out.println(Thread.currentThread().getName());
        //Create and set up the window.
        JFrame frame = new CenteredFrameView();  //생성자를 통해 frame을 이용
        frame.setVisible(true);
    }
}
