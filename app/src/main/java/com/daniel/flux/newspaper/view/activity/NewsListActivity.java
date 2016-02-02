package com.daniel.flux.newspaper.view.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.daniel.flux.newspaper.R;
import com.daniel.flux.newspaper.application.MyApplication;
import com.daniel.flux.newspaper.model.News;
import com.daniel.flux.newspaper.store.NewsStoreChangeEvent;
import com.daniel.flux.newspaper.view.adapter.NewsListAdapter;
import com.squareup.otto.Subscribe;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewsListActivity extends BaseActivity {
    private static final String TAG = NewsListActivity.class.getSimpleName();

    @Bind(R.id.news_list_recycler_view)
    protected RecyclerView newsListRecyclerView;

    private NewsListAdapter newsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_news_list);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        super.dispatcher.register(this);
        super.dispatcher.register(super.newsStore);

        this.setTitle();
        this.setupRecyclerView();
        this.getNewsList();
    }

    @Override
    protected void onPause() {
        super.onPause();
        super.dispatcher.unregister(this);
        super.dispatcher.unregister(super.newsStore);
    }

    @Subscribe
    public void onNewsListOfCategoryChange(NewsStoreChangeEvent event) {
        super.hideLoadingDialog();
        if (TextUtils.isEmpty(event.getError())) {
            this.drawNewsList();
        } else {
            super.showError(event.getError());
        }
    }

    private void getNewsList() {
        super.showLoadingDialog(this);
        News currentCategory = super.newsStore.getCurrentCategory();
        super.categoryActivityActionCreator.getNewsListOfType(currentCategory.getListType(),
            currentCategory.getListId());
    }

    private void drawNewsList() {
        if (this.newsListAdapter == null) {
            this.newsListAdapter = new NewsListAdapter((MyApplication) super.getApplication(), this);
            this.newsListRecyclerView.setAdapter(this.newsListAdapter);
        } else {
            this.newsListAdapter.notifyDataSetChanged();
        }
    }

    private void setupRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        this.newsListRecyclerView.setLayoutManager(manager);
        this.newsListRecyclerView.setHasFixedSize(true);
    }

    private void setTitle() {
        String title = super.newsStore.getCurrentCategory().getListName();
        super.setTitle(title);
    }
}