package com.example.rpgjavafx;

import java.util.Scanner;

public class Game2 {
    int NB_COMBATS = 4;
    int diedHeroes = 4;
    Scanner sc = new Scanner(System.in);
    // Constante pour le nombre maximum de héros
    public static final int MAX_HEROES = 5;

    // Attributs pour stocker les informations sur la partie
    private final Hero[] heroes;
    private final Enemy[] enemies;
    private int roundsCompleted;

    // Constructeur pour initialiser une nouvelle partie
    public Game2(int numHeroes) {
        heroes = new Hero[numHeroes];
        enemies = new Enemy[4]; // 4 ennemis par combat
        this.roundsCompleted = 0;
    }

    // Méthode pour ajouter un héros à la partie
    public void addHero(Hero hero) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i] == null) {
                heroes[i] = hero;
                break;
            }
        }
    }

    // Méthode pour afficher les informations sur les héros
    public void showHeroes() {
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }

    // Méthode pour afficher les informations sur les ennemis
    public void showEnemies() {
        for (Enemy enemy : enemies) {
            System.out.println(enemy);
        }
    }

    public void addEnemy(Enemy enemy) {
        for (int i = 0; i < enemies.length; i++) {
            if (enemies[i] == null) {
                enemies[i] = enemy;
                break;

            }
        }
    }


    //interaction pour améliorer ses stats à la fin du tour
    public void upgrade() {
        int choix;
        for (int i = 0; i < this.heroes.length; i++) {
            System.out.println("Faites votre choix : 1 pour gagner des HP, 2 pour gagner des points d'attaque, 3 pour avoir une potion," +
                    "4 pour avoir des fleches, 5 pour gagner du mana");
            choix = sc.nextInt();
            switch (choix) {
                case 1:
                    heroes[i].setHP(heroes[i].getHP() + 10);
                    break;
                case 3:
                    heroes[i].addPotion();
                    break;
                case 2:
                    heroes[i].setATK((heroes[i].getATK() + 10));
                    break;
                case 4:
                    if (heroes[i].getName() == "hunter") {
                        Hunter hunter = (Hunter) heroes[i];
                        hunter.setArrow(hunter.getArrow() + 5);
                    }
                    if (heroes[i].getName() == "Mage" || heroes[i].getName() == "Healer") {
                        Spellcaster spellcaster = (Spellcaster) heroes[i];
                        spellcaster.setmana((spellcaster.getmana() + 20));
                    } else {
                        System.out.println("Un Guerrier se bat en première ligne ! ");
                    }
                    break;
                default:
                    System.out.println("les récompenses se dissipent...");
                    break;
            }
        }
    }
    // Méthode principale pour lancer la partie

    public static void main(String[] args) {
        // Créer une nouvelle partie avec 4 héros
        Game2 game = new Game2(4);
    }

    public void start() {
        // Ajouter des héros à la partie
        this.addHero(new Warrior("Aragorn"));
        this.addHero(new Mage("Gandalf"));
        this.addHero(new Hunter("Legolas"));
        this.addHero(new Healer("Arwen"));
        // ajouter des ennemis à la partie
        this.addEnemy(new Enemy("Ogre"));
        this.addEnemy(new Enemy("Ogre"));
        this.addEnemy(new Enemy("Ogre"));
        this.addEnemy(new Enemy("Ogre"));

        // Afficher les informations sur les ennemis
        while (roundsCompleted <= NB_COMBATS) {
            while (enemies[roundsCompleted].HP > 0) {

                //Afficher l'ennemi
                System.out.println(enemies[roundsCompleted].getStats());

                // Afficher les heros
                for (int i = 0; i < heroes.length; i++) {
                    System.out.println(heroes[i].getStats());
                }

                //choisir l'attaque
                int choixAttaque;
                System.out.println("Avec quel héro souhaitez-vous attaquer ?");
                choixAttaque = sc.nextInt();
                if (choixAttaque > heroes.length || heroes[choixAttaque].HP < 0) {
                    System.out.println("Il n'y a pas assez de héros ou votre héros est mort !");
                    continue;
                }
                Hero hero = heroes[choixAttaque];
                int i = (int) Math.random() * enemies.length;
                Enemy enemy = enemies[i];

                // Demande à l'utilisateur s'il souhaite attaquer ou non
                System.out.println("Voulez-vous attaquer ? (y/n)");
                sc.nextLine();

                String choix =sc.next();

                // Si l'utilisateur souhaite attaquer, effectue l'attaque en utilisant un switch pour déterminer quel type d'attaque effectuer
                if (choix.equalsIgnoreCase("y")) {
                    switch (hero.getName()) {
                        case "Aragorn":
                            enemy.HP -= hero.ATK;
                            break;
                        case "Gandalf":
                            enemy.HP -= hero.ATK;
                            break;
                        case "Legolas":
                            enemy.HP -= hero.ATK;
                            break;

                        case "Arwen":
                            enemy.HP += hero.ATK;
                            break;
                    }
                }

                // Attaque des ennemis
                for (Enemy enemie : enemies) {
                    enemy.attack(hero);
                }


                // Vérifie si l'ennemi est mort
                if (enemies[roundsCompleted].HP <= 0) {
                    System.out.println("L'ennemi est mort !");
                }

                // Vérifie si le héros est mort
                if (hero.HP <= 0) {
                    System.out.println("Le héros est mort !");
                }
            }
        }
    }

    //Création du Boss
    private void playboss() {

        this.addboss(new Boss("Smaug"));
    }

    private void addboss(Boss Boss) {

    }

}


