package Abstract;

public class Rectangle extends Polygon{
    public Rectangle(float x1, float y1, float x2, float y2,float x3, float y3,float x4, float y4){
        addPoint(x1,y1); addPoint(x2,y2); addPoint(x3,y3); addPoint(x4,y4);
    }

    @Override
    public void draw(){
        System.out.println("Rectangle");
        super.draw();
    }
}
