package Abstract;

public class Line extends OpenShape{
    private Point start,end;
    public Line(float x1,float y1,float x2, float y2){
        start=new Point(x1,y1);
        end=new Point(x2,y2);
    }

    @Override
    public float getLength(){
        return (float)Math.sqrt(Math.pow(start.getX()- end.getX(),2) + Math.pow(start.getY()- end.getY(),2));

    }
    public void draw(){
        System.out.println("Line");
        System.out.printf("\tStart : %s, End : %s%n",start,end);
    }
}
