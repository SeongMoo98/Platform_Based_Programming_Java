package Stream_APIs;

import Stream_Example.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Slicing2 {
    public static void main(String[] args){
        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("shrimp", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER) );
        //takeWhile - 조건이 틀리면 뒤에껀 버림
        List<Dish> slicedMenu1 = specialMenu.stream()
                .takeWhile((dish)->dish.getCalories() < 320)
                .collect(Collectors.toList());
        slicedMenu1.forEach(System.out::println);

        System.out.println();

        //dropWhile - 조건이 틀리면 앞에껀 버림
        List<Dish> slicedMenu2 = specialMenu.stream()
                .takeWhile((dish)->dish.getCalories() < 320)
                .collect(Collectors.toList());
        slicedMenu2.forEach(System.out::println);
    }
}
