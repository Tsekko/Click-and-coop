package com.example.clickncoop;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface ScoreDAO {
    @Query("SELECT * FROM score ORDER BY score DESC")
    List<Score> getAll();

    @Insert
    void insert(Score score);
}
