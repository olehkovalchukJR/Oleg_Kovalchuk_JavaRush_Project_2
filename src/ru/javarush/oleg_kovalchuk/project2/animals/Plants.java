package ru.javarush.oleg_kovalchuk.project2.animals;

public class Plants extends Animal implements Fieldable{

    public Plants(String name, String icon, int amount, double weight,
                  int maxAnimals, int travelSpeed, double maxFullness) {
        super(name, icon, amount, weight, maxAnimals, travelSpeed, maxFullness);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
