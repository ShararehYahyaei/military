package org.example.service;

import org.example.database.Database;
import org.example.model.Soldier;

public class SoldierService {



    Database soldierRepo = new Database();

    public Soldier[] getAllSoldiers() {
        return soldierRepo.soldierInit();
    }


}
