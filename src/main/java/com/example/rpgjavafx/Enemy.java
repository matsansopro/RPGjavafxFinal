package com.example.rpgjavafx;

class Enemy extends Combattant {
    public Enemy(String name) {
        super(60, 50, 20);

    }
    public void attack(Hero hero){
        hero.takeDamage(this.ATK);

    }
    public void takeDamage(int damage){
        this.HP-= damage;
    }
    public String getStats(){
        return this.name + this.HP + this.ATK + this.defense;
    }
}


