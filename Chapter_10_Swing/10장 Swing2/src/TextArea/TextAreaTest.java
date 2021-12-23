package TextArea;

import Actions.ActionView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TextAreaTest {
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
    private static void createAndShowGUI(){
        //자동완성에서 쓰일 비교 단어들
        List<String> words = new ArrayList<>(5);
        words.add("spark");
        words.add("special");
        words.add("spectacles");
        words.add("spectacular");
        words.add("swing");

        JFrame frame = new TextAreaView("TextAreaTest",words);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);
    }
}
