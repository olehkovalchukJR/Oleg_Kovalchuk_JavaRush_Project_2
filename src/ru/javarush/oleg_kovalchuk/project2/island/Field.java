package ru.javarush.oleg_kovalchuk.project2.island;

import ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts.Personage;
import ru.javarush.oleg_kovalchuk.project2.interfaces.Randomable;

import java.util.ArrayList;
import java.util.List;

public class Field implements Randomable {
    private int sizeX = 10;
    private int sizeY = 10;

    private List<Personage>[][] field;

    public Field() {
        field = new List[sizeX][sizeY];
        fillArrayWithNewLists();
    }

    public List<Personage>[][] getField() {
        return field;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }


    public void setAnimalOnField(int x, int y, Personage animal) {
        field[x][y].add(animal);
    }

//    public Fieldable getAnimalOnField(int x,int y, int listIndex){
//        return field[x][y].get(listIndex);
//    }

    public void deleteAnimalOnField(int x, int y, int listIndex) {
        if (field[x][y].size() > 0) {
            field[x][y].remove(listIndex);
        } else {
            return;
        }
    }

    public void printField() {
        System.out.println();
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                List<Personage> list = field[i][j].stream().distinct().toList();
                if (list.size() == 0) {
                    System.out.print("[  ] ");
                } else if (list.size() == 1) {
                    System.out.print("[" + list.get(0) + "] ");
                } else {
                    int index = (int) (Math.random() * list.size() - 1) + 1;
                    System.out.print("[" + list.get(index) + "] ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }


//    public int randomValue(int minValet, int maxValue) {
//        return (int) (Math.random() * maxValue) + minValet;
//    }


    private void fillArrayWithNewLists() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = new ArrayList<>();
            }
        }
    }
}
