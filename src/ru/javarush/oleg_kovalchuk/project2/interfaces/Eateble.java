package ru.javarush.oleg_kovalchuk.project2.interfaces;

import ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts.BasicItem;

import java.util.List;

public interface Eateble {
    public void eat(List<BasicItem> field, BasicItem prey);
}
