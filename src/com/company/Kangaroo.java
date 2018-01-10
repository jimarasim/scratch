package com.company;

public class Kangaroo extends Creature implements Animal {
    public int numberOfLegs(){
        return 2;
    }
    public String makeNoise(){
        return "chirp";
    }
    public String color(){
        return "brown";
    }
    public double lengthInFeet(){
        return 8;
    }
    public double widthInFeet(){
        return 3;
    }
    public String texture(){
        return "furry";
    }
}
