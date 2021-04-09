package com.example.clickncoop;

import java.util.UUID;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Score {
    @PrimaryKey
    public UUID id;

    @ColumnInfo(name="score")
    public int score;

    @ColumnInfo(name="gameMode")
    public String gameMode;
}
