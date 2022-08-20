package ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts;

import ru.javarush.oleg_kovalchuk.project2.interfaces.Eateble;

public abstract class Animal extends BasicItem implements Eateble {
    private int travelSpeed;
    private double currentFullness;
    private double amountToMAxFullness;
    private double maxFullness;
    private boolean isBreed;
    private boolean isAlive;

    public Animal(String icon, double weight, int maxPersonages, int travelSpeed, double maxFullness) {
        super(icon, weight, maxPersonages);
        this.travelSpeed = travelSpeed;
        this.maxFullness = maxFullness;
        this.currentFullness = 0;
        this.amountToMAxFullness = 0;
        isBreed = false;
        isAlive = true;
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
}
