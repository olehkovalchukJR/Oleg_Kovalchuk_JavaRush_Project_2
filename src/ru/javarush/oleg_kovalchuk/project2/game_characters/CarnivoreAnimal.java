package ru.javarush.oleg_kovalchuk.project2.game_characters;

/*
        Хищник
 */


import java.util.List;

public class CarnivoreAnimal extends Animal{

    public CarnivoreAnimal(String name, String icon, double weight,
                           int maxAnimals, int travelSpeed, double maxFullness) {
        super(name, icon, weight, maxAnimals, travelSpeed, maxFullness);
    }

    @Override
    public void eat(List<BasicItem>[][] field, int i, int j, BasicItem herb) {

    }
}