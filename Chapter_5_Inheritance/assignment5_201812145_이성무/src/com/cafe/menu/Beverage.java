package com.cafe.menu;

public abstract class Beverage {
    public static final int TALL = 0;
    public static final int GRANDE = 1;
    public static final int VENTI = 2;

    String name;
    int basePrice;
    int size;
    public Beverage(String name, int basePrice, int size){
        this.name=name;
        this.basePrice=basePrice;
        this.size=size;
    }

    public String getName(){ return this.name; }
    public int getBasePrice(){
        return this.basePrice;
    }
    public String getSize() {
        String str;
        if (this.size == 0) {
            str="TALL";
            return str;
        }
        else if (this.size == 1) {
            str="GRANDE";
            return str;

        }
        else if (this.size == 2) {
            str="VENTI";
            return str;
        }
        else{
            return null;
        }
    }

    public void setPrice(int price){
        this.basePrice=price;
    }


    //setSize 매개변수 타입이 달라도 가능하다
    public boolean setSize(int size){
        this.size=size;
        return true;
    }
    public boolean setSize(String size) {
        if ("TALL".equals(size))
            return setSize(TALL);
        else if ("GRANDE".equals(size))
            return setSize(GRANDE);
        else if ("VENTI".equals(size))
            return setSize(VENTI);
        return false;
    }
    @Override
    public abstract boolean equals(Object otherObject);

}


