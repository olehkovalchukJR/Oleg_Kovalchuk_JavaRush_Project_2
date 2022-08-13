package ru.javarush.oleg_kovalchuk.project2.island;

import ru.javarush.oleg_kovalchuk.project2.animals.Fieldable;
import ru.javarush.oleg_kovalchuk.project2.animals.Herbivorous;
import ru.javarush.oleg_kovalchuk.project2.animals.Plants;
import ru.javarush.oleg_kovalchuk.project2.animals.Predator;

import java.util.HashMap;
import java.util.Map;


public class Island{
    private final String UP_DIRECTION = "UP";
    private final String DOWN_DIRECTION = "DOWN";
    private final String RIGHT_DIRECTION = "RIGHT";
    private final String LEFT_DIRECTION = "LEFT";
    Field field = new Field();

    Plants plants = new Plants("Animals.Plants","\uD83C\uDF34",200,1,
            200,0,0);
    public Map<String,Predator> predators = Map.of(
            "wolf",new Predator("Wolf", "\uD83D\uDC3A", 10,
                    50,30,3,8),
            "boa",new Predator("Boa", "\uD83D\uDC0D", 10,
                    15,30,1,3),
            "fox",new Predator("Fox", "\uD83E\uDD8A", 10,
                    8,30,2,2),
            "bear",new Predator("Bear", "\uD83D\uDC3B", 10,
                    500,5,2,80),
            "eagle",new Predator("Wolf", "\uD83D\uDC3A", 10,
                    6,20,3,1));

    public Map<String,Herbivorous> herbivorous = Map.of(
            "horse", new Herbivorous("Horse", "\uD83D\uDC0E", 10,
                    400,20,4,60),
        "deer", new Herbivorous("Deer", "\uD83E\uDD8C", 10,
                300,20,4,50),
        "rabbit", new Herbivorous("Rabbit", "\uD83D\uDC07", 10,
                2,150,2,0.45),
        "mouse", new Herbivorous("Mouse", "\uD83D\uDC01", 10,
                0.05,500,1,0.01),
        "goat", new Herbivorous("Goat", "\uD83D\uDC0E", 10,
                60,	140,	3, 10),
        "sheep", new Herbivorous("Sheep", "\uD83D\uDC11", 10,
                70,	140,	3,	15),
        "boar", new Herbivorous("Boar", "\uD83D\uDC17", 10,
                400,	50,	2,	50),
        "buffalo", new Herbivorous("Buffalo", "\uD83D\uDC03", 10,
                700,	10,	3,	100),
        "duck", new Herbivorous("Duck", "\uD83E\uDD86", 10,
                1,	200,	4,	0.15),
        "caterpillar", new Herbivorous("Caterpillar", "\uD83D\uDC1B", 10,
                0.01,	1000,	0,	0));


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
    public void addAnimal(){
        field.setAnimalOnField(3,3,predators.get("fox"));

    }
    public void moveUp(){
        field.move(predators.get("fox"),LEFT_DIRECTION,1);
    }

}
