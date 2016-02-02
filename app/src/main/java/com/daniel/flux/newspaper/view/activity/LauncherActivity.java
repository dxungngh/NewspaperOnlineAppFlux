package com.daniel.flux.newspaper.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.daniel.flux.newspaper.R;
import com.daniel.flux.newspaper.store.NewsStoreChangeEvent;
import com.squareup.otto.Subscribe;

public class LauncherActivity extends BaseActivity {
    private static final String TAG = LauncherActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_launcher);
    }

    @Override
    protected void onResume() {
        super.onResume();
        super.dispatcher.register(this);
        super.dispatcher.register(super.newsStore);
        this.fetchCategoriesOfServer();
    }

    @Override
    protected void onPause() {
        super.onPause();
        super.dispatcher.unregister(this);
        super.dispatcher.unregister(super.newsStore);
    }

    @Subscribe
    public void onCategoriesListChange(NewsStoreChangeEvent event) {
        if (TextUtils.isEmpty(event.getError())) {
            Intent intent = new Intent(this, CategoryActivity.class);
            super.startActivity(intent);
            super.finish();
        }
    }

    private void fetchCategoriesOfServer() {
        super.mainActivityActionCreator.fetchCategoriesOfServer();
    }
}