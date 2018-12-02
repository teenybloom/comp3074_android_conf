package com.example.a101019479.conference_app_mockup.dao.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.a101019479.conference_app_mockup.dao.PresenterDao;
import com.example.a101019479.conference_app_mockup.model.Presenter;

import java.util.List;

public class PresenterSQLiteDao implements PresenterDao {

    private PresenterSQLiteOpenHelper presenterSQLiteOpenHelper;
    private SQLiteDatabase sqliteDb;

    public PresenterSQLiteDao(Context context) {
        presenterSQLiteOpenHelper = new PresenterSQLiteOpenHelper(context);
        sqliteDb = presenterSQLiteOpenHelper.getWritableDatabase();
    }

    @Override
    public void addPresenter(Presenter presenter) {
        presenterSQLiteOpenHelper.addPresenter(sqliteDb, presenter);
    }

    @Override
    public List<Presenter> getAllPresenters() {
        return presenterSQLiteOpenHelper.getAllPresenters(sqliteDb);
    }
}
