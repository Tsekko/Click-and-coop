package com.example.clickncoop.database;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;

public class ScoreRepository {
    private ScoreDAO mScoreDAO;
    private LiveData<List<Score>> mAllScoreMash;
    private LiveData<List<Score>> mAllScoreRhythm;

    public ScoreRepository(Application application){
        ScoreDatabase db = ScoreDatabase.getDatabase(application);
        mScoreDAO = db.ScoreDAO();
        mAllScoreMash = mScoreDAO.getAllMash();
        mAllScoreRhythm = mScoreDAO.getAllRhythm();
    }

    public LiveData<List<Score>> getAllScoreMash(){
        return mAllScoreMash;
    }

    public LiveData<List<Score>> getAllScoreRhythm(){ return mAllScoreRhythm;}

    public void insert (Score score){
        new insertAsyncTask(mScoreDAO).execute(score);
    }

    private static class insertAsyncTask extends AsyncTask<Score, Void, Void> {
        private ScoreDAO mAsyncTaskDao;

        insertAsyncTask(ScoreDAO dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Score... params){
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
