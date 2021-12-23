package Stream_APIs;

import Stream_Example.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Skipping {
    public static void main(String[] args){
        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("shrimp", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER) );

        //skip(n) - stream에서 앞의 n개를 버림
        List<Dish> dishes = specialMenu.stream()
                .filter((dish) -> dish.getCalories() > 300)
                .skip(2)
                .collect(Collectors.toList());
        dishes.forEach(System.out::println);

    }




}
