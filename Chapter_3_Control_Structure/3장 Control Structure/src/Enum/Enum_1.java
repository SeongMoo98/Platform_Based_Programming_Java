package Enum;

import java.io.InputStream;
import java.util.Scanner;

enum Fruit{APPLE,GRAPE,PEAR,NO_FRUIT};

public class Enum_1 {
    public static void main(String[] args){
        final Fruit apple=Fruit.APPLE; //Fruit.valueOf("APPLE");
        System.out.println(apple);

        final String 사과=getFruitKoreanName(apple);
        System.out.println(apple.name()+" is "+사과);

        final Fruit fruit=getFruit(System.in);
        final String fruitName=getFruitKoreanName(fruit);
        System.out.println(fruit.name()+" is "+ fruitName);
    }


    private static String getFruitKoreanName(final Fruit myFruit){
        String fruitName;
        switch (myFruit){
            case APPLE: fruitName="사과"; break;
            case GRAPE: fruitName="포도"; break;
            case PEAR: fruitName="배"; break;
            default: fruitName="모름"; break;
        }
        return fruitName;
    }

    private static Fruit getFruit(InputStream in){
        final Scanner scanner=new Scanner(in);
        final String fruitName=scanner.next();

        Fruit fruit;
        try{
            fruit=Fruit.valueOf(fruitName.toUpperCase());
        }
        catch(IllegalArgumentException e){
            fruit=Fruit.NO_FRUIT;
        }
        finally {
            scanner.close();
        }
        return fruit;
    }
}
