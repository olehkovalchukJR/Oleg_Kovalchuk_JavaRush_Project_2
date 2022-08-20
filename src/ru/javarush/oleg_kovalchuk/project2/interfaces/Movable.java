package ru.javarush.oleg_kovalchuk.project2.interfaces;

import ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts.Animal;
import ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts.BasicItem;

import java.util.List;

public interface Movable {
    public void move(List<BasicItem>[][] list, String direction);
}
