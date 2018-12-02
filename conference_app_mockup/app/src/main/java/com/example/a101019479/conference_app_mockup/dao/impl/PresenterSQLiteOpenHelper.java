package com.example.a101019479.conference_app_mockup.dao.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.a101019479.conference_app_mockup.model.Presenter;

import java.util.ArrayList;
import java.util.List;

public class PresenterSQLiteOpenHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "presenters.db";

    private SQLiteDatabase sqliteDb;

    public PresenterSQLiteOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PresenterSQLiteContract.SQL_CREATE_PRESENTERS_TABLE);

        Log.d("DB-TEST", "Database created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void addPresenter(SQLiteDatabase db, Presenter presenter) {
        ContentValues values = new ContentValues();
        values.put(PresenterSQLiteContract.PresenterSQLiteEntry.COL_NAME_FIRSTNAME, presenter.getFirstName());
        values.put(PresenterSQLiteContract.PresenterSQLiteEntry.COL_NAME_LASTNAME, presenter.getLastName());
        values.put(PresenterSQLiteContract.PresenterSQLiteEntry.COL_NAME_AFFILIATION, presenter.getAffiliation());
        values.put(PresenterSQLiteContract.PresenterSQLiteEntry.COL_NAME_EMAIL, presenter.getEmail());
        values.put(PresenterSQLiteContract.PresenterSQLiteEntry.COL_NAME_BIO, presenter.getBio());

        long row_id = db.insert(PresenterSQLiteContract.PresenterSQLiteEntry.TABLE_NAME, null, values);
        Log.d(this.getClass().toString(), String.format("Added new Presenter record with ID [%d]", row_id));
    }

    public List<Presenter> getAllPresenters(SQLiteDatabase db) {
        List<Presenter> result = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from presenters", null);
        cursor.moveToFirst();

        while(!cursor.isAfterLast()) {
            long id = cursor.getLong(cursor.getColumnIndexOrThrow(PresenterSQLiteContract.PresenterSQLiteEntry._ID));
            String firstName = cursor.getString(cursor.getColumnIndexOrThrow(PresenterSQLiteContract.PresenterSQLiteEntry.COL_NAME_FIRSTNAME));
            String lastName = cursor.getString(cursor.getColumnIndexOrThrow(PresenterSQLiteContract.PresenterSQLiteEntry.COL_NAME_LASTNAME));
            String affiliation = cursor.getString(cursor.getColumnIndexOrThrow(PresenterSQLiteContract.PresenterSQLiteEntry.COL_NAME_AFFILIATION));
            String email = cursor.getString(cursor.getColumnIndexOrThrow(PresenterSQLiteContract.PresenterSQLiteEntry.COL_NAME_EMAIL));
            String bio = cursor.getString(cursor.getColumnIndexOrThrow(PresenterSQLiteContract.PresenterSQLiteEntry.COL_NAME_BIO));
            Presenter presenter = new Presenter(id, firstName, lastName, affiliation, email, bio);
            result.add(presenter);
            cursor.moveToNext();
        }
        return result;
    }
}
