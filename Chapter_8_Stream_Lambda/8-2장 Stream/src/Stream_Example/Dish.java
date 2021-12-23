package Stream_Example;

import javax.lang.model.element.TypeElement;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Dish {
    public enum Type{MEAT,FISH,OTHER}
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type){
        this.name=name; this.vegetarian=vegetarian;
        this.calories=calories; this.type=type;
    }

    public String getName(){
        return name;
    }
    public boolean isVegetarian(){
        return vegetarian;
    }
    public int getCalories(){
        return calories;
    }
    public Type getType(){
        return type;
    }
    @Override
    public String toString(){
        return "이름 : "+getName()+" 채식 : "+isVegetarian()+
                " 칼로리 : "+getCalories()+" 종류 : "+getType().name();
    }
    public static  List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH) );


    public static void main(String[] args){
        List<String> threeHighCaloricDishNames =
                menu.stream()//Stream 생성
                        .filter((dist)->dist.getCalories() > 300)  //lambda로 조건에 만족하는 data
                        .map(Dish::getName)                        // Dish 객체를 String객체로 반환
                        .limit(3)                                  //데이터 개수를 3개로 제한 - 첫번째 3개
                        .collect(Collectors.toList());             //Stream을 List로 변환
        System.out.println(threeHighCaloricDishNames);



    }

}
