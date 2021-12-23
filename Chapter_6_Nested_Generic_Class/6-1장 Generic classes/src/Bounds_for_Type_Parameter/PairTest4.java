package Bounds_for_Type_Parameter;

import java.util.*;
class ArrayAlg2{ // Not generic.
    //interface java.lang.Comparable<T>
    //int compareTo(T object)
    //Comparable interface가 구현되어있는 type만 사용가능하나
    public static <T extends Comparable<T>> Pair<T> minMax(T[] a) {
        T min = a[0];
        T max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) min = a[i];
            if (max.compareTo(a[i]) < 0) max = a[i];
        }
        return new Pair<T>(min, max);
    }
}
public class PairTest4 {
    public static void main(String[] args){
        Calendar[] birthdays={
                new GregorianCalendar(1906,Calendar.DECEMBER,9),
                new GregorianCalendar(1815,Calendar.DECEMBER,10),
                new GregorianCalendar(1903,Calendar.DECEMBER,3),
                new GregorianCalendar(1910,Calendar.JUNE,   22),
        };

        Pair<Calendar> mm =ArrayAlg2.minMax(birthdays);
        System.out.println("min = "+mm.getFirst().getTime());
        System.out.println("min = "+mm.getFirst().getTime());
    }
}
