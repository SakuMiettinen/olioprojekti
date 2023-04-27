package com.example.olioprojekti;

public class Black extends Lutemon {
    public Black(String name, int id) {
        this.name = name;
        this.type = "musta";
        this.attack = 9;
        this.defence = 0;
        this.experience = 0;
        this.health = 16;
        this.maxHealth = 16;
        this.id = id;
        this.location = "home";
        Lutemon.incrementNumberOfCreatedLutemons();
    }
}
