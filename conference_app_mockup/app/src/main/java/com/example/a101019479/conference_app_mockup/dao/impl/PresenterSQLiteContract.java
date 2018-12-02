package com.example.a101019479.conference_app_mockup.dao.impl;

import android.provider.BaseColumns;

public final class PresenterSQLiteContract {

    public static class PresenterSQLiteEntry implements BaseColumns {
        public static final String TABLE_NAME ="PRESENTERS";
        public static final String COL_NAME_FIRSTNAME = "FIRSTNAME";
        public static final String COL_TYPE_FIRSTNAME  = "TEXT";
        public static final String COL_NAME_LASTNAME = "LASTNAME";
        public static final String COL_TYPE_LASTNAME  = "TEXT";
        public static final String COL_NAME_AFFILIATION = "AFFILIATION";
        public static final String COL_TYPE_AFFILIATION  = "TEXT";
        public static final String COL_NAME_EMAIL = "EMAIL";
        public static final String COL_TYPE_EMAIL  = "TEXT";
        public static final String COL_NAME_BIO = "BIO";
        public static final String COL_TYPE_BIO  = "TEXT";
    }

    public static final String SQL_CREATE_PRESENTERS_TABLE =
            "CREATE TABLE " + PresenterSQLiteEntry.TABLE_NAME + " (" +
                    PresenterSQLiteEntry._ID + " INTEGER PRIMARY KEY, " +
                    PresenterSQLiteEntry.COL_NAME_FIRSTNAME + " " + PresenterSQLiteEntry.COL_TYPE_FIRSTNAME + ", " +
                    PresenterSQLiteEntry.COL_NAME_LASTNAME + " " + PresenterSQLiteEntry.COL_TYPE_LASTNAME + ", " +
                    PresenterSQLiteEntry.COL_NAME_AFFILIATION + " " + PresenterSQLiteEntry.COL_TYPE_AFFILIATION + ", " +
                    PresenterSQLiteEntry.COL_NAME_EMAIL + " " + PresenterSQLiteEntry.COL_TYPE_EMAIL + ", " +
                    PresenterSQLiteEntry.COL_NAME_BIO + " " + PresenterSQLiteEntry.COL_TYPE_BIO + ")";

    public static final String SQL_DROP_PRESENTERS =
            "DROP TABLE IF EXISTS " + PresenterSQLiteEntry.TABLE_NAME;
}
