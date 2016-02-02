package com.daniel.flux.newspaper.action;

import android.content.Context;

import com.daniel.flux.newspaper.action.base.Action;
import com.daniel.flux.newspaper.action.base.ActionCreator;
import com.daniel.flux.newspaper.action.base.ActionType;
import com.daniel.flux.newspaper.action.base.DataBundle;
import com.daniel.flux.newspaper.action.base.MyAction;
import com.daniel.flux.newspaper.callback.OnFetchNewsDetailListener;
import com.daniel.flux.newspaper.dispatcher.Dispatcher;
import com.daniel.flux.newspaper.database.model.News;

/**
 * Created by danielnguyen on 1/13/16.
 */
public class NewsDetailActivityActionCreator extends ActionCreator {
    private static final String TAG = NewsDetailActivityActionCreator.class.getSimpleName();

    public NewsDetailActivityActionCreator(Context context, Dispatcher dispatcher) {
        super(context, dispatcher);
    }

    public void getNewsDetail(News news) {
        this.newsApiAdapter.fetchNewsDetail(news.getContentId(), new OnFetchNewsDetailListener() {
            @Override
            public void onSuccess(String result) {
                NewsDetailActivityActionCreator.this.onGetNewsListOfCategorySuccessfully(result);
            }

            @Override
            public void onFailed(Throwable error) {
                NewsDetailActivityActionCreator.this.onGetNewsListOfCategoryFail(error);
            }
        });
    }

    private void onGetNewsListOfCategorySuccessfully(String result) {
        ActionType type = MyAction.MyActionType.GET_NEWS_DETAIL_SUCCESSFULLY;
        DataBundle data = new DataBundle();
        data.put(MyAction.MyDataKey.NEWS_CONTENT, result);
        Action action = new MyAction(type, data);
        super.dispatch(action);
    }

    private void onGetNewsListOfCategoryFail(Throwable error) {
        ActionType type = MyAction.MyActionType.GET_NEWS_DETAIL_FAIL;
        DataBundle data = new DataBundle();
        data.put(MyAction.MyDataKey.ERROR, error);
        Action action = new MyAction(type, data);
        super.dispatch(action);
    }
}