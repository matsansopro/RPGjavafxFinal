package com.example.rpgjavafx;

import java.util.*;

abstract class Hero extends Combattant {

    ArrayList<String> inventory = new ArrayList<>();
    // Créer un dictionnaire pour stocker les quantités des objets dans l'inventaire
    HashMap<String, Integer> quantities = new HashMap<>();

    public Hero(int HP, int ATK, int defense) {
        super(HP, ATK, defense);
        // Créer un objet Scanner pour lire les entrées utilisateur
        Scanner scanner = new Scanner(System.in);

        // Ajouter quelques objets à l'inventaire
        inventory.add("Sword");
        inventory.add("Shield");
        inventory.add("Heal potion");
        inventory.add("Mana potion");

        // Définir les quantités pour chaque objet dans l'inventaire
        quantities.put("Sword", 1);
        quantities.put("Shield", 1);
        quantities.put("Heal potion", 1);
        quantities.put("Mana potion", 1);

    }

    private boolean isObjectInInventory(String itemToUse) {
        // Vérifier si l'objet est dans l'inventaire
        if (inventory.contains(itemToUse)) {
            // Récupérer la quantité de l'objet dans l'inventaire
            int quantity = quantities.get(itemToUse);

            // Vérifier s'il reste assez d'objets pour être utilisés
            if (quantity > 0) {
                // Décrémenter la quantité de l'objet
                quantities.put(itemToUse, quantity - 1);

                // Afficher un message pour indiquer que l'objet a été utilisé
                System.out.println("Vous utilisez l'objet " + itemToUse);
                return true;
            } else {
                // Afficher un message d'erreur si l'objet est épuisé
                System.out.println("Vous n'avez plus d'objets " + itemToUse + " à utiliser.");
                return false;
            }
        } else {
            // Afficher un message d'erreur si l'objet n'est pas dans l'inventaire
            System.out.println("Vous n'avez pas d'objet " + itemToUse + " dans votre inventaire.");
            return false;
        }
    }

    private static String choixobjet(Scanner scanner) {
        // Demander à l'utilisateur de choisir un objet à utiliser
        System.out.println("Quel objet souhaitez-vous utiliser ? Entrez son nom.");
        String itemToUse = scanner.nextLine();
        return itemToUse;
    }

    private void afficherInventaire() {
        // Afficher l'inventaire
        System.out.println("Voici votre inventaire :");
        for (String item : inventory) {
            System.out.println(item + " (" + quantities.get(item) + ")");
        }
    }

    public void attack(Enemy enemy) {
        enemy.takeDamage(this.ATK);
    }

    public void takeDamage(int damage) {
        this.HP -= damage;
    }

    public void add(char objet) {


    }

    public String getName() {
        return this.name;
    }


    public void addPotion() {

    }

    public void usePotion(Potion potion) {
        this.HP += potion.potionvalue;
        this.inventory.remove(potion);
    }

    public String getStats(){
        String stats = this.name + this.HP + this.ATK + this.defense;
        return stats;
    }
}