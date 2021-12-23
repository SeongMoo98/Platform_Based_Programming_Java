import javax.swing.*;

public class HelloSwingWorld {
    public static void main(String[] args){
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        System.out.println(Thread.currentThread().getName()); //현재 실행중인 Thread의 Name을 출력
        javax.swing.SwingUtilities.invokeLater(new Runnable() { //초기화면 생성
            @Override
            public void run() {
                createAndShowGUI();
            }
        });

    }

    private static void createAndShowGUI(){
        System.out.println(Thread.currentThread().getName());
        JFrame frame = new JFrame("My First Swing App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫기 옵션
        frame.setSize(500,200);
        //Top-Level container의 contentPane에 JComponet인 JLabel의 add
        frame.getContentPane().add(new JLabel("Hello, Swing World!"));
        frame.setVisible(true); //화면에 보여줌
    }
}
