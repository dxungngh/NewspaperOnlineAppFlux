package com.daniel.flux.newspaper.store;

import android.content.Context;
import android.util.Log;

import com.daniel.flux.newspaper.R;
import com.daniel.flux.newspaper.action.base.DataBundle;
import com.daniel.flux.newspaper.action.base.MyAction;
import com.daniel.flux.newspaper.database.model.News;
import com.daniel.flux.newspaper.dispatcher.Dispatcher;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class NewsStore extends AbstractStore {
    private static final String TAG = NewsStore.class.getSimpleName();

    private final List<News> categoriesList;
    private final List<News> newsListOfCategory;

    private News currentCategory;
    private News currentNews;

    public NewsStore(Dispatcher dispatcher, Context context) {
        super(dispatcher, context);
        this.categoriesList = new ArrayList<>();
        this.newsListOfCategory = new ArrayList<>();
    }

    public List<News> getCategoriesList() {
        return this.categoriesList;
    }

    public List<News> getNewsListOfCategory() {
        return this.newsListOfCategory;
    }

    public News getCurrentCategory() {
        return this.currentCategory;
    }

    public void setCurrentCategory(News currentCategory) {
        this.currentCategory = currentCategory;
    }

    public News getCurrentNews() {
        return currentNews;
    }

    public void setCurrentNews(News currentNews) {
        News newsOfDatabase = super.newsDataSource.getNewsByContentId(currentNews.getContentId());
        if (newsOfDatabase != null) {
            this.currentNews = newsOfDatabase;
        } else {
            this.currentNews = currentNews;
        }
    }

    @Subscribe
    public void onAction(MyAction action) {
        MyAction.MyActionType type = (MyAction.MyActionType) action.getType();
        DataBundle data = action.getData();

        switch (type) {
            case GET_CATEGORIES_LIST_SUCCESSFULLY:
                onGetCategoriesSuccessfully(data);
                break;
            case GET_CATEGORIES_LIST_FAIL:
                onGetCategoriesFail(data);
                break;

            case GET_NEWS_LIST_OF_CATEGORY_SUCCESSFULLY:
                onGetNewsListOfCategorySuccessfully(data);
                break;
            case GET_NEWS_LIST_OF_CATEGORY_FAIL:
                onGetNewsListOfCategoryFail(data);
                break;

            case GET_NEWS_DETAIL_SUCCESSFULLY:
                onGetNewsDetailSuccessfully(data);
                break;
            case GET_NEWS_DETAIL_FAIL:
                onGetNewsDetailFail(data);
                break;
        }
    }

    private void onGetCategoriesSuccessfully(DataBundle data) {
        List<News> homeNewsList = (List<News>) data.get(MyAction.MyDataKey.NEWS_LIST);
        this.categoriesList.clear();
        this.categoriesList.addAll(homeNewsList);
        super.emitStoreChange(new NewsStoreChangeEvent(null));
    }

    private void onGetCategoriesFail(DataBundle data) {
        Throwable error = (Throwable) data.get((MyAction.MyDataKey.ERROR));
        Log.e(TAG, "onGetCategoriesFail", error);
        super.emitStoreChange(new NewsStoreChangeEvent(super.context.getString(R.string.error_internet)));
    }

    private void onGetNewsListOfCategorySuccessfully(DataBundle data) {
        List<News> newsList = (List<News>) data.get(MyAction.MyDataKey.NEWS_LIST);
        this.newsListOfCategory.clear();
        this.newsListOfCategory.addAll(newsList);
        super.emitStoreChange(new NewsStoreChangeEvent(null));
    }

    private void onGetNewsListOfCategoryFail(DataBundle data) {
        Throwable error = (Throwable) data.get((MyAction.MyDataKey.ERROR));
        Log.e(TAG, "onGetNewsListOfCategoryFail", error);
        super.emitStoreChange(new NewsStoreChangeEvent(super.context.getString(R.string.error_internet)));
    }

    private void onGetNewsDetailSuccessfully(DataBundle data) {
        String content = (String) data.get(MyAction.MyDataKey.NEWS_CONTENT);
        content = this.formatContent(this.currentNews.getTitle(), content);
        this.currentNews.setContent(content);
        super.newsDataSource.createNews(this.currentNews);
        super.emitStoreChange(new NewsStoreChangeEvent(null));
    }

    private void onGetNewsDetailFail(DataBundle data) {
        Throwable error = (Throwable) data.get((MyAction.MyDataKey.ERROR));
        Log.e(TAG, "onGetNewsListFail", error);
        super.emitStoreChange(new NewsStoreChangeEvent(super.context.getString(R.string.error_internet)));
    }

    private String formatContent(String title, String content) {
        content = content.replace("src=\"_\"", "");
        content = content.replace("data-img-src", "src");
        content = content.replace("data-img-width", "width");
        content = content.replace("data-img-height", "height");

        content = "<p><strong><h1>" + title + "</h1></strong></p>" + content;
        content = "<style>img{display: inline;height: auto;max-width: 100%;}</style>" + content;

        return content;
    }
}