package Comparable_sorting.Comparable.Multi_Interface;

public class AreaComputableTest {
    public static void main(String[] args){
        Circle2 c1 = new Circle2(0, 0, 15) ;
        Circle2 c2 = new Circle2(10, 10, 10) ;

        Triangle t1 = new Triangle(10, 20) ;
        Triangle t2 = new Triangle(20, 20) ;
        AreaComputable[] list={c1,c2,t1,t2};

        float totalArea=0;
        for(AreaComputable elem:list){
            final float area=elem.getArea();
            System.out.printf("%s Area : %10.2f%n",elem,area);
            totalArea+=area;
        }
        System.out.printf("Total Area%n%10.2f%n",totalArea);
    }
}
