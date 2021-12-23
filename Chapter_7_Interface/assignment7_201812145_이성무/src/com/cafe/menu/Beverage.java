package com.cafe.menu;

public abstract class Beverage {
    enum SIZE{TALL, GRANDE, VENTI}
    String name;
    int basePrice;
    SIZE size;

    public Beverage(String name, int basePrice, SIZE size){
        this.name=name;
        this.basePrice=basePrice;
        this.size=size;
    }
    public int getPrice(){ return this.basePrice; }

    @Override
    public String toString() {
    return "name=" + name + ", Price=" + getPrice() + ", size=" + size.name();
    }
}


