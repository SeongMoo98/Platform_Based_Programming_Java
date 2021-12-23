package Liveness;

public class DeadLockTest {
    static class Friend{
        private final String name;
        public Friend(String name){ this.name=name; }
        public String getName(){ return this.name; }
        public synchronized void bow(Friend bower){
            System.out.format("%s : %s has vowed to me%n",this.name,bower.getName());
            bower.bowBack(this);
        }

        public synchronized void bowBack(Friend bower){
            System.out.format("%s : %s has vowed back to me%n",this.name, bower.getName());
        }
    }


    public static void main(String[] args){

        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston = new Friend("Gaston");

        //alponse의 bow가 실행되면 alponse의 lock을 얻어서 실행
        //그 후 bower(gaston)의 bowBack실행
        //==>bower의 lock을 요청(waiting)
        new Thread(new Runnable() {
            @Override
            public void run() { alphonse.bow(gaston); }
        }).start();

        //gaston의 bow가 실행 ==> gaston의 lock accquire
        //alponse의 lock을 wainting
        new Thread(new Runnable() {
            @Override
            public void run() { gaston.bowBack(alphonse); }
        }).start();

    }
}
