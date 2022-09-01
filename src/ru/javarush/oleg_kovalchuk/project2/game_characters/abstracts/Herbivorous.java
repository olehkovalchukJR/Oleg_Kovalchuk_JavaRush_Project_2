package ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts;

/*
        Травоядный
 */


public abstract class Herbivorous extends Animal {
    public Herbivorous(String icon, double weight, int maxPersonages, int travelSpeed, double maxFullness) {
        super(icon, weight, maxPersonages, travelSpeed, maxFullness);
        getPercentPossibleToEatPrey().put("Herb",100);
    }

}