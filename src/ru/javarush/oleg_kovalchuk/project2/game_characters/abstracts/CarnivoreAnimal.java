package ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts;

/*
        Хищник
 */


import ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts.Animal;
import ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts.BasicItem;

import java.util.List;

public abstract class CarnivoreAnimal extends Animal {
    public CarnivoreAnimal(String icon, double weight, int maxPersonages, int travelSpeed, double maxFullness) {
        super(icon, weight, maxPersonages, travelSpeed, maxFullness);
    }

    @Override
    public void eat(List<BasicItem> field, BasicItem prey) {

    }
}