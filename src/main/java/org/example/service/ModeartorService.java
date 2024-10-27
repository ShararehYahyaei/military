package org.example.service;

import org.example.database.Database;
import org.example.model.Rank;
import org.example.model.Soldier;

public class ModeartorService {

    static SoldierService soldierService = new SoldierService();
    static Database soldierRepo = new Database();


    public Soldier[] getAllSoldiers() {
        Soldier[] soldiers = soldierRepo.soldierInit();
        return soldiers;

    }

    public Soldier getSoldierById(int id) {
        return soldierRepo.getSoldierById(id);
    }


}
