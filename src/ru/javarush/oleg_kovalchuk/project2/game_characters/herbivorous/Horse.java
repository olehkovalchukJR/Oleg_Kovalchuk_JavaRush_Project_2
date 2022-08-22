package ru.javarush.oleg_kovalchuk.project2.game_characters.herbivorous;

import ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts.Animal;
import ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts.Personage;
import ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts.HerbivorousAnimal;
import ru.javarush.oleg_kovalchuk.project2.interfaces.Eateble;
import ru.javarush.oleg_kovalchuk.project2.interfaces.Movable;

import java.util.List;

public class Horse extends HerbivorousAnimal implements Movable, Eateble {
    private List<Animal> hungryAnimals;

    public Horse(String icon, double weight, int maxPersonages, int travelSpeed, double maxFullness) {
        super(icon, weight, maxPersonages, travelSpeed, maxFullness);
    }

    public int animalAmountOnThisPosition(List<Personage> list) {
        return (int) list.stream()
                .filter(o -> Boolean.parseBoolean(o.getName()))
                .count();
    }

    private void setAnimalOnNewPosition(List<Personage>[][] field, int x, int y, Animal animal) {
        field[x][y].add(animal);
        getHungry(animal);
        animal.setHungry(true);
    }

    @Override
    public void move(List<Personage>[][] field, String direction) {
        int newX;
        int newY;
        for (int x = 0; x < field.length; x++) {
            for (int y = 0; y < field[x].length; y++) {
                for (int k = 0; k < field[x][y].size(); k++) {
                    if (field[x][y].get(k).getName().equals(getName()) && !(field[x][y].get(k).getName().equals("Herb"))
                            && !(field[x][y].get(k).getName().equals("Caterpillar"))) {
                        Animal animalToMove = (Animal) field[x][y].get(k);

                        int vertical = 0;
                        int horizontal = 0;
                        int distance = randomValue(1, animalToMove.getTravelSpeed());
                        if (direction.equals("UP")) vertical -= distance;
                        if (direction.equals("DOWN")) vertical += distance;
                        if (direction.equals("RIGHT")) horizontal += distance;
                        if (direction.equals("LEFT")) horizontal -= distance;

                        if (x + vertical >= field.length || x + vertical < 0) {
                            newX = x - vertical;
                            newY = y + horizontal;
                        } else if (y + horizontal >= field[x].length || y + horizontal < 0) {
                            newX = x + vertical;
                            newY = y - horizontal;
                        } else {
                            newX = x + vertical;
                            newY = y + horizontal;
                        }
                        if (animalAmountOnThisPosition(field[newX][newY]) < animalToMove.getMaxPersonages()){
                            setAnimalOnNewPosition(field, newX, newY, animalToMove);
                            field[x][y].remove(animalToMove);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void getHungry(Animal animal) {
        double minusPercent = animal.getMaxFullness() * MINUS_HUNGER_PERCENTAGE / 100;
        animal.setCurrentFullness(animal.getCurrentFullness() - minusPercent);
    }

    private Personage findPrey(List<Personage> list, Personage prey) {
        for (int i = 0; i < list.size(); i++) {
            if (prey.getName().equals(list.get(i).getName())) {
                return list.get(i);
            }
        }
        return null;
    }

    private Animal findHunter(List<Personage> list) {
        Animal result = null;
        for (int i = 0; i < list.size(); i++) {
            if (getName().equals(list.get(i).getName())) {
                result = (Animal) list.get(i);
                if (result.isHungry()) {
                    return result;
                }
            }
        }
        return result;
    }

    private boolean containsAnimal(List<Personage> list, Personage personage) {
        for (int i = 0; i < list.size(); i++) {
            if (personage.getName().equals(list.get(i).getName())) {
                return true;
            }
        }
        return false;
    }


    @Override
    public void eat(List<Personage>[][] field, Personage findPrey) {
        for (int x = 0; x < field.length; x++) {
            for (int y = 0; y < field[x].length; y++) {
                if (containsAnimal(field[x][y], this)) {
                    Animal hunter = findHunter(field[x][y]);
                    while (hunter.getCurrentFullness() < hunter.getMaxFullness()) {
                        if (!hunter.isHungry()) {
                            if (containsAnimal(field[x][y], findPrey)) {
                                Personage prey = findPrey(field[x][y], findPrey);
                                hunter.setCurrentFullness(hunter.getCurrentFullness() + prey.getWeight());
                                if (hunter.getCurrentFullness() > hunter.getMaxFullness()) {
                                    hunter.setCurrentFullness(hunter.getMaxFullness());
                                }
                                hunter.setHungry(false);
                                field[x][y].remove(prey);
                            }
                        }
                    }
                }
            }
        }
    }

}
