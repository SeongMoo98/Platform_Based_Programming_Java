package Enum;

import java.util.Currency;
import java.text.DecimalFormat;


enum ShoesKind{
    WALKING("워킹화",100_000),
    RUNNING("러닝화",200_000),
    TRACKING("트래킹화",300_000);

    private final String name;
    private final int price;
    private ShoesKind(final String name, final int price){
        this.name=name;
        this.price=price;
    }
    public String getName(){ return name; }
    public int getPrice(){ return price;}
}
public class Enum_4 {
    public static void main(String[] args){
        final DecimalFormat priceFormat=new DecimalFormat("###,###");
        final Currency currency=priceFormat.getCurrency();

        final ShoesKind[] ShoesArr= {ShoesKind.WALKING,ShoesKind.RUNNING,ShoesKind.TRACKING};
        for(final ShoesKind sh:ShoesArr){
            System.out.println(sh.name());
        }
        for(final ShoesKind shoes: ShoesKind.values()){
            System.out.println(String.valueOf(shoes).toLowerCase()+" "
                    +shoes.getName()+" : "
                    +priceFormat.format(shoes.getPrice())+currency);
        }
    }
}
