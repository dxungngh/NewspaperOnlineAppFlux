package com.daniel.flux.newspaper.database.datasource;

import android.content.Context;
import android.util.Log;

import com.daniel.flux.newspaper.database.DatabaseHelper;
import com.daniel.flux.newspaper.database.DatabaseManager;
import com.daniel.flux.newspaper.database.model.News;
import com.j256.ormlite.stmt.PreparedQuery;

/**
 * Created by danielnguyen on 2/2/16.
 */
public class NewsDataSource {
    public static final String TAG = NewsDataSource.class.getSimpleName();
    private Context context;

    public NewsDataSource(Context context) {
        this.context = context;
    }

    public void createNews(News news) {
        try {
            DatabaseHelper helper = DatabaseManager.getInstance(context).getHelper();
            helper.getNewsDao().create(news);
        } catch (Exception e) {
            Log.e(TAG, "createNews", e);
        }
    }

    public News getNewsByContentId(long contentId) {
        try {
            DatabaseHelper helper = DatabaseManager.getInstance(context).getHelper();
            PreparedQuery<News> preparedQuery = helper.getNewsDao().queryBuilder().where().eq(
                News.Fields.CONTENT_ID, contentId).prepare();
            News news = helper.getNewsDao().queryForFirst(preparedQuery);
            return news;
        } catch (Exception e) {
            Log.e(TAG, "getNewsByContentId", e);
            return null;
        }
    }

    public void updateContent(News news) {
        try {
            DatabaseHelper helper = DatabaseManager.getInstance(context).getHelper();
            helper.getNewsDao().update(news);
        } catch (Exception e) {
            Log.e(TAG, "updateContent", e);
        }
    }
}
