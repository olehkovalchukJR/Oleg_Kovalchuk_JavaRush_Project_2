package ru.javarush.oleg_kovalchuk.project2.island;

import ru.javarush.oleg_kovalchuk.project2.game_characters.Herb;
import ru.javarush.oleg_kovalchuk.project2.game_characters.HerbivorousAnimal;
import ru.javarush.oleg_kovalchuk.project2.game_characters.CarnivoreAnimal;
import ru.javarush.oleg_kovalchuk.project2.main.Statistic;

import java.util.List;
import java.util.Random;


public class Island{
    private final List<String> directions = List.of("UP", "DOWN", "RIGHT", "LEFT");


    Field field = new Field();
    Statistic statistic = new Statistic();

    public Island(){
        fillPlants();
//        fillCarnivoreAnimals();
//        fillHerbivorous();
        addAnimal();
    }

//    Herb herb = new Herb("Animals.Plants","\uD83C\uDF34",1, 200);
    public List<Herb> herbs = List.of(new Herb("Herb","\uD83C\uDF34",1, 200));
    public List<CarnivoreAnimal> carnivoreAnimals = List.of(
            new CarnivoreAnimal("Wolf", "\uD83D\uDC3A", 50,30,3,8),
            new CarnivoreAnimal("Boa", "\uD83D\uDC0D", 15,30,1,3),
            new CarnivoreAnimal("Fox", "\uD83E\uDD8A", 8,30,2,2),
            new CarnivoreAnimal("Bear", "\uD83D\uDC3B", 500,5,2,80),
            new CarnivoreAnimal("Wolf", "\uD83D\uDC3A", 6,20,3,1));

    public List<HerbivorousAnimal> herbivorousAnimals = List.of(
            new HerbivorousAnimal("Horse", "\uD83D\uDC0E",
                    400,20,4,60),
            new HerbivorousAnimal("Deer", "\uD83E\uDD8C",
                300,20,4,50),
            new HerbivorousAnimal("Rabbit", "\uD83D\uDC07",
                2,150,2,0.45),
            new HerbivorousAnimal("Mouse", "\uD83D\uDC01",
                0.05,500,1,0.01),
            new HerbivorousAnimal("Goat", "\uD83D\uDC0E",
                60,	140,	3, 10),
            new HerbivorousAnimal("Sheep", "\uD83D\uDC11",
                70,	140,	3,	15),
            new HerbivorousAnimal("Boar", "\uD83D\uDC17",
                400,	50,	2,	50),
            new HerbivorousAnimal("Buffalo", "\uD83D\uDC03",
                700,	10,	3,	100),
            new HerbivorousAnimal("Duck", "\uD83E\uDD86",
                1,	200,	4,	0.15),
            new HerbivorousAnimal("Caterpillar", "\uD83D\uDC1B",
                0.01,	1000,	0,	0));


    public void fillCarnivoreAnimals(){
        for (int i = 0; i < carnivoreAnimals.size(); i++) {
            for (int j = 0; j < field.getSizeX(); j++) {
                field.setAnimalOnField(new Random().nextInt(field.getSizeX()),new Random().nextInt(field.getSizeY()), carnivoreAnimals.get(i));
            }
        }
    }
    public void fillHerbivorous(){
        for (int i = 0; i < herbivorousAnimals.size(); i++) {
            for (int j = 0; j < field.getSizeX(); j++) {
                field.setAnimalOnField(new Random().nextInt(field.getSizeX()),new Random().nextInt(field.getSizeY()), herbivorousAnimals.get(i));
            }
        }
    }

    public void fillPlants(){
        for (int i = 0; i < field.getSizeX(); i++) {
            for (int j = 0; j < field.getSizeY(); j++) {
                field.setAnimalOnField(i,j,herbs.get(0));
            }
        }
    }
    public void printIsland(){
        field.printField();
    }

    private String randomDirection(){
        Random random = new Random();
        return directions.get(random.nextInt(4));
    }

    public void addAnimal(){
        field.setAnimalOnField(0,0, herbivorousAnimals.get(2));

    }
    public void moveAnimal(){
        for (int i = 0; i < herbivorousAnimals.size(); i++) {
            int distance = (int) (Math.random() * herbivorousAnimals.get(i).getTravelSpeed()) + 1;
            field.move(herbivorousAnimals.get(i),randomDirection(),distance);
        }
        for (int i = 0; i < carnivoreAnimals.size(); i++) {
            int distance = (int) (Math.random() * herbivorousAnimals.get(i).getTravelSpeed()) + 1;
            field.move(carnivoreAnimals.get(i),randomDirection(),distance);
        }
    }

    public void removeOneElement(){
        field.deleteAnimalOnField(1,1,0);
    }

    public void printStatistic(){
        for (int i = 0; i < field.getSizeX(); i++) {
            for (int j = 0; j < field.getSizeY(); j++) {
                statistic.currentAmount(i,j, herbs.get(0));
            }
        }
//        statistic.currentAmount(0,0, herb);
    }

    public void eatHerbs(){
        for (int i = 0; i < field.getSizeX(); i++) {
            for (int j = 0; j < field.getSizeY(); j++) {
                herbivorousAnimals.get(2).eat(i,j,herbs.get(0));
            }
        }
    }
}
