package JPanel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversionPanel extends JPanel implements ActionListener {
    private JSlider slider;
    public ConversionPanel(String myTitle, String[] units){
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(myTitle),
                BorderFactory.createEmptyBorder(5,5,5,5)));

        JTextField textField = new JTextField(10);
        JComboBox unitChooser = new JComboBox();

        for(String unit : units){
            unitChooser.addItem(unit); //ComboBox에 추가
        }
        unitChooser.setSelectedIndex(0); //초기 ComboBox의 SeletedIndex를 0으로 지정(mm, inch)

        unitChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Combo box event, Set new maximums for the slider
                int i = unitChooser.getSelectedIndex();
                System.out.println("chooser : "+ i);
            }
        });

        slider = new JSlider(); //slider 생성

        //Panel1 - textField, slider
        JPanel unitGroup = new JPanel();
        unitGroup.setLayout(new BoxLayout(unitGroup, BoxLayout.PAGE_AXIS));
        unitGroup.setBorder(BorderFactory.createEmptyBorder(0,0,0,5));
        unitGroup.add(textField);
        unitGroup.add(slider);

        //Panel2 - ComboBox
        JPanel chooserPanel = new JPanel();
        chooserPanel.setLayout(new BoxLayout(chooserPanel, BoxLayout.PAGE_AXIS));
        chooserPanel.add(unitChooser);
        chooserPanel.add(Box.createHorizontalStrut(100));

        //Panel 2개를 contentPane에 추가
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        add(unitGroup);
        add(chooserPanel);
        unitGroup.setAlignmentY(TOP_ALIGNMENT);
        chooserPanel.setAlignmentY(TOP_ALIGNMENT);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
