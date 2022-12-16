package com.example.rpgjavafx;


public class Hunter extends Hero {

    private int arrow = 20;

    public Hunter(String name) {
        super(80, 90, 50);
        this.name = name;

    }
    protected int getArrow(){

        return this.arrow;
    }
    protected void setArrow(int arrow){

        this.arrow = arrow;
    }

}