package Lambda_Expression.Function_T_R;
/**
 * FuntionM<T,R> - T : Argument Type, R : Return Type
 * R apply(T t)
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionalInterfaceExample {
    public static void main(String[] args){
        //String을 받아서 Integer return
        List<Integer> list= map(Arrays.asList("lambdas", "in", "action"), (String s)->s.length());
        List<String> list2 =map(Arrays.asList(1,2,3,4,5),(Integer I) -> Integer.toString(I));
        System.out.println(list);
        System.out.println(list2);

        //T : String , R : Integer
        //parameter : String s
        //apply method의 expression - s.length()
        //Return Type : Integer
    }
    //<T,R>에 대해 Generic
    //return Type : List<R>
    private static <T,R> List<R> map(List<T> list, Function<T,R> f) {
        List<R> result = new ArrayList<>();
        for(T t : list){
            result.add(f.apply(t));
        }
        return result;
    }

}
