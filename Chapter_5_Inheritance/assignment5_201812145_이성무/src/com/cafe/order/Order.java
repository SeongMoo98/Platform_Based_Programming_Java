package com.cafe.order;

import com.cafe.menu.*;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> items=new ArrayList<OrderItem>();

    public void add(OrderItem OI) {
        items.add(OI);
    }

    public int cost(){
        int sum=0;
        for(OrderItem OI : items){
            sum+=OI.beverage.getBasePrice()*OI.quantity;
        }
        return sum;
    }

    public void print(){
        for(OrderItem OI : items){
            System.out.println(OI);
        }
        System.out.printf("Total: %,d%n",cost());
    }

    public boolean setSize(String name, String size){
        for(OrderItem OI : items){
            if(OI.getBeverage().getName().equals(name)) {
                return OI.getBeverage().setSize(size);
            }
        }
        return false;
    }





}
