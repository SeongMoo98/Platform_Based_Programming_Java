package NonStatic;

public class OuterClass {
    private String name;
    public static int count = 0;

    //InnerClass에서는 어떠한 static 멤버도 선언할수없다
    class InnerClass {
        int inner = 2;
        //static int count =0; - error
    }

    public static int next() {
        return count++;
    }

    public String toString() {
        //LocalClass - toString 함수가 종료되면 소멸
        class LocalClass {
            int local = 0;
            //final static은 되는건가 - constant
            final static int COUNT = 0;
        }
        String msg = "Instance " + name;
        return msg;
    }

    InnerClass ic = new InnerClass();

    public static void main(String[] args) {
        //InnerClass i =new InnerClass(); --static에서 선언불가
        OuterClass oc = new OuterClass();
        //OuterClass객체에서 Innerclass를 생성해야한다
        InnerClass i = oc.new InnerClass();
        System.out.println(i.inner);// - Outerclass 내부의 main함수에서 private멤버에 접근가능
    }

    public int getHash() {
        //LocalClass - toString 함수가 종료되면 소멸
        //LocalClass lc=new LocalClass();
        return (new InnerClass()).hashCode();
    }
}

