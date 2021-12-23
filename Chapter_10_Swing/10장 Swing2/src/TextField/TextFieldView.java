package TextField;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldView extends JPanel implements ActionListener {
    private JTextField textField;
    private JTextArea textArea;
    public TextFieldView(){
        textField = new JTextField(20); //글자 수 : 20
        Font font = new Font(textField.getFont().getName(),textField.getFont().getStyle(),24); //폰트설정
        textField.setFont(font);
        textField.addActionListener(this); //textField에서 Event 발생

        textArea = new JTextArea(5,20); // 5줄, 한 줄에 20자
        textArea.setFont(font);
        textArea.setEditable(false); //TextArea의 text는 Edit하지 못한다
        JScrollPane scrollPane = new JScrollPane(textArea); //textArea에 scroll생성

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); //Y축 방향으로 쌓는다
        //Panel에 추가
        add(textField);
        add(scrollPane);
    }

    public void actionPerformed(ActionEvent e){
        String text = textField.getText();
        //textArea에 text를 추가
        textArea.append(text+"\n"); //document model for JTextArea
        textField.selectAll(); //모두 선택 ==> 그 후에 입력하면 새롭게 입력됨
        //Make sure the new text is visible, even if there was a selection in the text area.
        textArea.setCaretPosition(textArea.getDocument().getLength());
        //커서의 위치를 Document의 끝에 지정 ==>새로운 줄에 추가됨
    }
}
