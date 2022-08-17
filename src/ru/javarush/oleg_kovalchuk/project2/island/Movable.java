package ru.javarush.oleg_kovalchuk.project2.island;

import ru.javarush.oleg_kovalchuk.project2.game_characters.Animal;

public interface Movable {
    public void move(Animal animal, String direction , int distance);
}
