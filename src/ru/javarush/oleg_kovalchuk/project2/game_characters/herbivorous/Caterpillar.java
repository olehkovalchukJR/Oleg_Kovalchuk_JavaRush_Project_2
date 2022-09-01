package ru.javarush.oleg_kovalchuk.project2.game_characters.herbivorous;

import ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts.Herbivorous;
import ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts.Personage;

import java.util.List;

public class Caterpillar extends Herbivorous {
    public Caterpillar(String icon, double weight, int maxPersonages, int travelSpeed, double maxFullness) {
        super(icon, weight, maxPersonages, travelSpeed, maxFullness);
    }

    @Override
    public void move(List<Personage>[][] field, String direction) {
    }

    @Override
    public void eat(List<Personage>[][] field) {

    }
}
