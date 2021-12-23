package com.cafe.menu;

public class Coffee extends Beverage {
    private int defaultShot;
    public Coffee(String name) {
        super(name, 4100, TALL);
    }

    @Override
    public boolean setSize(int size) {
        if(size == GRANDE){
            super.setPrice(4600);
        }
        else if(size==VENTI){
            super.setPrice(5100);
        }
        super.setSize(size);
        return true;
    }
    @Override
    public boolean equals(Object otherCoffee) {
        if (otherCoffee instanceof Coffee) return false;
        Coffee r = (Coffee) otherCoffee;
        return name.equals(r.getName());
    }


}
