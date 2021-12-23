package WrapperClass;

import java.util.List;
import java.util.ArrayList;

public class AutoUnboxing {
    public static void main(String[] args){
        List<Integer> integerList=new ArrayList<>();
        for(int i = 1;i <= 5; i++){
            //AutoBoxing
            integerList.add(i);
        }
        System.out.println(integerList);


        int sumOfEven = 0;
        for(Integer i : integerList){
            //Integer AutoUnboxing - 2때문에 Unboxing
            if(i % 2 == 0) {
                sumOfEven+=i;
            }
        }
        System.out.println(sumOfEven);
    }

}
