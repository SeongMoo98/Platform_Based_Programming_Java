package JCheckBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBoxView extends JFrame implements ActionListener {
    private JLabel label;
    private JCheckBox bold, italic;
    public CheckBoxView(){
        setSize(300,200);
        label = new JLabel("The quick brown fox jumps over the lazy dog.");
        label.setFont(new Font("Serif",Font.PLAIN,24));
        add(label,BorderLayout.CENTER);

        //Panel에 button을 추가하고 위치를 아래로
        //CheckBox 선택해도되고 안해도되고
        JPanel buttonPanel = new JPanel();
        bold = new JCheckBox("Bold");
        bold.addActionListener(this);
        buttonPanel.add(bold);

        italic = new JCheckBox("italic");
        italic.addActionListener(this);
        buttonPanel.add(italic);

        add(buttonPanel,BorderLayout.SOUTH);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        int mode =0;
        if(bold.isSelected())
            mode += Font.BOLD; //1
        if(italic.isSelected())
            mode += Font.ITALIC; //2
        label.setFont(new Font("Serif",mode,24));
    }
}
