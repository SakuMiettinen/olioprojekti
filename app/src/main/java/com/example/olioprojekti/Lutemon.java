package com.example.olioprojekti;

public class Lutemon {
    protected static int numberOfCreatedLutemons = 0;
    protected String name;
    protected String type;
    protected int attack;
    protected int defence;
    protected int experience;
    protected int health;
    protected int maxHealth;
    protected int id;
    protected String location;

    public void defend(int incomingDamage) {
        this.health -= incomingDamage;
    }

    public static void incrementNumberOfCreatedLutemons() {
        numberOfCreatedLutemons++;
    }

    public static int getNumberOfCreatedLutemons() {
        return numberOfCreatedLutemons;
    }

    public String getName() {
        return name;
    }
    public String getType() { return type; }

    public int getAttack() {
        return attack;
    }
    public int getDefence() {
        return defence;
    }
    public int getHealth() {
        return health;
    }
    public int getMaxHealth() {
        return maxHealth;
    }
    public int getExp() {
        return experience;
    }
    public String getLocation() {
        return location;
    }
    public int getLutemonId() {
        return id;
    }

    public void setLocation(String newLocation) {
        location = newLocation;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void incrementExp() {
        this.experience++;
    }

    public void setAttack(int newAttack) {
        this.attack = newAttack;
    }

    public void setDefence(int newDefence) {
        this.defence = newDefence;
    }

}
