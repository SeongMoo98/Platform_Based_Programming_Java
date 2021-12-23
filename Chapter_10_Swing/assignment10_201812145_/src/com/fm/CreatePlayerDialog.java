package com.fm;

import com.fm.controller.SearchPlayerController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class CreatePlayerDialog extends JDialog implements ActionListener{
    //private JTextField[] textFields = new JTextField[6];
    //private JLabel[] labels = new JLabel[6];
    //private JPanel[] panels = new JPanel[6];
    private List<String> fields= new ArrayList<>();
    private JTextField ct1,ct2,ct3,ct4,ct5,ct6;
    private JLabel l1,l2,l3,l4,l5,l6;
    private JPanel p1, p2, p3, p4, p5, p6;
    private JOptionPane optionPane;

    public CreatePlayerDialog(SearchPlayerController controller)  {
        setTitle("Create a Player");

        ct1=new JTextField(40); ct1.setName("nameField"); l1 =new JLabel("Name");
        ct2=new JTextField(40); ct2.setName("heightField"); l2 =new JLabel("Height");
        ct3=new JTextField(40); ct3.setName("nationalityField"); l3 =new JLabel("Nationality");
        ct4=new JTextField(40); ct4.setName("clubField"); l4 =new JLabel("Club");
        ct5=new JTextField(40); ct5.setName("overallField"); l5 =new JLabel("Overall");
        ct6=new JTextField(40); ct6.setName("positionField "); l6 =new JLabel("Positions");

        p1 = new JPanel(); p1.setLayout(new BorderLayout());
        p1.add(l1,"West"); p1.add(ct1,"East");

        p2 = new JPanel(); p2.setLayout(new BorderLayout());
        p2.add(l2,"West"); p2.add(ct2,"East");

        p3 = new JPanel(); p3.setLayout(new BorderLayout());
        p3.add(l3,"West"); p3.add(ct3,"East");

        p4 = new JPanel(); p4.setLayout(new BorderLayout());
        p4.add(l4,"West"); p4.add(ct4,"East");

        p5 = new JPanel(); p5.setLayout(new BorderLayout());
        p5.add(l5,"West"); p5.add(ct5,"East");

        p6 = new JPanel();p6.setLayout(new BorderLayout());
        p6.add(l6,"West"); p6.add(ct6,"East");

        Object[] array = {p1, p2, p3, p4, p5, p6};
        Object[] options = {"OK", "Cancel"};
        //panel(label과 textField)를 OK, Cancel Option으로, default Option은 option[0]
        optionPane = new JOptionPane(array, JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, null, options, options[0]);
        setContentPane(optionPane);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                optionPane.setValue(new Integer(JOptionPane.CLOSED_OPTION));
            }
        });
        ct1.addActionListener(this); ct2.addActionListener(this); ct3.addActionListener(this);
        ct4.addActionListener(this); ct5.addActionListener(this); ct6.addActionListener(this);


        optionPane.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                String prop = e.getPropertyName();
                if (isVisible()
                        && (e.getSource() == optionPane)
                        && (JOptionPane.VALUE_PROPERTY.equals(prop) ||
                        JOptionPane.INPUT_VALUE_PROPERTY.equals(prop))) {
                    Object value = optionPane.getValue();
                    if (value == JOptionPane.UNINITIALIZED_VALUE)
                        return;
                    optionPane.setValue(JOptionPane.UNINITIALIZED_VALUE);
                    if ("OK".equals(value)) {
                        fields.add(ct1.getText()); fields.add(ct2.getText()); fields.add(ct3.getText());
                        fields.add(ct6.getText()); fields.add(ct5.getText()); fields.add(ct6.getText());
                        //fields에 추가하고 create - model에 추가
                        controller.createPlayer(fields);
                        clearAndHide();
                    }
                } else {
                    clearAndHide();
                }
            }
        });
        pack();
    }

    //textField 모두 비우고 안보이게
    public void clearAndHide() {
        ct1.setText(null); ct2.setText(null); ct3.setText(null);
        ct4.setText(null); ct5.setText(null); ct6.setText(null);
        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        optionPane.setValue("OK");
    }
}
