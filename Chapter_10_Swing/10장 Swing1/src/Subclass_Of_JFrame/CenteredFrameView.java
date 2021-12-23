package Subclass_Of_JFrame;

import javax.swing.*;
import java.awt.*;

public class CenteredFrameView extends JFrame {
    public CenteredFrameView(){
        //Frame을 상속 받았기 때문에 JFrame의 setTitle
        setTitle("CenteredFrame");


        //Toolkit을 이용한 getScreen Dimension
        Toolkit kit= Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        //center frame in screen
        setSize(screenWidth/2,screenHeight/2);
        //screen에서의 위치 결정
        setLocation(screenWidth/4,screenHeight/4);

        //Toolkit을 이용한 set frame icon
        Image img = kit.getImage("icon.gif");
        setIconImage(img);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //the child(JLable) will be added to the contentPane
        add(new JLabel("Hello, World!"),BorderLayout.CENTER);
    }
}
