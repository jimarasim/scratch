package com.company;

public abstract class Creature {
    public abstract String color();
    public abstract double lengthInFeet();
    public abstract double widthInFeet();
    public abstract String texture();

    public String breathe(){
        return "breath noise";
    }
}
