package ru.javarush.oleg_kovalchuk.project2.game_characters.herbivorous;

import ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts.Herbivorous;

import java.util.Map;

public class Boar extends Herbivorous {
    public Boar(String icon, double weight, int maxPersonages, int travelSpeed, double maxFullness) {
        super(icon, weight, maxPersonages, travelSpeed, maxFullness);
        getPercentPossibleToEatPrey().put("Herb",100);
        getPercentPossibleToEatPrey().put("Caterpillar",90);
        getPercentPossibleToEatPrey().put("Mouse",50);
    }

}
