package ru.javarush.oleg_kovalchuk.project2.main;

import ru.javarush.oleg_kovalchuk.project2.island.Island;

public class Main {
    public static void main(String[] args) {
        Island island = new Island();
        island.fillPlants();
        island.addAnimal();
        island.printIsland();

        island.moveUp();
        island.printIsland();
    }
}
