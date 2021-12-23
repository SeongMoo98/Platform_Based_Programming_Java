package Abstract;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Polygon extends ClosedShape {
    private List<Point> points =new ArrayList<>();
    protected void addPoint(float x, float y){
        Point p = new Point(x, y) ;
        points.add(p);
    }

    @Override
    public float getLength(){
        float length=0;
        return length;
    }
    @Override
    public float getArea(){
        float area=0;
        return area;
    }
    @Override
    public void draw(){
        for(final Point p:points){
            System.out.print(p);
            System.out.println();
        }
    }
}
