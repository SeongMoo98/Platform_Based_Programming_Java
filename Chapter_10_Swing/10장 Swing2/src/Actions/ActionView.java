package Actions;

import javax.swing.*;
import java.awt.*;

public class ActionView {
    public ActionView(){



    }

    public MenuBar createMenuBar(){
        MenuBar menuBar = new MenuBar();
        menuBar.add(new Menu("Menu"));
        menuBar.add(new Menu("Action State"));
        return menuBar;
    }
    public void createToolBar(){
    }

}
