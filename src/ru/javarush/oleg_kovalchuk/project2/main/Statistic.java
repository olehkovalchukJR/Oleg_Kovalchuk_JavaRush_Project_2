package ru.javarush.oleg_kovalchuk.project2.main;

import ru.javarush.oleg_kovalchuk.project2.game_characters.BasicItem;

import java.util.List;

public class Statistic{

    public void currentAmount(List<BasicItem>[][] field){
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print("At position X = " + i + " and Y = " + j + " there are: ");
                for (int k = 0; k < field[i][j].size(); k++) {
                    System.out.print(field[i][j].get(k).getAmount() + " units of " + field[i][j].get(k).getName() + ", ");
                }
                System.out.println();
            }
        }

    }

}
