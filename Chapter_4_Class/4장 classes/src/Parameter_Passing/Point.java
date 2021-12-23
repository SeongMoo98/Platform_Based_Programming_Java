package Parameter_Passing;

import BasicMethods.toString과equals.Rectangle4;

//Java는 pass-by-value
//==>reference type이 복사된다
public class Point {
    private int x,y;
    public Point(int x, int y){
       set(x,y);
    }

    public void set(int x, int y){
        this.x=x;
        this.y=y;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }

    public String toString(){
        return String.format("(%d, %d)",x,y);
    }
    public boolean equals(Object otherPoint) {
        if(!(otherPoint instanceof Point)){
            return false;
        }
        var p = (Point) otherPoint;
        return x == p.x && y == p.y;
    }
}

class Rectangle5{
    private Point leftTop;
    private Point rightBottom;

    //Each parameter of class variable is reference type
    //and passed by value
    public Rectangle5(Point p1, Point p2){
        leftTop=p1; rightBottom=p2;
    }

    public boolean equals(Object otherRectangle){
        if(!(otherRectangle instanceof Rectangle5)){
            return false;
        }
        var r=(Rectangle5)otherRectangle;
        return leftTop.equals(r.leftTop) && rightBottom.equals(r.rightBottom);
    }
    public String toString(){
        return leftTop+ ", "+rightBottom;
    }
}
