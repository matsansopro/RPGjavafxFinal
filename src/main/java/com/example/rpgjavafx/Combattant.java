package com.example.rpgjavafx;

abstract class Combattant {
    protected int HP;
    protected int ATK;
    protected int defense;

    protected String name;

    private int nbpotion;
    private static int attack;

    public boolean get;

    public Combattant(int HP, int ATK, int defense) {
        this.HP = HP;
        this.ATK = ATK;
        this.defense = defense;

    }
    public int setATK(int ATK) {
        this.ATK = ATK;
        return ATK;
    }

    public int getATK() {
        return ATK;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }

    public int setHP(int HP) {
        this.HP = HP;
        return HP;
    }

    public int getHP() {
        return HP;
    }

    public int getNbpotion(){
        return nbpotion;
    }
    public void setNbpotion(int nbpotion){
        this.nbpotion=nbpotion;
    }

    protected void takeDamage(int atk) {
    }

}
