package ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts;

public abstract class Personage {
    private String icon;
    private double weight;
    private int maxPersonages;

    public Personage(String icon, double weight, int maxPersonages) {
        this.icon = icon;
        this.weight = weight;
        this.maxPersonages = maxPersonages;
    }

    public String getIcon() {
        return icon;
    }
    public double getWeight() {
        return weight;
    }

    public int getMaxPersonages() {
        return maxPersonages;
    }

    public String getName(){
        return this.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return getIcon();
    }
}
