package Information_Hiding;

//class can be public or not
class Rectangle2 {
    private int leftTopX, leftTopY;
    private int rightBottomX, rightBottomY;

    private void setLeftTop(int x, int y){
        leftTopX=x; leftTopY=y;
    }
    private void setRightBottom(int x, int y){
        rightBottomX=x; rightBottomY=y;
    }

//    //Package private - 같은 package에 있으면 public으로 간주
//    //but 같은 package가 아니면 private
//    void setLeftTop(int x, int y){ leftTopX=x; leftTopY=y; }
//    void setRightBottom(int x, int y){ rightBottomX=x; rightBottomY=y; }    }

    public Rectangle2(int x1, int y1, int x2, int y2){
        //생성자에서 private 함수로 멤버변수 초기화
        setLeftTop(x1,y1);
        setRightBottom(x2,y2);
    }
    public int getArea(){
        return (rightBottomX -leftTopY)*(rightBottomY-leftTopY);
    }
}

public class RectangleTest{
    public static void main(String[] args){
        var r1=new Rectangle2(0,0,50,50);
        var r2=new Rectangle2(0,0,100,100);
        System.out.println(r1.getArea());
        System.out.println(r2.getArea());

        //private 함수 - setLeftTop
        //r1.setLeftTop(10,10);
    }
}
