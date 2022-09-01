package ru.javarush.oleg_kovalchuk.project2.game_characters.service;

import ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts.Herbivorous;
import ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts.Personage;
import ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts.Plant;
import ru.javarush.oleg_kovalchuk.project2.game_characters.herbivorous.*;
import ru.javarush.oleg_kovalchuk.project2.interfaces.Randomable;

import java.lang.reflect.Constructor;
import java.util.List;

public class PersonageFilling implements Randomable {
    // Знаю что это тоже не коректно
    // Хотел в конце все переделать

    public void fillPlants(List<Personage>[][] field, Plant plant) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                for (int k = 0; k < plant.getMaxPersonages(); k++) {
                    field[i][j].add(plant);
                    plant.setCreatedPersonagesAmount(plant.getCreatedPersonagesAmount() + 1);
                }
            }
        }
    }

    public void fillHorse(List<Personage>[][] field, Personage herbivorous) {
        field[0][0].add(herbivorous);
    }

    public void fillHorse(List<Personage>[][] field) {


    }

    public void fillHorse(List<Personage>[][] field, Herbivorous herbivorous) {
        int amountAnimalsOnField = randomValue(1, herbivorous.getMaxPersonages());
        for (int j = 0; j < amountAnimalsOnField; j++) {
            int x = randomValue(0, field.length);
            int y = randomValue(0, field[x].length);
            for (int k = 0; k < randomValue(1, herbivorous.getMaxPersonages()); k++) {
                int amount = (int) field[x][y].stream()
                        .filter(o -> o.getName().equals(herbivorous.getName()))
                        .count();
                if (amount < herbivorous.getMaxPersonages()) {
                    field[x][y].add(new Horse("\uD83D\uDC0E", 400, 20, 4, 60));
                    herbivorous.setCreatedPersonagesAmount(herbivorous.getCreatedPersonagesAmount() + 1);
                }
            }
        }
    }

    public void fillDeer(List<Personage>[][] field, Herbivorous herbivorous) {
        int amountAnimalsOnField = randomValue(1, herbivorous.getMaxPersonages());
        for (int j = 0; j < amountAnimalsOnField; j++) {
            int x = randomValue(0, field.length);
            int y = randomValue(0, field[x].length);
            for (int k = 0; k < randomValue(1, herbivorous.getMaxPersonages()); k++) {
                int amount = (int) field[x][y].stream()
                        .filter(o -> o.getName().equals(herbivorous.getName()))
                        .count();
                if (amount < herbivorous.getMaxPersonages()) {
                    field[x][y].add(new Deer("\uD83E\uDD8C", 300, 20, 4, 50));
                    herbivorous.setCreatedPersonagesAmount(herbivorous.getCreatedPersonagesAmount() + 1);
                }
            }
        }
    }

    public void fillRabbit(List<Personage>[][] field, Herbivorous herbivorous) {
        int amountAnimalsOnField = randomValue(1, herbivorous.getMaxPersonages());
        for (int j = 0; j < amountAnimalsOnField; j++) {
            int x = randomValue(0, field.length);
            int y = randomValue(0, field[x].length);
            for (int k = 0; k < randomValue(1, herbivorous.getMaxPersonages()); k++) {
                int amount = (int) field[x][y].stream()
                        .filter(o -> o.getName().equals(herbivorous.getName()))
                        .count();
                if (amount < herbivorous.getMaxPersonages()) {
                    field[x][y].add(new Rabbit("\uD83D\uDC07", 2, 150, 2, 0.45));
                    herbivorous.setCreatedPersonagesAmount(herbivorous.getCreatedPersonagesAmount() + 1);
                }
            }
        }
    }

    public void fillMouse(List<Personage>[][] field, Herbivorous herbivorous) {
        int amountAnimalsOnField = randomValue(1, herbivorous.getMaxPersonages());
        for (int j = 0; j < amountAnimalsOnField; j++) {
            int x = randomValue(0, field.length);
            int y = randomValue(0, field[x].length);
            for (int k = 0; k < randomValue(1, herbivorous.getMaxPersonages()); k++) {
                int amount = (int) field[x][y].stream()
                        .filter(o -> o.getName().equals(herbivorous.getName()))
                        .count();
                if (amount < herbivorous.getMaxPersonages()) {
                    field[x][y].add(new Mouse("\uD83D\uDC01", 0.05, 500, 1, 0.01));
                    herbivorous.setCreatedPersonagesAmount(herbivorous.getCreatedPersonagesAmount() + 1);
                }
            }
        }
    }
    public void fillGoat(List<Personage>[][] field, Herbivorous herbivorous) {
        int amountAnimalsOnField = randomValue(1, herbivorous.getMaxPersonages());
        for (int j = 0; j < amountAnimalsOnField; j++) {
            int x = randomValue(0, field.length);
            int y = randomValue(0, field[x].length);
            for (int k = 0; k < randomValue(1, herbivorous.getMaxPersonages()); k++) {
                int amount = (int) field[x][y].stream()
                        .filter(o -> o.getName().equals(herbivorous.getName()))
                        .count();
                if (amount < herbivorous.getMaxPersonages()) {
                    field[x][y].add(new Goat("\uD83D\uDC0E", 60,	140,	3, 10));
                    herbivorous.setCreatedPersonagesAmount(herbivorous.getCreatedPersonagesAmount() + 1);
                }
            }
        }
    }
    public void fillSheep(List<Personage>[][] field, Herbivorous herbivorous) {
        int amountAnimalsOnField = randomValue(1, herbivorous.getMaxPersonages());
        for (int j = 0; j < amountAnimalsOnField; j++) {
            int x = randomValue(0, field.length);
            int y = randomValue(0, field[x].length);
            for (int k = 0; k < randomValue(1, herbivorous.getMaxPersonages()); k++) {
                int amount = (int) field[x][y].stream()
                        .filter(o -> o.getName().equals(herbivorous.getName()))
                        .count();
                if (amount < herbivorous.getMaxPersonages()) {
                    field[x][y].add(new Sheep("\uD83D\uDC11", 70,	140,	3,	15));
                    herbivorous.setCreatedPersonagesAmount(herbivorous.getCreatedPersonagesAmount() + 1);
                }
            }
        }
    }
    public void fillBoar(List<Personage>[][] field, Herbivorous herbivorous) {
        int amountAnimalsOnField = randomValue(1, herbivorous.getMaxPersonages());
        for (int j = 0; j < amountAnimalsOnField; j++) {
            int x = randomValue(0, field.length);
            int y = randomValue(0, field[x].length);
            for (int k = 0; k < randomValue(1, herbivorous.getMaxPersonages()); k++) {
                int amount = (int) field[x][y].stream()
                        .filter(o -> o.getName().equals(herbivorous.getName()))
                        .count();
                if (amount < herbivorous.getMaxPersonages()) {
                    field[x][y].add(new Boar("\uD83D\uDC17", 400,	50,	2,	50));
                    herbivorous.setCreatedPersonagesAmount(herbivorous.getCreatedPersonagesAmount() + 1);
                }
            }
        }
    }
    public void fillBuffalo(List<Personage>[][] field, Herbivorous herbivorous) {
        int amountAnimalsOnField = randomValue(1, herbivorous.getMaxPersonages());
        for (int j = 0; j < amountAnimalsOnField; j++) {
            int x = randomValue(0, field.length);
            int y = randomValue(0, field[x].length);
            for (int k = 0; k < randomValue(1, herbivorous.getMaxPersonages()); k++) {
                int amount = (int) field[x][y].stream()
                        .filter(o -> o.getName().equals(herbivorous.getName()))
                        .count();
                if (amount < herbivorous.getMaxPersonages()) {
                    field[x][y].add(new Buffalo("\uD83D\uDC03", 700,	10,	3,	100));
                    herbivorous.setCreatedPersonagesAmount(herbivorous.getCreatedPersonagesAmount() + 1);
                }
            }
        }
    }
    public void fillDuck(List<Personage>[][] field, Herbivorous herbivorous) {
        int amountAnimalsOnField = randomValue(1, herbivorous.getMaxPersonages());
        for (int j = 0; j < amountAnimalsOnField; j++) {
            int x = randomValue(0, field.length);
            int y = randomValue(0, field[x].length);
            for (int k = 0; k < randomValue(1, herbivorous.getMaxPersonages()); k++) {
                int amount = (int) field[x][y].stream()
                        .filter(o -> o.getName().equals(herbivorous.getName()))
                        .count();
                if (amount < herbivorous.getMaxPersonages()) {
                    field[x][y].add(new Duck("\uD83E\uDD86", 1,	200,	4,	0.15));
                    herbivorous.setCreatedPersonagesAmount(herbivorous.getCreatedPersonagesAmount() + 1);
                }
            }
        }
    }
    public void fillCaterpillar(List<Personage>[][] field, Herbivorous herbivorous) {
        int amountAnimalsOnField = randomValue(1, herbivorous.getMaxPersonages());
        for (int j = 0; j < amountAnimalsOnField; j++) {
            int x = randomValue(0, field.length);
            int y = randomValue(0, field[x].length);
            for (int k = 0; k < randomValue(1, herbivorous.getMaxPersonages()); k++) {
                int amount = (int) field[x][y].stream()
                        .filter(o -> o.getName().equals(herbivorous.getName()))
                        .count();
                if (amount < herbivorous.getMaxPersonages()) {
                    field[x][y].add(new Caterpillar("\uD83D\uDC1B", 0.01,	1000,	0,	0));
                    herbivorous.setCreatedPersonagesAmount(herbivorous.getCreatedPersonagesAmount() + 1);
                }
            }
        }
    }
}
