import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class SwingDialogView extends JFrame {
    public SwingDialogView(){
        SwingDialog dialog = new SwingDialog("Hello");

        JButton button = new JButton("Show");
        button.setPreferredSize(new Dimension(400, 100));
        button.setFont(new Font("Serif", Font.PLAIN, 24));
        button.setMnemonic(KeyEvent.VK_S);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(true);
            }
        });

        add(button);
    }
}
