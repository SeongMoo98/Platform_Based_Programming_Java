package Abstract;
public class Point {
    private float x,y;
    public Point(float x, float y){
       set(x,y);
    }

    public void set(float x, float y){
        this.x=x;
        this.y=y;
    }
    public float getX(){
        return this.x;
    }
    public float getY(){
        return this.y;
    }

    public String toString(){
        return String.format("[%.2f, %.2f]",x,y);
    }
    public boolean equals(Object otherPoint) {
        var p = (Point) otherPoint;
        return x == p.x && y == p.y;
    }
}
