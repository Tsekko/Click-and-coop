package com.example.clickncoop;

import java.util.UUID;

public class ConvertUUID {
    private UUID uid;
    public ConvertUUID(UUID uid){
        this.uid = uid;
    }

    public String conversionUUID(UUID uid){
        return uid.toString();
    }
}
