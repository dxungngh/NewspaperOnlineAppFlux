package com.daniel.flux.newspaper.view.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.daniel.flux.newspaper.R;
import com.daniel.flux.newspaper.application.MyApplication;
import com.daniel.flux.newspaper.store.NewsStoreChangeEvent;
import com.daniel.flux.newspaper.view.adapter.CategoriesListAdapter;
import com.squareup.otto.Subscribe;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CategoryActivity extends BaseActivity {
    private static final String TAG = CategoryActivity.class.getSimpleName();

    @Bind(R.id.category_refresh_layout)
    MaterialRefreshLayout categoryRefreshLayout;
    @Bind(R.id.category_recycler_view)
    protected RecyclerView categoryRecyclerView;

    protected CategoriesListAdapter categoriesListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_category);
        ButterKnife.bind(this);
        this.setRefreshListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
        super.dispatcher.register(this);
        super.dispatcher.register(super.newsStore);

        this.setupRecyclerView();
        this.drawNewsList();
    }

    @Override
    protected void onPause() {
        super.onPause();
        super.dispatcher.unregister(this);
        super.dispatcher.unregister(super.newsStore);
    }

    @Subscribe
    public void onCategoriesListChange(NewsStoreChangeEvent event) {
        this.categoryRefreshLayout.finishRefresh();

        if (TextUtils.isEmpty(event.getError())) {
            this.drawNewsList();
        } else {
            super.showError(event.getError());
        }
    }

    private void setupRecyclerView() {
        GridLayoutManager manager = new GridLayoutManager(this, 2);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0) {
                    return 2;
                } else {
                    return 1;
                }
            }
        });
        this.categoryRecyclerView.setLayoutManager(manager);
        this.categoryRecyclerView.setHasFixedSize(true);
    }

    private void setRefreshListener() {
        this.categoryRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                CategoryActivity.super.mainActivityActionCreator.fetchCategoriesOfServer();
            }
        });
    }

    private void drawNewsList() {
        if (this.categoriesListAdapter == null) {
            this.categoriesListAdapter = new CategoriesListAdapter((MyApplication) super.getApplication(), this);
            this.categoryRecyclerView.setAdapter(this.categoriesListAdapter);
        } else {
            this.categoriesListAdapter.notifyDataSetChanged();
        }
    }
}