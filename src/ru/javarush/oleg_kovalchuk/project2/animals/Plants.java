package ru.javarush.oleg_kovalchuk.project2.animals;

public class Plants extends Animal implements Fieldable{

    public Plants(String name, String icon, double weight,
                  int maxAnimals, int travelSpeed, double maxFullness) {
        super(name, icon, weight, maxAnimals, travelSpeed, maxFullness);
        super.setAmount(maxAnimals);
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
    public String toString() {
        return super.toString();
    }

}
