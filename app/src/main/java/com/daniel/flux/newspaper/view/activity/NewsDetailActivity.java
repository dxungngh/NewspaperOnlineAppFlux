package com.daniel.flux.newspaper.view.activity;

import android.os.Bundle;
import android.text.TextUtils;

import com.daniel.flux.newspaper.R;
import com.daniel.flux.newspaper.store.NewsStoreChangeEvent;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ObservableWebView;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.squareup.otto.Subscribe;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewsDetailActivity extends BaseActivity {
    private static final String TAG = NewsDetailActivity.class.getSimpleName();

    @Bind(R.id.news_detail_content)
    protected ObservableWebView contentWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_news_detail);
        ButterKnife.bind(this);
        this.initWebView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        super.dispatcher.register(this);
        super.dispatcher.register(super.newsStore);

        this.getNewsContent();
    }

    @Override
    protected void onPause() {
        super.onPause();
        super.dispatcher.unregister(this);
        super.dispatcher.unregister(super.newsStore);
    }

    @Subscribe
    public void onNewsDetailChange(NewsStoreChangeEvent event) {
        super.hideLoadingDialog();
        if (TextUtils.isEmpty(event.getError())) {
            this.drawNewsContent();
        } else {
            super.showError(event.getError());
        }
    }

    private void getNewsContent() {
        super.showLoadingDialog(this);
        super.newsDetailActivityActionCreator.getNewsDetail(super.newsStore.getCurrentNews());
    }

    private void drawNewsContent() {
        String content = super.newsStore.getCurrentNews().getContent();
        this.contentWebView.loadData(content, "text/html; charset=UTF-8", null);
    }

    private void initWebView() {
        this.contentWebView.setScrollViewCallbacks(new ObservableScrollViewCallbacks() {
            @Override
            public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
            }

            @Override
            public void onDownMotionEvent() {
            }

            @Override
            public void onUpOrCancelMotionEvent(ScrollState scrollState) {
                if (scrollState == ScrollState.UP) {
                    NewsDetailActivity.super.hideActionBar();
                } else if (scrollState == ScrollState.DOWN) {
                    NewsDetailActivity.super.showActionBar();
                }
            }
        });
    }
}