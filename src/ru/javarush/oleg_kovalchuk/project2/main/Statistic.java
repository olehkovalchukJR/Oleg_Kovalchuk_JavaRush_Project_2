package ru.javarush.oleg_kovalchuk.project2.main;

import ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts.Herbivorous;
import ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts.Personage;
import ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts.Plant;
import ru.javarush.oleg_kovalchuk.project2.game_characters.plants.Herb;

import java.util.List;

/*
        Задача - сбор статистики

        Каждый ход собирается статистика:

    - сколько животных осталось на текущий момент
    - сколько животных умерло от голода/были съедены
    - сколько родилось новых животных
    - разница между первым ходом и текущим по кол-ву животных
    - тип животного которое чаще всего делает N-дейсвтие

    Сбор статистики идет для всех животных + трава
 */

public class Statistic{

    public void currentAnimalAmount(List<Personage>[][] field, Personage character){
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                String icon = character.getIcon();
                String name = character.getName();
                int amount = (int) field[i][j].stream()
                        .filter(o -> o.getName().equals(character.getName()))
                        .count();
                if (amount > 0) {
                    System.out.println(icon + " " + name + ", amount " + amount + ", position: (X " + i + ") (X " + j + ")");
                }
            }
        }
    }
    public void createdPlantsAmount(List<Herb> animal){
        System.out.println();
        System.out.println("Created Plants:");
        for (int i = 0; i < animal.size(); i++) {
            System.out.println(animal.get(i).getIcon() + animal.get(i).getName() + ", created "
                    + animal.get(i).getCreatedPersonagesAmount());
        }
    }
    public void diedPlantsAmount(List<Herb> animal){
        System.out.println();
        System.out.println("Died Plants:");
        for (int i = 0; i < animal.size(); i++) {
            System.out.println(animal.get(i).getIcon() + animal.get(i).getName() + ", died "
                    + animal.get(i).getDiedPersonagesAmount());
        }
    }

    public void createdPersonageAmount(List<Herbivorous> animal){
        System.out.println();
        System.out.println("Created Herbivorous:");
        for (int i = 0; i < animal.size(); i++) {
            System.out.println(animal.get(i).getIcon() + animal.get(i).getName() + ", created "
                    + animal.get(i).getCreatedPersonagesAmount());
        }
    }

    public void diedPersonageAmount(List<Herbivorous> animal){
        System.out.println();
        System.out.println("Died Herbivorous:");
        for (int i = 0; i < animal.size(); i++) {
            System.out.println(animal.get(i).getIcon() + animal.get(i).getName() + ", died "
                    + animal.get(i).getDiedPersonagesAmount());
        }
    }

    public void livingPersonageAmount(List<Herbivorous> animal){
        System.out.println();
        System.out.println("Living Herbivorous:");
        for (int i = 0; i < animal.size(); i++) {
            int result = animal.get(i).getCreatedPersonagesAmount() - animal.get(i).getDiedPersonagesAmount();
            System.out.println(animal.get(i).getIcon() + animal.get(i).getName() + ", living "
                    + result);
        }
    }
}
