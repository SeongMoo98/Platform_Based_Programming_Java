package TextField;

import Actions.ActionView;

import javax.swing.*;
import java.awt.*;

public class TextFIeldTest {
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
        JFrame frame = new JFrame("TextFieldTest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TextFieldView());
        frame.pack();
        frame.setVisible(true);
    }
}
