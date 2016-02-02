package com.daniel.flux.newspaper.action;

import android.content.Context;

import com.daniel.flux.newspaper.action.base.Action;
import com.daniel.flux.newspaper.action.base.ActionCreator;
import com.daniel.flux.newspaper.action.base.ActionType;
import com.daniel.flux.newspaper.action.base.DataBundle;
import com.daniel.flux.newspaper.action.base.MyAction;
import com.daniel.flux.newspaper.callback.OnGetNewsListListener;
import com.daniel.flux.newspaper.dispatcher.Dispatcher;
import com.daniel.flux.newspaper.model.News;

import java.util.List;

/**
 * Created by danielnguyen on 1/13/16.
 */
public class MainActivityActionCreator extends ActionCreator {
    private static final String TAG = MainActivityActionCreator.class.getSimpleName();

    public MainActivityActionCreator(Context context, Dispatcher dispatcher) {
        super(context, dispatcher);
    }

    public void fetchCategoriesOfServer() {
        this.newsApiAdapter.fetchCategoriesOfServer(new OnGetNewsListListener() {
            @Override
            public void onSuccess(List<News> result) {
                MainActivityActionCreator.this.onFetchCategoriesOfServerSuccessfully(result);
            }

            @Override
            public void onFailed(Throwable error) {
                MainActivityActionCreator.this.onFetchCategoriesOfServerFail(error);
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
}