package com.example.olioprojekti;

public class Neon extends Lutemon {
    public Neon(String name, int id) {
        this.name = name;
        this.type = "neon";
        this.attack = 6;
        this.defence = 3;
        this.experience = 0;
        this.health = 19;
        this.maxHealth = 19;
        this.id = id;
        this.location = "home";
        Lutemon.incrementNumberOfCreatedLutemons();
    }
}
