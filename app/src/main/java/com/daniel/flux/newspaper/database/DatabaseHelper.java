package com.daniel.flux.newspaper.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.daniel.flux.newspaper.config.DatabaseConfig;
import com.daniel.flux.newspaper.database.model.News;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.lang.reflect.Method;

/**
 * Created by danielnguyen on 2/2/16.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String TAG = DatabaseHelper.class.getSimpleName();

    private Dao<News, Integer> newsDao = null;

    public DatabaseHelper(Context context) {
        super(context, DatabaseConfig.DATABASE_NAME, null, DatabaseConfig.DATABASE_VERSION);
    }

    @Override
    public void close() {
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            Log.i(TAG, "create database");
            TableUtils.createTable(connectionSource, News.class);
        } catch (SQLException e) {
            Log.e(TAG, "onCreate", e);
            throw new RuntimeException(e);
        } catch (java.sql.SQLException e) {
            Log.e(TAG, "onCreate", e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion,
                          int newVersion) {
        try {
            Log.i(TAG, "upgrade: " + oldVersion + "--" + newVersion);
            if (oldVersion < newVersion) {
                for (int i = oldVersion; i < newVersion; i++) {
                    String methodName = "updateFromDatabaseVersion" + i;
                    Method method = getClass().getDeclaredMethod(methodName, null);
                    method.setAccessible(true);
                    method.invoke(this, null);
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "onUpgrade", e);
        }
    }

    public Dao<News, Integer> getNewsDao() {
        if (null == newsDao) {
            try {
                newsDao = getDao(News.class);
            } catch (java.sql.SQLException e) {
                Log.e(TAG, "getNewsDao", e);
            }
        }
        return newsDao;
    }
}
