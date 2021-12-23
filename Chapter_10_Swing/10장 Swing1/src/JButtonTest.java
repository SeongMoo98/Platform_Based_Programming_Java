import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class JButtonTest {
    public static void main(String[] args){
        System.out.println(Thread.currentThread().getName()); //현재 실행중인 Thread의 Name을 출력
        javax.swing.SwingUtilities.invokeLater(new Runnable() { //초기화면 생성
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI(){
        JFrame frame = new JFrame("JButton Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,150);

        JButton button = new JButton("Click me");
        button.setMnemonic(KeyEvent.VK_C);  //버튼의 단축키 등록
        //ActionListener을 등록하고 ActionListener의 anonymous class - ActionPerformed Override
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(Thread.currentThread().getName());
            }
        });

        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(frame.getBackground(),10),
                BorderFactory.createLineBorder(Color.BLACK,5)));
        //getContentPane은 Default로 호출됨
        frame.add(button);
        frame.setVisible(true);
    }

}
