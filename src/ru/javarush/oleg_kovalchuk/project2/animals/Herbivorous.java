package ru.javarush.oleg_kovalchuk.project2.animals;

/*
        Травоядный
 */

public class Herbivorous extends Animal implements Fieldable {

    public Herbivorous(String name, String icon, int amount, double weight,
                       int maxAnimals, int travelSpeed, double maxFullness) {
        super(name, icon, amount, weight, maxAnimals, travelSpeed, maxFullness);
    }


    @Override
    public String toString() {
        return super.toString();
    }


}
