package Comparable_sorting.Comparable.myComparable;

public class MySort {
    public static void sort(MyComparable[] elements){
        for(int i=0; i< elements.length;i++){
            for(int j=i+1; j<elements.length;j++){
                if(elements[i].compareTo(elements[j])>0){
                    MyComparable temp=elements[j];
                    elements[i]=elements[i];
                    elements[i]=temp;
                }
            }
        }
    }
}
