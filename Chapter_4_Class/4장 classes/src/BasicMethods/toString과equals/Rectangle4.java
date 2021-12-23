package BasicMethods.toString과equals;

public class Rectangle4 {
    private int leftTopX, leftTopY;
    private int rightBottomX, rightBottomY;
    public Rectangle4(int x1, int y1, int x2, int y2){
        leftTopX = x1; leftTopY = y1; rightBottomX = x2; rightBottomY = y2;
    }

    //모든 클래스의 부모 클래스의 Object클래스
    //Methods - toString, equals, hashCode
    public boolean equals(Object otherRectangle) {
        if (!(otherRectangle instanceof Rectangle4))
            return false;
        //Object 객체를 Rectangle4 객체로 Explicit Casting
        var r=(Rectangle4)otherRectangle;
        return leftTopX==r.leftTopX && leftTopY==r.leftTopX
                &&rightBottomX==r.rightBottomX && rightBottomY==r.rightBottomY;
    }
    public String toString(){
        return String.format("(%6d, %6d), (%6d, %6d)%n",leftTopX,leftTopY,rightBottomX,rightBottomY);
    }
}

