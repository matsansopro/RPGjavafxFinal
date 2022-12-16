package com.example.rpgjavafx;

abstract class Spellcaster extends Hero {
    private int mana;

    public Spellcaster(int HP, int ATK, int defense, int mana) {
        super(HP, ATK, defense);
        this.mana = mana;

    }
    public int getmana() {
        return mana;
    }
    public int setmana(int mana) {
        this.mana = mana;

        return mana;
    }

    public void usePotion(Potion potion) {
        switch(potion.type){
            case "mana":
                this.mana += potion.potionvalue;
                break;
            case "health":
                this.HP += potion.potionvalue;
                break;
        }
        this.inventory.remove(potion);
    }
}



