package ru.javarush.oleg_kovalchuk.project2.animals;

/*
        Хищник
 */

public class Predator extends Animal implements Fieldable{

    public Predator(String name, String icon, int amount, double weight,
                    int maxAnimals, int travelSpeed, double maxFullness) {
        super(name, icon, amount, weight, maxAnimals, travelSpeed, maxFullness);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}