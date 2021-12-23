package Bounds_for_Type_Parameter;
class ArrayAlg{
    public static <T extends Comparable<T>> Pair<T> minmax(T[] a){
        T min = a[0];
        T max = a[0];
        for(int i=0; i<a.length; i++){
            if(min.compareTo(a[i])>0) min=a[i];
            if(max.compareTo(a[i])<0) max=a[i];
        }
        return new Pair<T>(min,max);
    }
}
public class PairTest3_2 {
    public static void main(String[] args){
        String[] words={"cd", "ab","lm","ef"};
        Pair<String> mm = ArrayAlg.minmax(words);
        System.out.println("min = "+mm.getFirst()+" max = "+mm.getSecond());

        // Rectangle does not implement Comparable interface.
        //Rectangle[] rectangles = { new Rectangle(0, 0, 10, 10),new Rectangle(0, 0, 20, 20) };
        //Pair<Rectangle> mm2 = ArrayAlg.<Rectangle>minmax(rectangles); //compile error System.out.println("min = " + mm2.getFirst() + " max = " + mm2.getSecond());
    }
}
