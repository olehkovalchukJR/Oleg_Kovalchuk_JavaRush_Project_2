package ru.javarush.oleg_kovalchuk.project2.game_characters;

public abstract class BasicItem {
    private String name;
    private String icon;
    private int amount;
    private int maximumAmount;
    private double weight;

    public BasicItem(String name, String icon, double weight, int maximumAmount) {
        this.name = name;
        this.icon = icon;
        this.weight = weight;
        this.maximumAmount = maximumAmount;
        this.amount = maximumAmount / 2;
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

    public int getMaximumAmount() {
        return maximumAmount;
    }

    @Override
    public String toString() {
        return getIcon();
    }
}
