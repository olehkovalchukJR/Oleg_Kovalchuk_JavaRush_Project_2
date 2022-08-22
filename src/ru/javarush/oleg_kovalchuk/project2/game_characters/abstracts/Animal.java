package ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts;

import ru.javarush.oleg_kovalchuk.project2.interfaces.Eateble;
import ru.javarush.oleg_kovalchuk.project2.interfaces.Movable;
import ru.javarush.oleg_kovalchuk.project2.interfaces.Randomable;

public abstract class Animal extends Personage implements Eateble, Movable, Randomable {
    private final int travelSpeed;
    private double currentFullness;
    private double amountToMAxFullness;
    private final double maxFullness;
    private boolean isHungry;
    private boolean isBreed;
    private boolean isAlive;

    public Animal(String icon, double weight, int maxPersonages, int travelSpeed, double maxFullness) {
        super(icon, weight, maxPersonages);
        this.travelSpeed = travelSpeed;
        this.maxFullness = maxFullness;
        this.currentFullness = maxFullness;
        this.amountToMAxFullness = maxFullness - currentFullness;
        isBreed = false;
        isAlive = true;
        isHungry = true;
    }

    public int getTravelSpeed() {
        return travelSpeed;
    }

    public double getCurrentFullness() {
        return currentFullness;
    }

    public void setCurrentFullness(double currentFullness) {
        this.currentFullness = currentFullness;
    }

    public double getAmountToMAxFullness() {
        return amountToMAxFullness;
    }

    public void setAmountToMAxFullness(double amountToMAxFullness) {
        this.amountToMAxFullness = amountToMAxFullness;
    }

    public double getMaxFullness() {
        return maxFullness;
    }

    public boolean isBreed() {
        return isBreed;
    }

    public void setBreed(boolean breed) {
        isBreed = breed;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }
}
