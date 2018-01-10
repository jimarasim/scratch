package com.company;

public class Cat extends Creature implements Animal {
    public int numberOfLegs(){
        return 4;
    }
    public String makeNoise(){
        return "meow";
    }

    public String color(){
        return "gray";
    }
    public double lengthInFeet(){
        return 2;
    }
    public double widthInFeet(){
        return 0.5;
    }
    public String texture(){
        return "furry";
    }
}
