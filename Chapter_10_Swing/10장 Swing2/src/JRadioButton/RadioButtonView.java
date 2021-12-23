package JRadioButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//RadioButton - groupButton의 여러개의 Button중에 1가지만 선택가능
public class RadioButtonView extends JFrame implements ActionListener {
    private JLabel label;
    private JPanel buttonPanel;
    private ButtonGroup group;
    public RadioButtonView(){
        setSize(300,200);
        label = new JLabel("The quick brown fox jumps over the lazy dog.");
        label.setFont(new Font("Serif", Font.PLAIN, 24));
        add(label,BorderLayout.CENTER);

        buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.SOUTH);

        group = new ButtonGroup();
        addRadioButton("Small",8);
        addRadioButton("Medium",12);
        addRadioButton("Large",24);
        addRadioButton("Extra large",36);
    }
    public void addRadioButton(String name, final int size){
        boolean selected = (size == 24);
        JRadioButton button = new JRadioButton(name, selected);
        //JRadioButton을 group과 buttonPanel에 추가
        group.add(button);
        buttonPanel.add(button);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setFont(new Font("Serif",Font.PLAIN,size));
            }
        };
        button.addActionListener(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
