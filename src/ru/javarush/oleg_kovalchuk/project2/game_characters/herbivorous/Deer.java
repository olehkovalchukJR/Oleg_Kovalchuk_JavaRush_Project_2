package ru.javarush.oleg_kovalchuk.project2.game_characters.herbivorous;

import ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts.Herbivorous;

public class Deer extends Herbivorous {
    public Deer(String icon, double weight, int maxPersonages, int travelSpeed, double maxFullness) {
        super(icon, weight, maxPersonages, travelSpeed, maxFullness);
    }

}
