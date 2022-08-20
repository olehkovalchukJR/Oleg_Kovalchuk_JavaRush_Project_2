package ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts;

import ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts.BasicItem;

public abstract class Plant extends BasicItem {
    public Plant(String icon, double weight, int maxPersonages) {
        super(icon, weight, maxPersonages);
    }
}
