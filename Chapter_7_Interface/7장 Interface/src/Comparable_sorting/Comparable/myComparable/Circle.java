package Comparable_sorting.Comparable.myComparable;

public class Circle implements MyComparable{
    public int x,y,radius;
    public Circle(int x, int y, int radius) {
        this.x = x ; this.y = y ; this.radius = radius ;
    }


    @Override
    public int compareTo(Object other){
        if(!(other instanceof Circle)){
            return 0;
        }
        Circle otherCircle=(Circle) other;
        int retValue=0;

        if(radius<otherCircle.radius){
            retValue=-1;
        }
        else if(radius>otherCircle.radius){
            retValue =1;
        }
        else{
            retValue=0;
        }

        return retValue;
    }

    @Override
    public boolean equal(Object other){
        if(!(other instanceof Circle)){
            return false;
        }
        Circle otherCircle =(Circle) other;
        return x == otherCircle.x && y == otherCircle.y
                && radius == otherCircle.radius;
    }
    @Override
    public String toString(){
        return String.format("Center : (%d %d), Radius : %d",x,y,radius);
    }
}

