package ru.javarush.oleg_kovalchuk.project2.interfaces;

import ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts.Personage;

import java.util.List;

public interface Movable {
    public void move(List<Personage>[][] list, String direction);
}
