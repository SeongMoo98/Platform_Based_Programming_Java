package JDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Locale;

public class SwingDialog extends JDialog implements ActionListener, PropertyChangeListener {
    private String magicWord;
    private JTextField textField;
    private JOptionPane optionPane;
    public SwingDialog(String word) {
        this.magicWord = word.toUpperCase();
        setTitle("Quiz");
        textField = new JTextField(10);
        Font font = new Font("Serif", Font.PLAIN, 24);
        textField.setFont(font);

        String msgString1 = "What was Dr. SEUSS's real last name?";
        String msgString2 = "(The answer is \"" + word + "\".)";

        Object[] array = {msgString1, msgString2, textField};
        Object[] options = {"Enter", "Cancel"}; //dialog buttons

        //Create the JOptionPane
        //font변경
        UIManager.put("OptionPane.messageFont", font);
        UIManager.put("OptionPane.buttonFont", font);

        optionPane = new JOptionPane(array, JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_CANCEL_OPTION,
                null, options, options[0]);
        setContentPane(optionPane);

        //Handle Window closing correctly
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            public void windowsClosing(WindowEvent we) {
                //to change the JOptionPane's value property
                /*
                 * Instead of directly closing the window,
                 * we're going to change the JOptionPane's
                 * value property.
                 */
                optionPane.setValue(new Integer(JOptionPane.CLOSED_OPTION));
            }
        });

        //Ensure the text field always gets the first focus.
        addComponentListener(new ComponentListener() {
            @Override
            public void componentShown(ComponentEvent e) {
                textField.requestFocusInWindow();
            }
            @Override
            public void componentResized(ComponentEvent e) {}

            @Override
            public void componentMoved(ComponentEvent e) {}
            @Override
            public void componentHidden(ComponentEvent e) {}
        });
        //Register an event handler that puts the text into the option pane.
        textField.addActionListener(this);
        //Register an event handler that reacts to option pane state changes.
        optionPane.addPropertyChangeListener(this);
        pack();

    }

    public void clearAndHide() {
        textField.setText(null);
        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        optionPane.setValue("Enter");
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        String prop = e.getPropertyName();
        String typedText;
        if(isVisible()
                && (e.getSource() == optionPane)
                &&(JOptionPane.VALUE_PROPERTY.equals(prop)
                ||JOptionPane.INPUT_VALUE_PROPERTY.equals(prop))){
            Object value = optionPane.getValue();
            //ignore reset
            if(value == JOptionPane.UNINITIALIZED_VALUE)
                return;
            //Reset the JOptionPane's value.
            optionPane.setValue(JOptionPane.UNINITIALIZED_VALUE);
            if("Enter".equals(value)){
                typedText = textField.getText();
                String ucText = typedText.toUpperCase();
                if(magicWord.equals(ucText)){
                    //we're done; clear and dismiss the dialog
                    clearAndHide();
                }
                else{
                    //text was Invalid
                    textField.selectAll();
                    JOptionPane.showMessageDialog(
                            SwingDialog.this,
                            "Sorry, \"" + typedText + "\" "
                                    + "isn't a valid response.\n"
                                    + "Please enter "
                                    + magicWord + ".",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                    typedText = null;
                    textField.requestFocusInWindow();
                }
            }
            else{
                //user closed dialog or clicked cancel
                typedText = null;
                clearAndHide();
            }
        }
    }
}
