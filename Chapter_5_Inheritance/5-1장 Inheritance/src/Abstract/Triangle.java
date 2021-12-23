package Abstract;

public class Triangle extends Polygon{
    public Triangle(float x1, float y1,float x2,float y2,float x3,float y3 ){
        addPoint(x1,y1); addPoint(x2,y2); addPoint(x3,y3);
    }
    @Override
    public void draw(){
        System.out.println("Triangle");
        super.draw();
    }
}
