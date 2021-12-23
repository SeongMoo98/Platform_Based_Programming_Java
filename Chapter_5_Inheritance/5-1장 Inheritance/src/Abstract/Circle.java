package Abstract;

public class Circle extends ClosedShape{
    private Point center;
    private float radius;

    public Circle(float x, float y, float radius){
        center=new Point(x,y);
        this.radius=radius;
    }

    @Override
    public float getLength(){
        return (float)(2*Math.PI*radius);
    }
    @Override
    public float getArea(){
        return (float)(Math.PI*radius*radius);
    }
    @Override
    public void draw(){
        System.out.println("Circle");
        System.out.printf("Center : %s, Radius : %6.2f%n",center,radius);
    }


}
