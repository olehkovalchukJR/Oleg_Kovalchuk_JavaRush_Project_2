package ru.javarush.oleg_kovalchuk.project2.game_characters.service;

import ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts.HerbivorousAnimal;
import ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts.Personage;
import ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts.Plant;
import ru.javarush.oleg_kovalchuk.project2.game_characters.herbivorous.Horse;
import ru.javarush.oleg_kovalchuk.project2.interfaces.Randomable;

import java.util.List;

public class PersonageFilling implements Randomable {

    public void fillPlants(List<Personage>[][] field, Plant plant){
        for (int i = 0; i <field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                for (int k = 0; k < 200; k++) {
                    field[i][j].add(plant);
                }
            }
        }
    }
    public void fillHerbivorous(List<Personage>[][] field, Personage herbivorous){
        field[0][0].add(herbivorous);
    }

    public void fillHerbivorous(List<Personage>[][] field, List<HerbivorousAnimal> herbivorous){
        for (int i = 0; i < herbivorous.size(); i++) {
            int amountAnimalsOnField = randomValue(1,herbivorous.get(0).getMaxPersonages());
            for (int j = 0; j < amountAnimalsOnField; j++) {
                int x = randomValue(0,field.length);
                int y = randomValue(0,field[x].length);
                for (int k = 0; k < randomValue(1,herbivorous.get(0).getMaxPersonages()); k++) {
                    int amount = (int) field[x][y].stream()
                            .filter(o -> o.getName().equals(herbivorous.get(0).getName()))
                            .count();
                    if (amount < herbivorous.get(0).getMaxPersonages()){
                        field[x][y].add(new Horse("\uD83D\uDC0E", 400, 20, 4, 60));
                    }
                }
            }
        }
    }


//    public void fillHorses(List<Personage>[][] field, List<HerbivorousAnimal> herbivorous){
//        if (herbivorous.get(0).getName().equals("Horse")){
//            int amountAnimalsOnField = randomValue(1,herbivorous.get(0).getMaxPersonages());
//            for (int i = 0; i < amountAnimalsOnField; i++) {
//                int x = randomValue(0,field.length);
//                int y = randomValue(0,field.length);
//                for (int j = 0; j < amountAnimalsOnField; j++) {
//                    field[x][y].add(new Horse("\uD83D\uDC0E",400,20,4,60));
//                }
//            }
//        }
//    }
}
