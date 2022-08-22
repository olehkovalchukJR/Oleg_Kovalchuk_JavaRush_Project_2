package ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts;

/*
        Хищник
 */


import java.util.List;

public abstract class CarnivoreAnimal extends Animal {
    public CarnivoreAnimal(String icon, double weight, int maxPersonages, int travelSpeed, double maxFullness) {
        super(icon, weight, maxPersonages, travelSpeed, maxFullness);
    }

    @Override
    public void eat(List<Personage>[][] field, Personage prey) {

    }

    @Override
    public void getHungry(Animal animal) {

    }

    @Override
    public void move(List<Personage>[][] list, String direction) {

    }
}