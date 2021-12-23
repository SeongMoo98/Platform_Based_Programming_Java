package Parameter_Passing;


class Rectangle6{
    private Point leftTop;
    private Point rightBottom;

    public Rectangle6(Point p1, Point p2){
        //reference타입으로 참조한 객체의 변수값으로 새로운 객체 생성
        //DeepCopy
        leftTop=new Point(p1.getX(),p1.getY());
        rightBottom=new Point(p2.getX(),p2.getY());
    }
    public boolean equals(Object otherRectangle){
        var r=(Rectangle6)otherRectangle;
        return leftTop.equals(r.leftTop) && rightBottom.equals(r.rightBottom);
    }
    public String toString(){
        return leftTop+ ", "+rightBottom;
    }
}
public class DeepCopy {
    public static void main(String []args){
        var p1=new Point(0,0);
        var p2=new Point(10,20);

        var r=new Rectangle6(p1,p2);
        System.out.println(r);

        p2.set(100,200);
        System.out.println(r);
    }
}
