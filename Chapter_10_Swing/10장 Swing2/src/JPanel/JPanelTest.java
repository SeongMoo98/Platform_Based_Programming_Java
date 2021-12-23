package JPanel;

import jdk.jfr.Frequency;

import javax.swing.*;
import java.awt.*;

public class JPanelTest {
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("JPanelTest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] metrics = {"MilliMeter","CentiMeter","Meter","KiloMeter"};
        String[] us = {"Inch", "Feet","Yard","Mile"};
        JPanel metricPanel = new ConversionPanel("Metric System",metrics);
        JPanel usPanel = new ConversionPanel("U.S. System",us);

        JPanel mainPane =(JPanel)frame.getContentPane();
        mainPane.setLayout(new BoxLayout(mainPane,BoxLayout.PAGE_AXIS));
        mainPane.setOpaque(true); //불투명 배경
        mainPane.setBackground(new Color(255,0,0)); //배경을 Red
        mainPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        mainPane.add(metricPanel);
        mainPane.add(usPanel);

        frame.pack();
        frame.setVisible(true);
    }
}
