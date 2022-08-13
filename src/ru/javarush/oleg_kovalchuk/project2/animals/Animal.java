package ru.javarush.oleg_kovalchuk.project2.animals;

public abstract class Animal {
    private String name;
    private String icon;
    private int amount;
    private double weight;
    private int maxAnimals;
    private int travelSpeed;
    private double maxFullness;

    public Animal(String name, String icon, int amount, double weight,
                  int maxAnimals, int travelSpeed, double maxFullness) {
        this.name = name;
        this.icon = icon;
        this.amount = amount;
        this.weight = weight;
        this.maxAnimals = maxAnimals;
        this.travelSpeed = travelSpeed;
        this.maxFullness = maxFullness;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return getIcon();
    }
}
