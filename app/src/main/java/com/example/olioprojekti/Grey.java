package com.example.olioprojekti;

public class Grey extends Lutemon {
    public Grey(String name, int id) {
        this.name = name;
        this.type = "harmaa";
        this.attack = 7;
        this.defence = 2;
        this.experience = 0;
        this.health = 18;
        this.maxHealth = 18;
        this.id = id;
        this.location = "home";
        Lutemon.incrementNumberOfCreatedLutemons();
    }
}
