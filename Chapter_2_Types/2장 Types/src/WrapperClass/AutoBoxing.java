package WrapperClass;
import java.util.ArrayList;
import java.util.List;
public class AutoBoxing {
    public static void main(String[] args) {
        //List - Collection - <> 객체들만 원소로 가질 수 있다
        //ArrayList - derived class
        List<Integer> integerList=new ArrayList<>();
        for(int i=1; i<10; i++){
            integerList.add(i);
            //add(Integer.valueOf(i) 로 해야하는데 i와 만나서 자동으로 Boxing
        }
        System.out.println(integerList);
        //[1,2,3,4,5,6,7,8,9] 이렇게 출력됨
    }
}
