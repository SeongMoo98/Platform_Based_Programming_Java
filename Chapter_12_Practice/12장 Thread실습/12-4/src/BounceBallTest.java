import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class BounceBallTest {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    private static void createAndShowGUI() {
        JFrame frame = new BounceBallView();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}


class BounceBallView extends JFrame {
    private BallPanel ballPanel;
    public static final int DEFAULT_WIDTH = 450;
    public static final int DEFAULT_HEIGHT = 350;
    public static final int STEPS = 1000;
    public static final int DELAY = 100;

    public BounceBallView() {
        setTitle("Bounce");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        ballPanel = new BallPanel();
        add(ballPanel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "Start", new ActionListener() {
            public void actionPerformed(ActionEvent event) { addRunnableBall(); }
        });
        addButton(buttonPanel, "Close", new ActionListener() {
            public void actionPerformed(ActionEvent event) { System.exit(0); }
        });
        add(buttonPanel, BorderLayout.SOUTH);
    }
    private void addButton(Container container, String title, ActionListener listener) {
        JButton button = new JButton(title);
        container.add(button);
        button.addActionListener(listener);
    }

    private void addRunnableBall() {
        Ball b = new Ball();
        ballPanel.add(b);
        Runnable r = new BallRunnable(b, ballPanel);
        Thread t = new Thread(r);
        t.start();
    }

}

class BallRunnable implements Runnable {
    private Ball ball;
    private JPanel ballPanel;
    public static final int STEPS = 1000;
    public static final int DELAY = 16;

    public BallRunnable(Ball aBall, JPanel ballPanel) {
        ball = aBall;  this.ballPanel = ballPanel;
    }
    public void run() {
        try {
            for (int i = 1; i <= STEPS; i++) {
                ball.move(ballPanel.getBounds()); // update the location of the ball
                ballPanel.paint(ballPanel.getGraphics());
                Thread.sleep(DELAY);
            }
        } catch (InterruptedException e) { e.printStackTrace();}
    }

}

class Ball {
    private static final int XSIZE = 15;
    private static final int YSIZE = 15;
    private double x = ThreadLocalRandom.current().nextDouble(0, 15) ;
    private double y = ThreadLocalRandom.current().nextDouble(0, 15);
    private double dx = 1;
    private double dy = 1;
    private double directionX = 1.0d;
    private double directionY = 1.0d;

    public void move(Rectangle2D bounds) { // java.awt.geom.Rectangle2D
        dx = ThreadLocalRandom.current().nextDouble(0, 10) * directionX;
        dy = ThreadLocalRandom.current().nextDouble(0, 10) * directionY;
        x += dx; y += dy;
        if (x < bounds.getMinX()) {  x = bounds.getMinX(); directionX = -directionX; }
        if (x + XSIZE >= bounds.getMaxX()) { x = bounds.getMaxX() - XSIZE;  directionX= -directionX;  }
        if (y < bounds.getMinY()) { y = bounds.getMinY();  directionY = -directionY; }
        if (y + YSIZE >= bounds.getMaxY()) { y = bounds.getMaxY() - YSIZE; directionY = -directionY; }
    }

    public Ellipse2D getShape() { return new Ellipse2D.Double(x, y, XSIZE, YSIZE); }


}


class BallPanel extends JPanel {
    public void add (Ball b) {
        System.out.println("add: " + Thread.currentThread().getName());
        balls.add(b);
    }
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        System.out.println("paintComponent: " + Thread.currentThread().getName());
        for (Ball b : balls) { g2.fill(b.getShape()); }
    }
    private List<Ball> balls = new CopyOnWriteArrayList<Ball>();

}
