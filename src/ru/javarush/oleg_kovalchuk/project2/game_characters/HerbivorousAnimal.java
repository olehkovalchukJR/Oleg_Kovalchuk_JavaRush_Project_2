package ru.javarush.oleg_kovalchuk.project2.game_characters;

/*
        Травоядный
 */

import ru.javarush.oleg_kovalchuk.project2.island.Field;

import java.util.List;

public class HerbivorousAnimal extends Animal {

    public HerbivorousAnimal(String name, String icon, double weight,
                             int maxAnimals, int travelSpeed, double maxFullness) {
        super(name, icon, weight, maxAnimals, travelSpeed, maxFullness);
    }

    @Override
    public void eat(List<BasicItem>[][] field, int i, int j, BasicItem herb) {
        for (int k = 0; k < field[i][j].size(); k++) {
            if (field[i][j].get(k).getName().equals(herb.getName())){
                field[i][j].get(k).setAmount(field[i][j].get(k).getAmount() - 5);
            }
        }
    }

}