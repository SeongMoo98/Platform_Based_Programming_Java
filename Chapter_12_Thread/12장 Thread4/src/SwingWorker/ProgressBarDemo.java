package SwingWorker;
/**
 * SwingWorker<T, V> -  T : return Type, V - parameter
 * Multi-Threaded
 * BackGround Thread 에서 GUI Interaction Task 를 수행하는 abstract class
 *
 * Current Thread : SwingWorker 를 상속받은 class(Task)의 execute() 호출
 *
 * Worker Thread : Time-Consuming Tasks 를 수행한다
 *                 이 Thread 에서 doInBackground() 호출 - state progress property 를 가진다
 *                 progress >= 100 이면 종료
 *                 UI interface 와 분리된 Daemon Thread 이다
 *
 * Event Dispatch Thread(EDT) : doInBackGround() 가 종료되면 EDT Thread 에서 done() 호출
 *                              SwingComponents 와 관련된 건 전부 여기서 처리한다
 * T : doInBackGround(), get() 에서 return Type
 * T get() - Event Dispatch Thread's done()에서 doInBackground() 의 return 값을 받을 수 있다
 *
 * V : publish(), process() 에서 parameter Type
 * doInBackGround() 중간에 publish(V Chunks) ==> EDT 에서 process()받는다
 * state, progress properties
 *
 */

/**
 * Daemon Thread
 * 동일한 프로세스 안에서 다른 스레드의 수행을 돕는 스레드로
 * 다른 스레드를 서비스 해주면서 다른 스레드가 모두 종료되면 자신도 종료되는 스레드를 말한다.
 * Event Dispatching Thread 와 Worker Thread 모두 UI Thread 와 분리된 Thread
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;


public class ProgressBarDemo extends JPanel
        implements ActionListener, PropertyChangeListener {
    private JProgressBar progressBar;
    private JButton startButton;
    private JTextArea taskOutput;
    private Task task;


    class Task extends SwingWorker<Void,Void>{
        //Main Task. Executed in background thread
        //이 작업은 Thread를 생성해서 main Thread와는 별개로 돌아가고
        //리턴값을 get()으로 받을수 있다
        //get()을 하면 현재쓰레드는 execute가 끝날때 까지 대기하고 리턴값을 받아낸다
       @Override
        protected Void doInBackground() throws Exception {
            Random random = new Random();
            int progress = 0;
            //Initialize progress property
            setProgress(0);
            while(progress<100){
                //Sleep for up to one second
                try {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(Thread.currentThread().isDaemon());
                    System.out.println();
                    ;
                    Thread.sleep(random.nextInt(1000));
                }
                catch (InterruptedException ignore){}
                //make Random progress
                progress += random.nextInt(10);
                setProgress(Math.min(progress,100));
            }
            return null;
        }

        //Execute in event dispatching thread
        @Override
        public void done() {
           System.out.println(SwingUtilities.isEventDispatchThread());
           Toolkit.getDefaultToolkit().beep();
           startButton.setEnabled(true);
           setCursor(null);
           taskOutput.append("Done!\n");
        }


    }


    //All the Swing Componenets는 Event Dispatch Thread에서 occur
    //done()에서 이 Thread의 PropertyChangeListener에서 전달
    public ProgressBarDemo(){
        super(new BorderLayout());

        //Create the demo's UI
        startButton = new JButton("Start");
        startButton.setActionCommand("start");
        startButton.addActionListener(this);

        progressBar = new JProgressBar(0,100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);

        taskOutput = new JTextArea(5,20);
        taskOutput.setMargin(new Insets(5,5,5,5));
        taskOutput.setEditable(true);

        JPanel panel = new JPanel();
        panel.add(startButton);
        panel.add(progressBar);

        add(panel, BorderLayout.PAGE_START);
        add(new JScrollPane(taskOutput), BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }


    //Invoked when the user presses the start button.
    public void actionPerformed(ActionEvent evt) {
        startButton.setEnabled(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        //Instances of javax.swing.SwingWorker are not reusuable, so
        //we create new instances as needed.
        task = new Task();
        task.addPropertyChangeListener(this);
        task.execute(); //SwingWorker execute
    }

    //done() - WorkerThread에서 전달
    //Invoked when task's progress property changes.
    public void propertyChange(PropertyChangeEvent evt) {
        if ("progress" == evt.getPropertyName()) {

            int progress = (Integer) evt.getNewValue();
            progressBar.setValue(progress);
            taskOutput.append(String.format(
                    "Completed %d%% of task.\n", task.getProgress()));
        }
    }

    /**
     * Create the GUI and show it. As with all GUI code, this must run
     * on the event-dispatching thread.
     * */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("ProgressBarDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new ProgressBarDemo();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}