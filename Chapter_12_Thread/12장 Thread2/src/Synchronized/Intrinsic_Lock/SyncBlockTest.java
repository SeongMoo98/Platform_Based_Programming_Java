package Synchronized.Intrinsic_Lock;

import java.util.ArrayList;
import java.util.List;

public class SyncBlockTest {
    private List<Integer> list1=new ArrayList<>();
    private List<Integer> list2=new ArrayList<>();

    //List1, 2에 대한 lock1, 2
    private final Object lock1= new Object();
    private final Object lock2= new Object();

    public static void main(String[] args){
        SyncBlockTest  syncBlockTest= new SyncBlockTest();
        System.out.println("Test Start");

        new Thread(()-> {
            for(int i=0; i<10000;i++){
                syncBlockTest.put1(i);
                syncBlockTest.get1(i);
            }
        }).start();

        new Thread(()-> {
            for(int i=0; i<10000;i++){
                syncBlockTest.put2(i);
            }
        }).start();


    }

    public void put1(int value){
        synchronized (lock1){
            list1.add(value);
        }
    }
    public void get1(int index){
        synchronized (lock1){
            System.out.println(list1.get(index));
        }
    }
    public void put2(int value) {
        synchronized (lock2){
            list2.add(value);
        }
    }
}
