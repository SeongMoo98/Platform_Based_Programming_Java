package GenericClass;

class Pair<T>{
    private T first, second;

    public Pair() {first =null; second=null; }
    public Pair(T first, T second) { this.first=first; this.second=second; }
    public T getFirst() { return this.first; }
    public T getSecond() { return this.second; }
    public void setFirst(T newValue){ this.first=newValue; }
    public void setSecond(T newValue){ this.second=newValue; }
}



public class PairTest1 {
    public static void main(String[] args){
        Pair<String> strPair = new Pair<String>();
        strPair.setFirst("Name");
        strPair.setSecond("Value");
        System.out.println(strPair.getFirst()+" "+strPair.getSecond());
    }
}
