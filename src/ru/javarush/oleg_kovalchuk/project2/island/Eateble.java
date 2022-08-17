package ru.javarush.oleg_kovalchuk.project2.island;

import ru.javarush.oleg_kovalchuk.project2.game_characters.BasicItem;

import java.util.List;

public interface Eateble {
    public void eat(List<BasicItem>[][] field, int i,int j , BasicItem herb);
}
