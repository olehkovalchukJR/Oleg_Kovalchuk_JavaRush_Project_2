package ru.javarush.oleg_kovalchuk.project2.island;

import ru.javarush.oleg_kovalchuk.project2.animals.Fieldable;

import java.util.ArrayList;
import java.util.List;

public class Field {
    private int sizeX = 10;
    private int sizeY = 10;

    private List<Fieldable>[][] field;


    public Field() {
        field = new List[sizeX][sizeY];
        fillArrayWithNewLists();
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public int getArrayListSize(int x, int y){
        return field[x][y].size();
    }
    public void setAnimalOnField(int x, int y, Fieldable animal){

        field[x][y].add(animal);
    }

    public Fieldable getAnimalOnField(int x,int y, int listIndex){
        return field[x][y].get(listIndex);
    }

    public void deleteAnimalOnField(int x, int y, int listIndex){
        field[x][y].remove(listIndex);
    }

    public void printField(){
        System.out.println();
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void move(Fieldable animal, String direction , int distance){
        int vertical = 0;
        int horizontal = 0;
        if (direction.equals("UP")){
            vertical -= distance;
        }
        if (direction.equals("DOWN")){
            vertical += distance;
        }
        if (direction.equals("RIGHT")){
            horizontal += distance;
        }
        if (direction.equals("LEFT")){
            horizontal -= distance;
        }
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j].contains(animal)){
                    setAnimalOnField(i + vertical,j + horizontal,animal);
                    field[i][j].remove(animal);
                    return;
                }
            }
        }
    }

    private void fillArrayWithNewLists(){
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = new ArrayList<>();
            }
        }
    }

}
