package com.example.clickncoop.database;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;

public class ScoreRepository {
    private ScoreDAO mScoreDAO;
    private LiveData<List<Score>> mAllScore;

    public ScoreRepository(Application application){
        ScoreDatabase db = ScoreDatabase.getDatabase(application);
        mScoreDAO = db.ScoreDAO();
        mAllScore = mScoreDAO.getAll();
    }

    public LiveData<List<Score>> getAllScore(){
        return mAllScore;
    }

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
