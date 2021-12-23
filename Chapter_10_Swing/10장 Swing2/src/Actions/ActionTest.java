package Actions;

import javax.swing.*;

//Action
//Action은 component에서 기능과 상태를 분리한다
//예를 들어
//1.동일한 기능을 수행하는 components가 2개 이상 있을 경우, Action 객체를 사용하여 함수를 구현하는것을 고려한다
//2.Action객체는 action Listener에 action-event handling을 제공할 뿐만 아니라
// the state of action-event-firing components(tool bar button, menu items, buttons, text fields...)의 handling을 centerlize한다
public class ActionTest {
    public static void main(String[] args){
        System.out.println(Thread.currentThread().getName());
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
    private static void createAndShowGUI(){
        JFrame frame = new JFrame("ActionTest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionView view = new ActionView();
        frame.setMenuBar(view.createMenuBar());
        view.createToolBar();

        //frame.setContentPane(view);
        frame.pack();
        frame.setVisible(true);
    }
}
