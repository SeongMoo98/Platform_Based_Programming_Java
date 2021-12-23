package com.cafe.order;

import com.cafe.menu.Beverage;

public class OrderItem {
    Beverage beverage;
    int quantity;

    public OrderItem(Beverage beverage, int quantity){
        this.beverage=beverage;
        this.quantity=quantity;
    }

    public Beverage getBeverage(){
        return beverage;
    }

    public String toString() {
        return String.format("[ name=%s, Price=%d, size=%s, quantity=%d ]", beverage.getName(), beverage.getBasePrice(), beverage.getSize(), quantity);
    }
}
