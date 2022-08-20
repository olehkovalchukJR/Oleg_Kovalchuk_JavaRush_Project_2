package ru.javarush.oleg_kovalchuk.project2.game_characters.herbivorous;

import ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts.Animal;
import ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts.BasicItem;
import ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts.HerbivorousAnimal;
import ru.javarush.oleg_kovalchuk.project2.interfaces.Movable;

import java.util.List;

public class Horse extends HerbivorousAnimal implements Movable {
    public Horse(String icon, double weight, int maxPersonages, int travelSpeed, double maxFullness) {
        super(icon, weight, maxPersonages, travelSpeed, maxFullness);
    }

    @Override
    public void move(List<BasicItem>[][] field, String direction) {
        int distance = (int)(Math.random() * getTravelSpeed()) + 1;
        int vertical = 0;
        int horizontal = 0;
        if (direction.equals("UP")) vertical -= distance;
        if (direction.equals("DOWN")) vertical += distance;
        if (direction.equals("RIGHT")) horizontal += distance;
        if (direction.equals("LEFT")) horizontal -= distance;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                for (int k = 0; k < field[i][j].size(); k++) {
                    if (field[i][j].get(k).getName().equals(getName())){
                        BasicItem animalToMove = field[i][j].get(k);

                        if (i + vertical >= field.length || i + vertical < 0) {
                            field[i-vertical][j+horizontal].add(animalToMove);
                            field[i][j].remove(k);
                            return;
                        } else if (j + horizontal >= field[i].length || j + horizontal < 0) {
                            field[i + vertical][j - horizontal].add(animalToMove);
                            field[i][j].remove(k);
                            return;
                        } else {
                            field[i + vertical][j + horizontal].add(animalToMove);
                            field[i][j].remove(k);
                            return;
                        }
                    }
                }
            }
        }
    }

    @Override
    public void eat(List<BasicItem> field, BasicItem prey) {
        if (field.contains(prey)){
            field.remove(prey);
        }
//        for (int i = 0; i < field.size(); i++) {
//            if (prey.getName().equals(field.get(i).getName())){
//                field.remove(i);
//                return;
//            }
//        }
    }
}
