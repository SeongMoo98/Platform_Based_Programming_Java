package Comparable_sorting.Comparable.myComparable;

public class CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle(10, 10, 10);
        Circle c2 = new Circle(10, 10, 10);
        Circle c3 = new Circle(0, 0, 20);
//        //MyComparable interface로 Circle참조 가능
//        MyComparable[] list = {c1, c2, c3};
//        for(int i=0; i< list.length;i++){
//            if (list[0].compareTo(list[i])<0){
//                System.out.println(list[0] + " has smaller size than " + list[i]);
//            }
//            if(list[0].compareTo(list[i])==0){
//                System.out.println(list[0] + " has the same size as " + list[i]) ;
//            }
//            if ( list[0].compareTo(list[i]) == 0 ) {
//                System.out.println(list[0] + " has the larger size than " + list[i]);
//            }
//
//        }
        MyComparable[] list2 = {c1, c2, c3};
        MySort.sort(list2);
        for(Object o:list2){
            System.out.println(o);
        }

    }


}
