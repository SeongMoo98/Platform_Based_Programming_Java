import javax.swing.*;

public class HelloSwingWorldTest {
    public static void main(String[] args){
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        System.out.println(Thread.currentThread().getName());
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static void createAndShowGUI(){
        JFrame frame = new HelloSwingWorldView();
        frame.setVisible(true);
    }



}
