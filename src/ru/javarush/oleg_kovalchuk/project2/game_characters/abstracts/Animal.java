package ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts;

import ru.javarush.oleg_kovalchuk.project2.interfaces.Eateble;
import ru.javarush.oleg_kovalchuk.project2.interfaces.Movable;
import ru.javarush.oleg_kovalchuk.project2.interfaces.Randomable;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal extends Personage implements Eateble, Movable, Randomable {
    private final int travelSpeed;
    private double currentFullness;
    private final double maxFullness;
    private boolean isHungry;
    private boolean isBreed;
    private boolean isAnimalMovedBefore;
    private Map<String, Integer> percentPossibleToEatPrey = new HashMap<>();

    public Animal(String icon, double weight, int maxPersonages, int travelSpeed, double maxFullness) {
        super(icon, weight, maxPersonages);
        this.travelSpeed = travelSpeed;
        this.maxFullness = maxFullness;
        this.currentFullness = maxFullness;
        this.isBreed = false;
        this.isHungry = true;
        this.isAnimalMovedBefore = false;
    }

    public int getTravelSpeed() {
        return travelSpeed;
    }

    public double getCurrentFullness() {
        return currentFullness;
    }

    public void setCurrentFullness(double currentFullness) {
        this.currentFullness = currentFullness;
    }

    public double getMaxFullness() {
        return maxFullness;
    }

    public boolean isBreed() {
        return isBreed;
    }

    public void setBreed(boolean breed) {
        isBreed = breed;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }

    public boolean isAnimalMovedBefore() {
        return isAnimalMovedBefore;
    }

    public void setAnimalMovedBefore(boolean animalMovedBefore) {
        isAnimalMovedBefore = animalMovedBefore;
    }

    public Map<String, Integer> getPercentPossibleToEatPrey() {
        return percentPossibleToEatPrey;
    }

    public void setPercentPossibleToEatPrey(Map<String, Integer> percentPossibleToEatPrey) {
        this.percentPossibleToEatPrey = percentPossibleToEatPrey;
    }

    @Override
    public void move(List<Personage>[][] field, String direction) {
        animalDiesOfHungry(field);
        int newX;
        int newY;
        for (int x = 0; x < field.length; x++) {
            for (int y = 0; y < field[x].length; y++) {
                for (int k = 0; k < field[x][y].size(); k++) {
                    if (field[x][y].get(k).getName().equals(getName()) && !(field[x][y].get(k).getName().equals("Herb"))
                            && !(field[x][y].get(k).getName().equals("Caterpillar"))) {
                        var animalToMove = (Animal) field[x][y].get(k);
                        animalToMove.makeHungry();
                        if (!animalToMove.isAnimalMovedBefore()) {

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
                            if (animalAmountOnThisPosition(field[newX][newY]) < animalToMove.getMaxPersonages()) {
                                setAnimalOnNewPosition(field, newX, newY, animalToMove);
                                field[x][y].remove(animalToMove);
                            }
                        }
                    }
                }
            }
        }
    }


    @Override
    public void eat(List<Personage>[][] field) {
        for (int x = 0; x < field.length; x++) {
            for (int y = 0; y < field[x].length; y++) {
                if (containsHunterAndPrey(field[x][y])) {
                    for (int k = 0; k < field[x][y].size(); k++) {
                        if (field[x][y].get(k).getName().equals(getName())) {
                            var hunter = findHunter(field[x][y]);
                            hunter.setAnimalMovedBefore(false);
                            while (hunter.isHungry()) {
                                var prey = findPrey(field[x][y]);
                                if (prey == null || hunter.getCurrentFullness() >= hunter.getMaxFullness()) {
                                    hunter.setHungry(false);
                                } else {
                                    hunter.setCurrentFullness(hunter.getCurrentFullness() + prey.getWeight());
                                    prey.setDiedPersonagesAmount(prey.getDiedPersonagesAmount() + 1);
                                    field[x][y].remove(prey);
                                    if (hunter.getCurrentFullness() >= hunter.getMaxFullness()) {
                                        hunter.setHungry(false);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    private Personage findPrey(List<Personage> list) {
        Personage prey = null;
        String possiblePrey = null;
        List<Integer> valueList = new ArrayList<>(getPercentPossibleToEatPrey().values());
        int randomPercent = valueList.get(ThreadLocalRandom.current().nextInt(0, valueList.size()));
        for (Map.Entry<String,Integer> preyName : getPercentPossibleToEatPrey().entrySet()){
            if (randomPercent == preyName.getValue()){
                possiblePrey = preyName.getKey();
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (possiblePrey.equals(list.get(i).getName())){
                prey = list.get(i);
                return prey;
            }
        }
        return prey;
    }


    private Animal findHunter(List<Personage> list) {
        Animal result = null;
        for (Personage personage : list) {
            if (getName().equals(personage.getName())) {
                result = (Animal) personage;
                if (result.isHungry() && result.getCurrentFullness() < result.getMaxFullness()) {
                    return result;
                }
            }
        }
        return result;
    }

    private boolean containsHunterAndPrey(List<Personage> list) {
        for (int i = 0; i < list.size(); i++) {
            if (getName().equals(list.get(i).getName())) {
                Animal animal = (Animal) list.get(i);
                for (int j = 0; j < list.size(); j++) {
                    if (animal.getPercentPossibleToEatPrey().containsKey(list.get(j).getName())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private int animalAmountOnThisPosition(List<Personage> list) {
        return (int) list.stream()
                .filter(o -> Boolean.parseBoolean(o.getName()))
                .count();
    }


    private void makeHungry() {
        double minusPercent = getMaxFullness() * MINUS_HUNGER_PERCENTAGE / 100;
        setCurrentFullness(getCurrentFullness() - minusPercent);
    }

    private void setAnimalOnNewPosition(List<Personage>[][] field, int x, int y, Animal animal) {
        field[x][y].add(animal);
        animal.setHungry(true);
        animal.setAnimalMovedBefore(true);
    }

    private void animalDiesOfHungry(List<Personage>[][] field) {
        for (int x = 0; x < field.length; x++) {
            for (int y = 0; y < field[x].length; y++) {
                for (int k = 0; k < field[x][y].size(); k++) {
                    if (field[x][y].get(k).getName().equals(getName()) && !(field[x][y].get(k).getName().equals("Herb"))) {
                        Animal animalToDie = (Animal) field[x][y].get(k);
                        if (animalToDie.getCurrentFullness() <= 0) {
                            setDiedPersonagesAmount(getDiedPersonagesAmount() + 1);
                            field[x][y].remove(animalToDie);
                        }
                    }
                }
            }
        }
    }
}
