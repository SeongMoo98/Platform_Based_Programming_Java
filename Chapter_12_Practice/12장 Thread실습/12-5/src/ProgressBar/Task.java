package ProgressBar;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

class Task extends SwingWorker<Void, Void> {
    //Main ProgressBar.Task. Executed in background thread
    @Override
    protected Void doInBackground() throws Exception {
        Random random = new Random();
        int progress = 0;
        //Initialize progress property
        setProgress(0);
        while(progress<100){
            //Sleep for up to one second
            try {
                Thread.sleep(random.nextInt(1000));
            }
            catch (InterruptedException ignore){}
            //make Random progress
            progress += random.nextInt(10);
            setProgress(Math.min(progress, 100));
        }
        return null;
    }

    //Execute in event dispatching thread
    @Override
    public void done(){
        Toolkit.getDefaultToolkit().beep();
    }

}