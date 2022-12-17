package com.example.rpgjavafx;

class Enemy extends Combattant {
    public Enemy(String name) {
        super(60, 50, 20);

    }

    public void attack(Hero hero) {
        hero.takeDamage(this.ATK);

    }

    public void takeDamage(int damage) {
        this.HP -= damage;
    }

    public String getStats() {
        String stats = this.name + Integer.toString(this.HP) + Integer.toString(this.ATK) + Integer.toString(this.defense);
        return stats;
    }
}

