package ru.javarush.oleg_kovalchuk.project2.island;

import ru.javarush.oleg_kovalchuk.project2.game_characters.Animal;
import ru.javarush.oleg_kovalchuk.project2.game_characters.BasicItem;
import ru.javarush.oleg_kovalchuk.project2.main.Statistic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Field implements Movable{
    private int sizeX = 10;
    private int sizeY = 10;

    private List<BasicItem>[][] field;

    public Field() {
        field = new List[sizeX][sizeY];
        fillArrayWithNewLists();
    }

    public List<BasicItem>[][] getField() {
        return field;
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
    public void setAnimalOnField(int x, int y, BasicItem animal){
        field[x][y].add(animal);
    }

//    public Fieldable getAnimalOnField(int x,int y, int listIndex){
//        return field[x][y].get(listIndex);
//    }

    public void deleteAnimalOnField(int x, int y, int listIndex){
        field[x][y].remove(listIndex);
    }

    public void printField(){
        System.out.println();
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j].size() == 0){
                    System.out.print("[  ] ");
                } else if(field[i][j].size() == 1){
                    System.out.print("[" + field[i][j].get(0) + "] ");
                } else{
                    int index = new Random().nextInt(field[i][j].size() - 1) + 1;
                    System.out.print("[" + field[i][j].get(index) + "] ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public void move(Animal animal, String direction , int distance){
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
                    if (i + vertical >= field.length || i + vertical < 0){
                        setAnimalOnField(i - vertical, j + horizontal, animal);
                        field[i][j].remove(animal);
                        return;
                    } else if (j + horizontal >= field[i].length || j + horizontal < 0){
                        setAnimalOnField(i + vertical, j - horizontal, animal);
                        field[i][j].remove(animal);
                        return;
                    } else {
                        setAnimalOnField(i + vertical,j + horizontal,animal);
                        field[i][j].remove(animal);
                        return;
                    }
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
