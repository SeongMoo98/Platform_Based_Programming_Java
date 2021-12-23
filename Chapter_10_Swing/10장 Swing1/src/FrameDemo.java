import javax.swing.*;
import java.awt.*;

public class FrameDemo {
    public static void main(String[] args){
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
        //1.Create Frame
        JFrame frame = new JFrame("FrameDemo");

        //2.Optional : What happens when the frame closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //3.Create components and put(add) them in the frame
        JLabel label = new JLabel("Hello, Swing World!");
        label.setPreferredSize(new Dimension(175,100)); //PreferredSize
        frame.getContentPane().add(label, BorderLayout.CENTER); //label의 BorderLayout의 위치를 지정

        //4.Size the frame and set its location
        frame.setSize(400,200);
        //screen에서의 위치 결정
        frame.setLocationRelativeTo(null); //centers a frame onscreen

        //5.Show it
        frame.setVisible(true);
    }

}
