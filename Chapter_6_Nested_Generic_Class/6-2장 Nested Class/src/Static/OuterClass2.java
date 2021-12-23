package Static;

public class OuterClass2 {
    private String name;

    static class StaticNestedClass{
        int id=0;
        //static InnerClass에서는 static 멤버선언가능
        static int COUNT=5;
    }
    public String toString(){
        String msg="Instance "+name;
        return msg;
    }
    StaticNestedClass snc=new StaticNestedClass();

    public static void main(String[] args){
        //main이 static이랑 static InnerClass 선언가능
        StaticNestedClass s=new StaticNestedClass();
        System.out.println(s.COUNT);
    }
    public int getCount() {
        StaticNestedClass s = new StaticNestedClass();
        return s.COUNT;
    }
}
