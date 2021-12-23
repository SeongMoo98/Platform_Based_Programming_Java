package Bounds_for_Type_Parameter;

class Pair<T>{
    private T first, second;
    public Pair() {first =null; second=null; }
    public Pair(T first, T second) { this.first=first; this.second=second; }
    public T getFirst() { return this.first; }
    public T getSecond() { return this.second; }
    public void setFirst(T newValue){ this.first=newValue; }
    public void setSecond(T newValue){ this.second=newValue; }
}

class ArrayAlgForString { // Not generic. It is only for String
    public static Pair<String> minMax(String[] a) {
        String min = a[0], max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) min = a[i];
            if (max.compareTo(a[i]) < 0) max = a[i];
        }
        return new Pair<String>(min, max);
    }
}
public class PairTest3_1 {
    public static void main(String[] args) {
        String[] words = { "cd", "ab", "lm", "ef" };
        Pair<String> mm = ArrayAlgForString.minMax(words);

        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());

    }
}