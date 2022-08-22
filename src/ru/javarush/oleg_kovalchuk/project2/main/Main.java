package ru.javarush.oleg_kovalchuk.project2.main;
import ru.javarush.oleg_kovalchuk.project2.island.Island;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        Island island = new Island();
        island.printIsland();
        island.printStatistic();

        while (!exit){
            island.moveAnimal();
//            island.eatHerbs();
            island.printIsland();
            island.printStatistic();

            int stop = scanner.nextInt();
            if (stop == 0){
                exit = true;
            }
        }
    }
}
