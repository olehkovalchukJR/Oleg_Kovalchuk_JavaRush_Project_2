package ru.javarush.oleg_kovalchuk.project2.game_characters.service;

import ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts.BasicItem;
import ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts.Plant;
import ru.javarush.oleg_kovalchuk.project2.island.Field;

import java.util.List;

public class PersonageFilling {

    public void fillPlants(List<BasicItem>[][] field, Plant plant){
        for (int i = 0; i <field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                for (int k = 0; k < 200; k++) {
                    field[i][j].add(plant);
                }
            }
        }
    }
    public void fillHerbivores(List<BasicItem>[][] field, BasicItem herbivorous){
        field[0][0].add(herbivorous);

    }
}
