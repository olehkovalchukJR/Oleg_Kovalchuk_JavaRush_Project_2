package ru.javarush.oleg_kovalchuk.project2.main;

import ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts.Animal;
import ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts.Personage;
import ru.javarush.oleg_kovalchuk.project2.game_characters.service.PersonageFilling;

import java.util.List;

/*
        Задача - сбор статистики

        Каждый ход собирается статистика:

    - сколько животных осталось на текущий момент
    - сколько животных умерло от голода/были съедены
    - сколько родилось новых животных
    - разница между первым ходом и текущим по кол-ву животных
    - тип животного которое чаще всего делает N-дейсвтие

    Сбор статистики идет для всех животных + трава
 */

public class Statistic{

    public void currentAnimalAmount(List<Personage>[][] field, Personage character){
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                String icon = character.getIcon();
                String name = character.getName();
                int amount = (int) field[i][j].stream()
                        .filter(o -> o.getName().equals(character.getName()))
                        .count();
                if (amount > 0) {
                    System.out.println(icon + " " + name + ", amount " + amount + ", position: (X " + i + ") (X " + j + ")");
                }
            }
        }
    }
}
