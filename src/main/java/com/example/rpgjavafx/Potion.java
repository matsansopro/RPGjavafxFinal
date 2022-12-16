package com.example.rpgjavafx;

public class Potion extends Consumable {
    int potionvalue;
    String type;
    Potion(int potionvalue, String type){
        this.potionvalue = potionvalue;
        this.type = type;
        //Type : mana or health
    }
}
