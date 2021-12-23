package ExecutingThread;

/*
 * Runnable
 * Thread를 Creating하고 Executing하는 첫번째 방법
 * Runnable을 Implements해서 run()메소드 구현
 * The Runnable object is passed to the Thread constructor
 * Runnable interface는 run() Method 하나만 존재 - @FunctionalInterface
 */


public class HelloRunnable implements Runnable{
        public static void main(String[] args){
                //Thread생성자에 Runnable object를 넘겨준다
                Thread thread = new Thread(new HelloRunnable());
                thread.start();
                //(new Thread(new ExecutingThread.HelloRunnable())).start();
        }
        @Override
        public void run() {
                System.out.println("Hello from a Thread");
        }
}
