package Class;
public class Rectangle {
    //fields
    private int leftTopX, leftTopY;
    private int rightBottomX, rightBottomY;


    //methods
    //생성자
    public Rectangle(int x1, int y1, int x2, int y2) {
        this.leftTopX = x1;
        this.leftTopY = y1;
        this.rightBottomX = x2;
        this.rightBottomY = y2;
    }

    //Constructor Chaining - 생성자 내부에서 생성자 호출
    public Rectangle(int x1, int x2) {
        //this를 이용하여 parameter 4개 짜리 생성자 호출 , 첫줄에 적어야함
        this(x1,100,x2,0);
    }

    public void moveBy(int deltaX,int deltaY){
        leftTopX+=deltaX; rightBottomY+=deltaY;
    }

    public void print() {
        System.out.printf("(%6d, %6d), (%6d, %6d)%n",leftTopX,leftTopY,rightBottomX,rightBottomY);
    }
    public static void main(String[] args){
        // r은 참조타입 ==> new로 객체를 할당해줘야함
        // Rectangle r(10,10,200,400)으로 생성 x
        Rectangle r =new Rectangle(10,10,200,400);
        r.print();
        r.moveBy(50,50);
        r.print();
    }
}
