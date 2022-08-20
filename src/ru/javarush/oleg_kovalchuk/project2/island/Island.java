package ru.javarush.oleg_kovalchuk.project2.island;

import ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts.BasicItem;
import ru.javarush.oleg_kovalchuk.project2.game_characters.herbivorous.*;
import ru.javarush.oleg_kovalchuk.project2.game_characters.plants.Herb;
import ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts.HerbivorousAnimal;
import ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts.CarnivoreAnimal;
import ru.javarush.oleg_kovalchuk.project2.game_characters.service.PersonageFilling;
import ru.javarush.oleg_kovalchuk.project2.main.Statistic;

import java.util.List;
import java.util.Random;


public class Island{
    private final List<String> directions = List.of("UP", "DOWN", "RIGHT", "LEFT");


    Field field = new Field();
    PersonageFilling personageFilling = new PersonageFilling();
    Statistic statistic = new Statistic();

    public Island(){
        personageFilling.fillPlants(field.getField(), herbs.get(0));
        personageFilling.fillHerbivores(field.getField(),herbivorousAnimals.get(0));
//        fillCarnivoreAnimals();
//        fillHerbivorous();
//        addAnimal();
    }
    Horse horse = new Horse("\uD83D\uDC0E",400,20,4,60);

    public List<Herb> herbs = List.of(new Herb("\uD83C\uDF34",1, 200));
//    public List<CarnivoreAnimal> carnivoreAnimals = List.of(
//            new CarnivoreAnimal("Wolf", "\uD83D\uDC3A", 50,30,3,8),
//            new CarnivoreAnimal("Boa", "\uD83D\uDC0D", 15,30,1,3),
//            new CarnivoreAnimal("Fox", "\uD83E\uDD8A", 8,30,2,2),
//            new CarnivoreAnimal("Bear", "\uD83D\uDC3B", 500,5,2,80),
//            new CarnivoreAnimal("Eagle", "\uD83D\uDC3A", 6,20,3,1));

    public List<HerbivorousAnimal> herbivorousAnimals = List.of(
            new Horse("\uD83D\uDC0E",400,20,4,60));
//            new Deer("\uD83E\uDD8C", 300,20,4,50),
//            new Rabbit("\uD83D\uDC07", 2,150,2,0.45),
//            new Mouse("\uD83D\uDC01", 0.05,500,1,0.01),
//            new Goat("\uD83D\uDC0E", 60,	140,	3, 10),
//            new Sheep("\uD83D\uDC11", 70,	140,	3,	15),
//            new Boar("\uD83D\uDC17", 400,	50,	2,	50),
//            new Buffalo("\uD83D\uDC03", 700,	10,	3,	100),
//            new Duck("\uD83E\uDD86", 1,	200,	4,	0.15),
//            new Caterpillar("\uD83D\uDC1B", 0.01,	1000,	0,	0));


    public void printIsland(){
        field.printField();
    }

    private String randomDirection(){
        Random random = new Random();
        return directions.get(random.nextInt(4));
    }

    public void moveAnimal(){
        horse.move(field.getField(),randomDirection());
    }

    public void removeOneElement(){
        field.deleteAnimalOnField(1,1,0);
    }

    public void printStatistic(){
        statistic.currentAnimalAmount(field.getField(), herbs.get(0));
        statistic.currentAnimalAmount(field.getField(), horse);
    }

    public void eatHerbs(){
        for (int i = 0; i < field.getSizeX(); i++) {
            for (int j = 0; j < field.getSizeY(); j++) {
                    if (field.getField()[i][j].contains(herbivorousAnimals.get(0))){
                        herbivorousAnimals.get(0).eat(field.getField()[i][j],herbs.get(0));
                }
            }
        }
//        field.getField()[9][9].remove(herbs.get(0));
    }
}
