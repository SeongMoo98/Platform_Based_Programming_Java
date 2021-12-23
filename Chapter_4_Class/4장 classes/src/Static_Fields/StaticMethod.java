package Static_Fields;

import Parameter_Passing.Point;

class Rectangle8{
    private Point leftTop;
    private Point rightBottom;

    //동일 클래스의 모든 객체들이 공유하는 static 변수
    //프로그램 실행과 동시에 할당
    private static int AllCount=0;
    public static boolean noRectangle(){
        return AllCount==0;
    }
    public static int getAllCount(){
        return AllCount;
    }

    public Rectangle8(Point p1, Point p2){
        AllCount++;
        leftTop=new Point(p1.getX(),p1.getY());
        rightBottom=new Point(p2.getX(),p2.getY());
    }
    public Rectangle8(){
        AllCount++;
    }
}

public class StaticMethod {
    public static void main(String[] args){
        var r1=new Rectangle8();
        var r2=new Rectangle8(new Point(0,0),new Point(10,20));

        System.out.println(Rectangle8.getAllCount());
    }
}
