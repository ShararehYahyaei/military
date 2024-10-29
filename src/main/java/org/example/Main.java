package org.example;

import org.example.model.Rank;
import org.example.model.Shoot;
import org.example.model.Soldier;
import org.example.service.ModeartorService;

public class Main {
    static ModeartorService moderatorService = new ModeartorService();

    public static void main(String[] args) {

        int finalR;
        int quantityForRace = 1;
        do {
            int quantitySoldier = getQuantitySoldiersWithCorporalRank(runRace());
            System.out.println("Quantity Soldiers With Corporal Rank: " + quantitySoldier);
            finalR = quantitySoldier * 100 / 15;
            System.out.println("Quantity Percentage With Corporal Rank: " + finalR);
            System.out.println("Quantity For Race: " + quantityForRace);
            quantityForRace++;
        }
        while (finalR > 60);

    }

    private static Soldier[] runRace() {
        Soldier[] soldiers = initialRace();
        for (int i = 0; i < soldiers.length; i++) {
            showSoldierInformation(soldiers[i]);
            System.out.println("Final Score: " + soldiers[i].getFinalScore());
            System.out.println("Initial Rank: " + soldiers[i].getRank());
            ChangeRankForEachSoldier(soldiers[i]);
            System.out.println("Final Rank: " + soldiers[i].getRank());
            System.out.println();
            System.out.println("***************");
            System.out.println();
        }
        return soldiers;
    }

    public static Soldier[] initialRace() {
        Soldier[] soldiers = moderatorService.getAllSoldiers();
        return soldiers;
    }


    public static Rank levelUpRank(Rank rank) {

        switch (rank) {
            case lieutenant:
                rank = Rank.lieutenant;
                break;
            case Sergeant:
                rank = Rank.lieutenant;
                break;
            case Corporal:
                rank = Rank.Sergeant;
                break;

        }
        return rank;
    }

    public static Rank lessOneRank(Rank rank) {
        switch (rank) {
            case lieutenant:
                rank = Rank.Sergeant;
                break;
            case Sergeant:
                rank = Rank.Corporal;
                break;
            case Corporal:
                rank = Rank.Corporal;
                break;

        }
        return rank;
    }

    public static void showSoldierInformation(Soldier soldier) {
        System.out.println("Soldier ID : " + soldier.getId());
        showShootsForPerSoldier(soldier.getShoots());

    }

    public static void showShootsForPerSoldier(Shoot[] shoots) {
        for (int index = 0; index < shoots.length; index++) {
            System.out.print("Bullet " + (index + 1) + ":");
            System.out.println(shoots[index]);
        }
    }

    public static void ChangeRankForEachSoldier(Soldier soldier) {

        if (soldier.getFinalScore() >= 28) {
            soldier.setRank(levelUpRank(soldier.getRank()));
        } else {

            soldier.setRank(lessOneRank(soldier.getRank()));
        }

    }

    public static int getQuantitySoldiersWithCorporalRank(Soldier[] soldiers) {
        int quantity = 0;
        for (Soldier soldier : soldiers) {
            if (soldier.getRank() == Rank.Corporal) {
                quantity++;
            }
        }
        return quantity;
    }


}