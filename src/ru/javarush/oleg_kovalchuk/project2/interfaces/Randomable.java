package ru.javarush.oleg_kovalchuk.project2.interfaces;

public interface Randomable {
    default int randomValue(int minValue, int maxValue) {
        return (int) (Math.random() * maxValue) + minValue;
    }
    default int randomValue(int maxValue) {
        return (int) (Math.random() * maxValue);
    }
}
