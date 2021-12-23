package Interface_Basics;

interface Relatable{
    public int isLargerThan(Relatable other);
    int getHeight();
}
public class RectanglePlus implements Relatable{
    public int width,height;
    public RectanglePlus(int w,int h){
        this.width=w;
        this.height=h;
    }
    public int getArea() {
        return width*height;
    }
    @Override
    public int getHeight(){
        return height;
    }

    @Override
    public int isLargerThan(Relatable other){
        RectanglePlus otherRect=(RectanglePlus) other;
        if(this.getArea()<otherRect.getArea()){
            return -1;
        }
        else if(this.getArea()>otherRect.getArea()){
            return 1;
        }
        else{
            return 0;
        }
    }

    public static void main(String[] args){
        RectanglePlus rp=new RectanglePlus(2,10);
        //interface를 new하는건 안됨
        //Relatable r=new Relatable()
        Relatable r= rp;
        //안된다
        //r.getArea;
        System.out.println(r.getHeight());
        System.out.println(r.getHeight());
    }
}
