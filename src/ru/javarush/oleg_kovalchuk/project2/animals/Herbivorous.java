package ru.javarush.oleg_kovalchuk.project2.animals;

/*
        Травоядный
 */

public class Herbivorous extends Animal implements Fieldable {

    public Herbivorous(String name, String icon, double weight,
                       int maxAnimals, int travelSpeed, double maxFullness) {
        super(name, icon, weight, maxAnimals, travelSpeed, maxFullness);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getAmount() {
        return super.getAmount();
    }

    @Override
    public int getTravelSpeed() {
        return super.getTravelSpeed();
    }
}

