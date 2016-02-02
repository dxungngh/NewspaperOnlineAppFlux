package com.daniel.flux.newspaper.action;

import android.content.Context;

import com.daniel.flux.newspaper.action.base.Action;
import com.daniel.flux.newspaper.action.base.ActionCreator;
import com.daniel.flux.newspaper.action.base.ActionType;
import com.daniel.flux.newspaper.action.base.DataBundle;
import com.daniel.flux.newspaper.action.base.MyAction;
import com.daniel.flux.newspaper.callback.OnGetNewsListListener;
import com.daniel.flux.newspaper.config.NewsConfig;
import com.daniel.flux.newspaper.dispatcher.Dispatcher;
import com.daniel.flux.newspaper.model.News;

import java.util.List;

/**
 * Created by danielnguyen on 1/13/16.
 */
public class CategoryActivityActionCreator extends ActionCreator {
    private static final String TAG = CategoryActivityActionCreator.class.getSimpleName();

    public CategoryActivityActionCreator(Context context, Dispatcher dispatcher) {
        super(context, dispatcher);
    }

    public void getNewsListOfType(String listType, int listId) {
        this.newsApiAdapter.fetchNewsOfCategory(
            0, NewsConfig.COUNT, listType, listId, NewsConfig.IMAGE_MIN_SIZE,
            new OnGetNewsListListener() {
                @Override
                public void onSuccess(List<News> result) {
                    CategoryActivityActionCreator.this.onGetNewsListOfCategorySuccessfully(result);
                }

                @Override
                public void onFailed(Throwable error) {
                    CategoryActivityActionCreator.this.onGetNewsListOfCategoryFail(error);
                }
            });
    }

    private void onGetNewsListOfCategorySuccessfully(List<News> result) {
        ActionType type = MyAction.MyActionType.GET_NEWS_LIST_OF_CATEGORY_SUCCESSFULLY;
        DataBundle data = new DataBundle();
        data.put(MyAction.MyDataKey.NEWS_LIST, result);
        Action action = new MyAction(type, data);
        super.dispatch(action);
    }

    private void onGetNewsListOfCategoryFail(Throwable error) {
        ActionType type = MyAction.MyActionType.GET_NEWS_LIST_OF_CATEGORY_FAIL;
        DataBundle data = new DataBundle();
        data.put(MyAction.MyDataKey.ERROR, error);
        Action action = new MyAction(type, data);
        super.dispatch(action);
    }
}