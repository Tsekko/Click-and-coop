package com.example.clickncoop.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ScoreDAO {
    @Query("SELECT * FROM score ORDER BY score DESC")
    LiveData<List<Score>> getAll();

    @Insert
    void insert(Score score);
}
