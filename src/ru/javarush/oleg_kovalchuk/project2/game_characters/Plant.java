package ru.javarush.oleg_kovalchuk.project2.game_characters;

public abstract class Plant extends BasicItem{
    public Plant(String name, String icon, double weight, int maximumAmount) {
        super(name, icon, weight, maximumAmount);
        super.setAmount(maximumAmount);
    }

}
