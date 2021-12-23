package Stream_APIs;

import Stream_Example.Dish;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Truncating {
    public static void main(String[] args){
        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("shrimp", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER) );

        //limit(n) - stream에서 앞의 n개만 취한다
        List<Dish> dishes = specialMenu.stream()
                .filter((dish) -> dish.getCalories() > 300)
                .limit(3)
                .collect(Collectors.toList());
        dishes.forEach(System.out::println);

    }
}
