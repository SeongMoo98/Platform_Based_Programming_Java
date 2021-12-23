package Enum;

enum Fruit2{
    APLLE("사과"), GRAPE("포도"), PEAR("배");

    private final String name;
    private Fruit2(final String name){ this.name = name; };
    public String getName(){ return name; }

}

public class Enum_3{
    public static void main(String[] args) {
     final Fruit2[] fruits= {Fruit2.PEAR,Fruit2.GRAPE,Fruit2.APLLE,Fruit2.APLLE};

     for(final Fruit2 fruit : fruits){
         System.out.println("The fruit is "+ fruit.getName());
     }
    }

}