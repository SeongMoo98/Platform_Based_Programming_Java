package Parameter_Passing;

public class ParameterPassing {
    public static void main(String[] args){
        var p1=new Point(0,0);
        var p2=new Point(10,20);

        var r= new Rectangle5(p1,p2);
        System.out.println(r);

        p2.set(100,200);
        System.out.println(r);

    }
}
