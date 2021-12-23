package Stream_APIs;

import Stream_Example.Dish;
import java.util.List;
import java.util.stream.Collectors;

public class Mapping {
    public static void main(String[] args){
        //map - Stream<Dish> -> Stream<String>
        //==> 개수에 변화가 없다
        List<String> dishNames = Dish.menu.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println(dishNames);

        List<Integer> dishNameLength = Dish.menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(dishNameLength);
    }
}
