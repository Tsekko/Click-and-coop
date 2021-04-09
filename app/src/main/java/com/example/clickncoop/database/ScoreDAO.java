package com.example.clickncoop.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ScoreDAO {

    @Query("SELECT * FROM score WHERE gameMode='Mash' ORDER BY score DESC")
    LiveData<List<Score>> getAllMash();

    @Query("SELECT * FROM score WHERE gameMode='Rhythm' ORDER BY score DESC")
    LiveData<List<Score>> getAllRhythm();

    @Insert
    void insert(Score score);
}
