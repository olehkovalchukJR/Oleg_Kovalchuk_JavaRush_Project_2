package ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts;

/*
        Хищник
 */


import java.util.List;

public abstract class Carnivore extends Animal {
    public Carnivore(String icon, double weight, int maxPersonages, int travelSpeed, double maxFullness) {
        super(icon, weight, maxPersonages, travelSpeed, maxFullness);
    }

    @Override
    public void eat(List<Personage>[][] field) {

    }


    @Override
    public void move(List<Personage>[][] list, String direction) {

    }
}