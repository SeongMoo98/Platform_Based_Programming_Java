package Stream_APIs;

import Stream_Example.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

public class Finding {
    public static void main(String[] args){
        //Match는 boolean 반환


        //anyMatch - stream에 존재하는 모든 원소
        //즉, 원소가 존재하는지 안하는지 확인하는데 사용

        if(Dish.menu.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }

        //allMatch - stream의 모든 원소가 일치하는지
        //noneMatch - stream의 일치하는 원소가 존재하지 않는다
        boolean isHealthy1 = Dish.menu.stream()
                .allMatch((dish) -> dish.getCalories() < 1000 );
        System.out.println(isHealthy1);
        boolean isHealthy2 = Dish.menu.stream()
                .noneMatch((dish) -> dish.getCalories() >= 1000 );
        System.out.println(isHealthy2);

        System.out.println();
        System.out.println();


        //Optional<T> - match했는데 null이 되면 굉장히 위험한 상황이다
        // ==> Optional class로 existance or absence를 확인

        //findAny
        Optional<Dish> dish = Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();

        System.out.println(dish.isEmpty());
        System.out.println(dish.isPresent());
        System.out.println(dish.get());
        //System.out.println(dish.orElse(???));
        //T orElse(T other) returns the value if present; otherwise it returns a default value
        //뭔지 모르겠군

        System.out.println();


        //findFirst - 첫번째 원소를 찾는다
        List<Integer> someNumbers = Arrays.asList(1,2,3,4,5);
        Optional<Integer> firstSquareDivisibleByThree =
                someNumbers.stream()
                        .map((n)->n*n)
                        .filter((n) -> n % 3 == 0 )
                        .findFirst();
        System.out.println(firstSquareDivisibleByThree); //Optional 로 print가 되네



    }
}
