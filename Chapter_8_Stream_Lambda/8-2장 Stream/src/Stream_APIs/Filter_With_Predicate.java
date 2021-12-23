package Stream_APIs;

import Stream_Example.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Filter_With_Predicate {
    public static void main(String[] args){
        //Predicate - parameter : T(Dish), return Type : boolean
        List<Dish> vegetarianDishes = Dish.menu.stream()
                .filter(Dish::isVegetarian).collect(Collectors.toList());

        vegetarianDishes.forEach(System.out::println);
    }
}
