package Enum;

enum Currency {
    PENNY(1), NICKLE(5),DIME(10),QUARTER(25);
    private final int value;
    private Currency(final int value){ this.value=value; }
    public int getValue(){ return value; }
}
public class Enum_2 {
    public static void main(String[] args) {
        final Currency usCoin=Currency.DIME;
        if(usCoin == Currency.DIME){
            System.out.println("enum can be compared using ==");
        }
        for(final Currency coin : Currency.values())
        {
            System.out.println(coin.name()+" "+coin.getValue());
        }

    }
}
