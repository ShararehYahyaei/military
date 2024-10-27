package org.example.model;

import lombok.*;

@Getter
@Setter
@ToString
public class Soldier {



    int id;
    Rank rank;
    Shoot [] shoots;
    private int finalScore;

}