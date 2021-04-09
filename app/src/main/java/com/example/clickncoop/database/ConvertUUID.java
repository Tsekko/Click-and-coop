package com.example.clickncoop.database;

import androidx.room.TypeConverter;

import java.util.UUID;

public class ConvertUUID {
    @TypeConverter
    public String fromUUID(UUID uid){
        if(uid == null){
            return null;
        } else {
            return uid.toString();
        }
    }
}
