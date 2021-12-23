package Information_Hiding;

//overloading
public class Rectangle3 {
    private int leftTopX, leftTopY;
    private int rightBottomX, rightBottomY;

    public Rectangle3(int x1, int y1, int x2, int y2){
        this.leftTopX = x1;
        this.leftTopY = y1;
        this.rightBottomX = x2;
        this.rightBottomY = y2;
    }

    public void moveBy(int deltaX, int deltaY){
        leftTopX += deltaX ; leftTopY += deltaY ; rightBottomX += deltaX ; rightBottomY += deltaY ;
    }

    public void moveBy(int delta){
        moveBy(delta,delta);
    }

    public void print() {
        System.out.printf("(%6d, %6d), (%6d, %6d)%n",leftTopX,leftTopY,rightBottomX,rightBottomY);
    }

}
