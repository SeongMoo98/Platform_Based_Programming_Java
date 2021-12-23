package Comparable_sorting.Comparable.Multi_Interface;

import Comparable_sorting.Comparable.myComparable.MyComparable;

public class Circle2 implements MyComparable, AreaComputable {
    private int x, y;
    private int radius;

    public Circle2(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public int compareTo(Object other){
        if(!(other instanceof Circle2)){
            return 0;
        }
        Circle2 otherCircle=(Circle2) other;
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
        if(!(other instanceof Circle2)){
            return false;
        }
        Circle2 otherCircle =(Circle2) other;
        return x == otherCircle.x && y == otherCircle.y
                && radius == otherCircle.radius;
    }
    public float getArea(){
        return (float)Math.PI*radius*radius;
    }
    @Override
    public String toString(){
        return String.format("Center : (%d, %d), Radius : %d",x,y,radius);
    }
}

