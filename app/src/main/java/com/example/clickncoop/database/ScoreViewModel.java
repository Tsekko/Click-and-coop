package com.example.clickncoop.database;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class ScoreViewModel extends AndroidViewModel {
    private ScoreRepository mRepository;
    private LiveData<List<Score>> mAllScoreMash;
    private LiveData<List<Score>> mAllScoreRhythm;

    public ScoreViewModel(Application application){
        super(application);
        mRepository = new ScoreRepository(application);
        mAllScoreMash = mRepository.getAllScoreMash();
    }

    public LiveData<List<Score>> getAllScoreMash(){
        return mAllScoreMash;
    }

    public LiveData<List<Score>> getAllScoreRhythm(){return mAllScoreRhythm;}

    public void insert(Score score){
        mRepository.insert(score);
    }
}
