package com.daniel.flux.newspaper.database;

import android.content.Context;

/**
 * Created by danielnguyen on 2/2/16.
 */
public class DatabaseManager {
    private DatabaseHelper helper;
    private static DatabaseManager instance;

    private static final String TAG = DatabaseManager.class.getSimpleName();

    public static DatabaseManager getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseManager(context);
        }
        return instance;
    }

    private DatabaseManager(Context context) {
        helper = new DatabaseHelper(context);
    }

    public DatabaseHelper getHelper() {
        return helper;
    }
}