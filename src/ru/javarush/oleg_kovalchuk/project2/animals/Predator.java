package ru.javarush.oleg_kovalchuk.project2.animals;

/*
        Хищник
 */

public class Predator extends Animal implements Fieldable{

    public Predator(String name, String icon, double weight,
                    int maxAnimals, int travelSpeed, double maxFullness) {
        super(name, icon, weight, maxAnimals, travelSpeed, maxFullness);
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
    public void setAmount(int amount) {
        super.setAmount(amount);
    }

    @Override
    public int getTravelSpeed() {
        return super.getTravelSpeed();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}