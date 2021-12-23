package com.cafe.menu;

public class Teavana extends Beverage{
    private int amount;
    public Teavana(String name) { super(name, 4100, TALL ); }

    @Override
    public boolean setSize(int size) {
        if (size!=GRANDE) {
            if(size == VENTI){
                super.setPrice(5100);
            }
            super.setSize(size);
            return true;
        }
        return false;
    }
    @Override
    public boolean equals(Object otherTeavana){
        if(otherTeavana instanceof Teavana) return false;
        Teavana r=(Teavana) otherTeavana;
        return name.equals(r.getName());
    }


}
