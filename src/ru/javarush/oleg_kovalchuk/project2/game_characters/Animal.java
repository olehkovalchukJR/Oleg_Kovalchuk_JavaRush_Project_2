package ru.javarush.oleg_kovalchuk.project2.game_characters;

import ru.javarush.oleg_kovalchuk.project2.island.Eateble;
import ru.javarush.oleg_kovalchuk.project2.island.Movable;

public abstract class Animal extends BasicItem implements Eateble {
    private int travelSpeed;
    private double maxFullness;



    public Animal(String name, String icon, double weight, int maximumAmount, int travelSpeed, double maxFullness) {
        super(name, icon, weight, maximumAmount);
        this.travelSpeed = travelSpeed;
        this.maxFullness = maxFullness;
    }

    public int getTravelSpeed() {
        return travelSpeed;
    }

    public double getMaxFullness() {
        return maxFullness;
    }

}
