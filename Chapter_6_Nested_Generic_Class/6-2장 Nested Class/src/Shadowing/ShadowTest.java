package Shadowing;

public class ShadowTest {
    public int x=0;

    class FirstLevel{
        //FirstLevel의 x때문에 ShadowText의 x가 가려진다
        //enclosing scope에 의해 shadowing ->가장 가까운 변수에 접근
        public int x=1;
        void methodInFirstLevel(int x){
            System.out.println("x = "+x);
            System.out.println("this.x = "+this.x);
            System.out.println("ShadowTest.this.x = "+ShadowTest.this.x);
        }
    }
    public static void main(String[] args){
        ShadowTest st=new ShadowTest();
        ShadowTest.FirstLevel fI=st.new FirstLevel();

        fI.methodInFirstLevel(23);
    }


}
