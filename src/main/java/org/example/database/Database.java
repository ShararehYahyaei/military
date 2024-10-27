package org.example.database;

import org.example.model.Rank;
import org.example.model.Shoot;
import org.example.model.Soldier;

import java.util.Random;

public class Database {
    Soldier[] soldiers = new Soldier[15];


    public Soldier[] soldierInit() {

        for (int index = 0; index < 15; index++) {

            Soldier soldier = new Soldier();
            Random random = new Random();
            Rank rank = getRandomRank(random);
            soldier.setId(index + 1);
            soldier.setRank(rank);
            soldier.setShoots(shootInit());
            soldier.setFinalScore(calculateScoreForSoldier(soldier));
            soldiers[index] = soldier;
        }

        return soldiers;
    }

    private static Rank getRandomRank(Random random) {
        int maxRank = Rank.values().length;
        int randomRank = random.nextInt(maxRank);
        Rank rank = Rank.values()[randomRank];
        return rank;
    }


    public Shoot[] shootInit() {
        Shoot[] shoots = new Shoot[4];
        Random random = new Random();
        for (int i = 0; i < shoots.length; i++) {
            Shoot shoot = new Shoot();
            shoot.setScore(random.nextInt(10));
            shoots[i] = shoot;
        }
        return shoots;
    }


    public Soldier getSoldierById(int id) {
        for (Soldier soldier : soldiers) {
            if (soldier.getId() == id) {

                return soldier;
            }
        }
        return null;
    }

    public int calculateScoreForSoldier(Soldier soldier) {
        int score = 0;
        Shoot[] shoots = soldier.getShoots();
        for (int i = 0; i < shoots.length; i++) {
            score = score + shoots[i].getScore();
        }

        return score;
    }


}
