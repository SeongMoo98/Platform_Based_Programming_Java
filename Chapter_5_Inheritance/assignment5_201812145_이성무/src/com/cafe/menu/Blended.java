package com.cafe.menu;

public class Blended extends Beverage{
    private int baseAmount;
    public Blended(String name) {
        super(name, 6800, GRANDE);
    }

    @Override
    public boolean setSize(int size) {
        if(size == GRANDE) {
            super.setSize(size);
            return true;
        }
        return false;
    }
    @Override
    public boolean equals(Object otherBlended){
        if(otherBlended instanceof Blended) return false;
        Blended r=(Blended) otherBlended;
        return name.equals(r.getName());
    }

}
