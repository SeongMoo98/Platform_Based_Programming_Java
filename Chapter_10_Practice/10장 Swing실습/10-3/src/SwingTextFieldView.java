import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class SwingTextFieldView extends JFrame implements ActionListener {
    protected JTextField textField;
    protected JTextArea textArea;

    public SwingTextFieldView(){

        JPanel panel = new JPanel();
        JButton button = new JButton("Enter");
        button.setMnemonic(KeyEvent.VK_E);

        textField = new JTextField(20);
        textField.addActionListener(this);

        textArea = new JTextArea(5, 20);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        panel.add(textField);
        panel.add(button);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS) );

        add(panel);
        add(scrollPane);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = textField.getText();
        textArea.append(text + "\n");
        textField.selectAll();

        //Make sure the new text is visible, even if there
        //was a selection in the text area.
        textArea.setCaretPosition(textArea.getDocument().getLength());

    }
}
