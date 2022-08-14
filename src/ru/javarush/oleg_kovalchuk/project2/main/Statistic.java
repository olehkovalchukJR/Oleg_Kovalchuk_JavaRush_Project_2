package ru.javarush.oleg_kovalchuk.project2.main;

public class Statistic{

    public void currentAmount(int x, int y, String name, int amount){
        System.out.println("At position X = " + x + " and Y = " + y + " there are: "+
                amount + " units of " + name);

    }

}
