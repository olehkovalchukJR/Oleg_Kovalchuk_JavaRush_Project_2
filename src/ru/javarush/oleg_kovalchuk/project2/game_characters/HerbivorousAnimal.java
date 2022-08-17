package ru.javarush.oleg_kovalchuk.project2.game_characters;

/*
        Травоядный
 */

import ru.javarush.oleg_kovalchuk.project2.island.Field;

public class HerbivorousAnimal extends Animal {
    Field field = new Field();

    public HerbivorousAnimal(String name, String icon, double weight,
                             int maxAnimals, int travelSpeed, double maxFullness) {
        super(name, icon, weight, maxAnimals, travelSpeed, maxFullness);
    }

    @Override
    public void eat(int x, int y,BasicItem herb) {

        if (herb instanceof Plant){
            if (herb.getAmount() > 0){
                herb.setAmount(herb.getAmount() - 5);
            }
        }
    }

}