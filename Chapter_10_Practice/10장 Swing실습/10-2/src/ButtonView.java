import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.nio.file.attribute.AttributeView;


public class ButtonView extends JFrame implements ActionListener{
    protected JButton leftButton, midButton, rightButton;
    public ButtonView(){
        //Frame의 setSize
        setSize(500,200);
        leftButton = new JButton("Disable middle button");
        leftButton.setVerticalTextPosition(AbstractButton.CENTER);  //수직 위치 결정
        leftButton.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
        leftButton.setMnemonic(KeyEvent.VK_D); //버튼을 클릭하는 대신 키보드 단축키 설정 ALT + D
        leftButton.setActionCommand("disable"); //버튼이 수행하는 동작의 이름을 설정

        midButton = new JButton("Middle button");
        midButton.setVerticalTextPosition(AbstractButton.BOTTOM);
        midButton.setHorizontalTextPosition(AbstractButton.CENTER);
        midButton.setMnemonic(KeyEvent.VK_M);
        midButton.setActionCommand("able");

        //the default text position of CENTER, TRAILING (RIGHT).t를 수신하는 listener 객체를 add
        rightButton = new JButton("Enable middle button");
        rightButton.setMnemonic(KeyEvent.VK_E);
        rightButton.setActionCommand("enable");
        rightButton.setEnabled(false);

        //버튼 클릭 전 커서를 갖다대면 ToolTip을 보여줌
        leftButton.setToolTipText("Click this button to disable the middle button.");
        midButton.setToolTipText("This middle button does nothing when you click it.");
        rightButton.setToolTipText("Click this button to enable the middle button.");

        leftButton.addActionListener(this); //버튼에서 발생된 event
        midButton.addActionListener(this);
        rightButton.addActionListener(this);

        //frame의 pane에 add
        //getContentPane().add(leftButton,BorderLayout.WEST);
        //getContentPane().add(midButton,BorderLayout.CENTER);
        //getContentPane().add(rightButton,BorderLayout.EAST);

        //Default로 contentPane를 불러줌
        add(leftButton,BorderLayout.WEST);
        add(midButton,BorderLayout.CENTER);
        add(rightButton,BorderLayout.EAST);
    }

    public void actionPerformed(ActionEvent e) {
        if ("disable".equals(e.getActionCommand())) {
            leftButton.setEnabled(false);
            midButton.setEnabled(false);
            rightButton.setEnabled(true);
        }
        else if ("able".equals(e.getActionCommand())) {
            JOptionPane.showMessageDialog(this,"dialog");
        }
        else {
            leftButton.setEnabled(true);
            midButton.setEnabled(true);
            rightButton.setEnabled(false);
        }
    }
}
