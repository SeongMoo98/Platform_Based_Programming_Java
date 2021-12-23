package Abstract;

import java.util.ArrayList;
import java.util.List;

public class ShapeHierarchyTest {
    public static void main(String[] args) {
        Circle c1 = new Circle(0F, 5.5F, 10F);
        //c1.draw();

        Triangle t1 = new Triangle(0f, 0f, 10f, 0f, 20f, 20f);
        //t1.draw();

        Rectangle r1 = new Rectangle(0f, 0f, 10f, 0f, 10f, 10f, 0f, 10f);
        //r1.draw();

        Line l1 = new Line(10f, 10f, 15f, 10f);
        //l1.draw();

        List<Shape> shapes= new ArrayList<>();
        shapes.add(c1); shapes.add(t1); shapes.add(r1); shapes.add(l1);
        for(Shape s : shapes){ s.draw();}
    }

}
