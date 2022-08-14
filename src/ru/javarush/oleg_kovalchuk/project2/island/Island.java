package ru.javarush.oleg_kovalchuk.project2.island;

import ru.javarush.oleg_kovalchuk.project2.animals.Herbivorous;
import ru.javarush.oleg_kovalchuk.project2.animals.Plants;
import ru.javarush.oleg_kovalchuk.project2.animals.Predator;
import ru.javarush.oleg_kovalchuk.project2.main.Statistic;

import java.util.List;
import java.util.Map;
import java.util.Random;


public class Island{
    private final List<String> directions = List.of("UP", "DOWN", "RIGHT", "LEFT");


    Field field = new Field();
    Statistic statistic = new Statistic();

    public Island(){
        fillPlants();
        fillPredators();
        fillHerbivorous();
//        addAnimal();
    }

    Plants plants = new Plants("Animals.Plants","\uD83C\uDF34",1,
            200,0,0);
    public List<Predator> predators = List.of(
            new Predator("Wolf", "\uD83D\uDC3A", 50,30,3,8),
            new Predator("Boa", "\uD83D\uDC0D", 15,30,1,3),
            new Predator("Fox", "\uD83E\uDD8A", 8,30,2,2),
            new Predator("Bear", "\uD83D\uDC3B", 500,5,2,80),
            new Predator("Wolf", "\uD83D\uDC3A", 6,20,3,1));

    public List<Herbivorous> herbivorous = List.of(
            new Herbivorous("Horse", "\uD83D\uDC0E",
                    400,20,4,60),
            new Herbivorous("Deer", "\uD83E\uDD8C",
                300,20,4,50),
            new Herbivorous("Rabbit", "\uD83D\uDC07",
                2,150,2,0.45),
            new Herbivorous("Mouse", "\uD83D\uDC01",
                0.05,500,1,0.01),
            new Herbivorous("Goat", "\uD83D\uDC0E",
                60,	140,	3, 10),
            new Herbivorous("Sheep", "\uD83D\uDC11",
                70,	140,	3,	15),
            new Herbivorous("Boar", "\uD83D\uDC17",
                400,	50,	2,	50),
            new Herbivorous("Buffalo", "\uD83D\uDC03",
                700,	10,	3,	100),
            new Herbivorous("Duck", "\uD83E\uDD86",
                1,	200,	4,	0.15),
            new Herbivorous("Caterpillar", "\uD83D\uDC1B",
                0.01,	1000,	0,	0));


    public void fillPredators(){
        for (int i = 0; i < predators.size(); i++) {
            for (int j = 0; j < field.getSizeX(); j++) {
                field.setAnimalOnField(new Random().nextInt(field.getSizeX()),new Random().nextInt(field.getSizeY()),predators.get(i));
            }
        }
    }
    public void fillHerbivorous(){
        for (int i = 0; i < herbivorous.size(); i++) {
            for (int j = 0; j < field.getSizeX(); j++) {
                field.setAnimalOnField(new Random().nextInt(field.getSizeX()),new Random().nextInt(field.getSizeY()),herbivorous.get(i));
            }
        }
    }

    public void fillPlants(){
        for (int i = 0; i < field.getSizeX(); i++) {
            for (int j = 0; j < field.getSizeY(); j++) {
                field.setAnimalOnField(i,j,plants);
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
        field.setAnimalOnField(4,4,herbivorous.get(2));

    }
    public void moveAnimal(){
        for (int i = 0; i < herbivorous.size(); i++) {
                field.move(herbivorous.get(i),randomDirection(),new Random().nextInt(herbivorous.get(i).getTravelSpeed() + 1));
        }
        for (int i = 0; i < predators.size(); i++) {
            field.move(predators.get(i),randomDirection(),new Random().nextInt(predators.get(i).getTravelSpeed() + 1));
        }
    }

    public void removeOneElement(){
        field.deleteAnimalOnField(1,1,0);
    }
}
