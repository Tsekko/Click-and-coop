package com.example.clickncoop.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Score.class}, version = 1)
public abstract class ScoreDatabase extends RoomDatabase {
    public abstract ScoreDAO ScoreDAO();

    private static ScoreDatabase INSTANCE;

    public static ScoreDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (ScoreDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ScoreDatabase.class, "scoreDatabase").build();
                }
            }
        }
        return INSTANCE;
    }
}
