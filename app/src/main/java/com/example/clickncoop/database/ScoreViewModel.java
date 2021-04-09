package com.example.clickncoop.database;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class ScoreViewModel extends AndroidViewModel {
    private ScoreRepository mRepository;
    private LiveData<List<Score>> mAllScore;

    public ScoreViewModel(Application application){
        super(application);
        mRepository = new ScoreRepository(application);
        mAllScore = mRepository.getAllScore();
    }

    public LiveData<List<Score>> getAllScore(){
        return mAllScore;
    }

    public void insert(Score score){
        mRepository.insert(score);
    }
}
