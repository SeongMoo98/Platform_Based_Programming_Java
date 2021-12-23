package JComboBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxView extends JFrame {
    private JLabel label;
    public ComboBoxView(){
        setSize(300,200);
        label = new JLabel("The quick brown fox jumps over the lazy dog.");
        Font font = new Font("Serif", Font.PLAIN, 24);
        label.setFont(font);
        add(label, BorderLayout.CENTER);

        //ComboBox에서 선택할 FontNames
        String[] fontNames = {"Serif","SansSerif","Monospaced","Dialog","DialogInput"};
        //ComboBox 생성(Array of String)
        JComboBox<String> fontNameCombo = new JComboBox<>(fontNames);
        fontNameCombo.setFont(font);
        add(fontNameCombo, BorderLayout.SOUTH);
        fontNameCombo.setEditable(true);

        fontNameCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource(); //e의 source(???)를 return
                String fontName = (String)cb.getSelectedItem();
                label.setFont(new Font(fontName,Font.PLAIN,24));
            }
        });
    }
}
