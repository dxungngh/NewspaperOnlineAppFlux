package com.daniel.flux.newspaper.action;

import android.content.Context;

import com.daniel.flux.newspaper.action.base.Action;
import com.daniel.flux.newspaper.action.base.ActionCreator;
import com.daniel.flux.newspaper.action.base.ActionType;
import com.daniel.flux.newspaper.action.base.DataBundle;
import com.daniel.flux.newspaper.action.base.MyAction;
import com.daniel.flux.newspaper.callback.OnFetchNewsesListListener;
import com.daniel.flux.newspaper.config.NewsConfig;
import com.daniel.flux.newspaper.dispatcher.Dispatcher;
import com.daniel.flux.newspaper.database.model.News;

import java.util.List;

/**
 * Created by danielnguyen on 1/13/16.
 */
public class CategoryActivityActionCreator extends ActionCreator {
    private static final String TAG = CategoryActivityActionCreator.class.getSimpleName();

    public CategoryActivityActionCreator(Context context, Dispatcher dispatcher) {
        super(context, dispatcher);
    }

    public void fetchCategoriesOfServer() {
        this.newsApiAdapter.fetchCategoriesOfServer(new OnFetchNewsesListListener() {
            @Override
            public void onSuccess(List<News> result) {
                CategoryActivityActionCreator.this.onFetchCategoriesOfServerSuccessfully(result);
            }

            @Override
            public void onFailed(Throwable error) {
                CategoryActivityActionCreator.this.onFetchCategoriesOfServerFail(error);
            }
        });
    }

    private void onFetchCategoriesOfServerSuccessfully(List<News> result) {
        ActionType type = MyAction.MyActionType.GET_CATEGORIES_LIST_SUCCESSFULLY;
        DataBundle data = new DataBundle();
        data.put(MyAction.MyDataKey.NEWS_LIST, result);
        Action action = new MyAction(type, data);
        super.dispatch(action);
    }

    private void onFetchCategoriesOfServerFail(Throwable error) {
        ActionType type = MyAction.MyActionType.GET_CATEGORIES_LIST_FAIL;
        DataBundle data = new DataBundle();
        data.put(MyAction.MyDataKey.ERROR, error);
        Action action = new MyAction(type, data);
        super.dispatch(action);
    }

    public void fetchNewsesListOfCategory(String listType, int listId) {
        this.newsApiAdapter.fetchNewsesListOfCategory(
            0, NewsConfig.COUNT, listType, listId, NewsConfig.IMAGE_MIN_SIZE,
            new OnFetchNewsesListListener() {
                @Override
                public void onSuccess(List<News> result) {
                    CategoryActivityActionCreator.this.onFetchNewsesListOfCategorySuccessfully(result);
                }

                @Override
                public void onFailed(Throwable error) {
                    CategoryActivityActionCreator.this.onFetchNewsesListOfCategoryFail(error);
                }
            });
    }

    private void onFetchNewsesListOfCategorySuccessfully(List<News> result) {
        ActionType type = MyAction.MyActionType.GET_NEWS_LIST_OF_CATEGORY_SUCCESSFULLY;
        DataBundle data = new DataBundle();
        data.put(MyAction.MyDataKey.NEWS_LIST, result);
        Action action = new MyAction(type, data);
        super.dispatch(action);
    }

    private void onFetchNewsesListOfCategoryFail(Throwable error) {
        ActionType type = MyAction.MyActionType.GET_NEWS_LIST_OF_CATEGORY_FAIL;
        DataBundle data = new DataBundle();
        data.put(MyAction.MyDataKey.ERROR, error);
        Action action = new MyAction(type, data);
        super.dispatch(action);
    }
}