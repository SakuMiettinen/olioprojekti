package com.example.olioprojekti;

public class Green extends Lutemon {
    public Green(String name, int id) {
        this.name = name;
        this.type = "vihreä";
        this.attack = 8;
        this.defence = 1;
        this.experience = 0;
        this.health = 17;
        this.maxHealth = 17;
        this.id = id;
        this.location = "home";
        Lutemon.incrementNumberOfCreatedLutemons();
    }
}
