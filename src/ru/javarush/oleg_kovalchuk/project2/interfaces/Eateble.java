package ru.javarush.oleg_kovalchuk.project2.interfaces;

import ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts.Animal;
import ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts.Personage;

import java.util.List;

public interface Eateble {
    public final int MINUS_HUNGER_PERCENTAGE = 25;
    public void eat(List<Personage>[][] field);

}
