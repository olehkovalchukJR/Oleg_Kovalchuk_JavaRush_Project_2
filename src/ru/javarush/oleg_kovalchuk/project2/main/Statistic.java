package ru.javarush.oleg_kovalchuk.project2.main;

import ru.javarush.oleg_kovalchuk.project2.game_characters.BasicItem;

public class Statistic{

    public void currentAmount(int x, int y, BasicItem animal){
        System.out.println("At position X = " + x + " and Y = " + y + " there are: "+
                animal.getAmount() + " units of " + animal.getName());

    }

}
