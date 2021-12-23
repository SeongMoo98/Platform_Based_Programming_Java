package Abstract;

//abstract 메소드가 하나라도 존재하면 abstract class
//객체 생성 불가능, 그러나 참조는 가능
public abstract class Shape {
    private int lineColor;

    public int getLineColor(){
        return lineColor;
    }
    public void setLineColor(int color){
        this.lineColor=color;
    }

    public abstract void draw() ;
    public abstract float getLength();
}
