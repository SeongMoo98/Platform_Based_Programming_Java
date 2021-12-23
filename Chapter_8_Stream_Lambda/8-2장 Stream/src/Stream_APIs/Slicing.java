package Stream_APIs;

import Stream_Example.Dish;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Slicing {
    public static void main(String[] args){
        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("shrimp", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER) );

        // sorted된 데이터에 효과적
       List<Dish> filteredMenu = specialMenu.stream()
                .filter((dish)->dish.getCalories() < 320)
                .collect(Collectors.toList());

       filteredMenu.forEach(System.out::println);

    }

}
