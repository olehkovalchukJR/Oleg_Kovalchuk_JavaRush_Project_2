package ru.javarush.oleg_kovalchuk.project2.game_characters.abstracts;

/*
        Травоядный
 */

public abstract class HerbivorousAnimal extends Animal {
    public HerbivorousAnimal(String icon, double weight, int maxPersonages, int travelSpeed, double maxFullness) {
        super(icon, weight, maxPersonages, travelSpeed, maxFullness);
    }

//    @Override
//    public void eat(List<BasicItem>[][] field, int i, int j, BasicItem personage) {
//        for (int k = 0; k < field[i][j].size(); k++) {
//            if (field[i][j].get(k).getName().equals(personage.getName())){
//                if (field[i][j].get(k) != null && field[i][j].get(k).getAmount() > 0){
//                    field[i][j].get(k).setAmount(field[i][j].get(k).getAmount() - 200);
//                } else {
//                    field[i][j].remove(k);
//                }
//            }
//        }
//    }
}