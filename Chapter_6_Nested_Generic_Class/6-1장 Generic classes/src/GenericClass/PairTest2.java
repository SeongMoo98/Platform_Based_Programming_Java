package GenericClass;

import java.io.Serializable;

class Pair2<T extends Number& Serializable>{
    private T first, second;

    public Pair2(){ first=null; second=null; }
    public Pair2(T first, T second){ this.first=first; this.second=second; }
    public T getFirst() { return first; }
    public T getSecond() { return second; }
    public void setFirstT(T newValue){ this.first=newValue; }
    public void setSecondT(T newValue){ this.second=newValue; }

}
public class PairTest2 {
    public static void main(String[] args){
        Pair2<Integer> intPair=new Pair2<Integer>();
        intPair.setFirstT(1);
        intPair.setSecondT(100);
        System.out.println(intPair.getFirst() + " "+intPair.getSecond());


        Pair2<Float> floatPair=new Pair2<Float>(1.1F,100.1F);
        System.out.println(floatPair.getFirst()+" "+floatPair.getSecond());
    }
}
