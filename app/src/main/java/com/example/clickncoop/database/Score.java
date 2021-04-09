package com.example.clickncoop.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity
public class Score {
    @PrimaryKey
    public UUID id;

    @ColumnInfo(name="score")
    public int score;

    @ColumnInfo(name="gameMode")
    public String gameMode;
}
