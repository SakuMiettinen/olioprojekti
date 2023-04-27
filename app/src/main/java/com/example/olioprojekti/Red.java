package com.example.olioprojekti;

public class Red extends Lutemon {
    public Red(String name, int id) {
        this.name = name;
        this.type = "punainen";
        this.attack = 5;
        this.defence = 4;
        this.experience = 0;
        this.health = 20;
        this.maxHealth = 20;
        this.id = id;
        this.location = "home";
        Lutemon.incrementNumberOfCreatedLutemons();
    }
}
