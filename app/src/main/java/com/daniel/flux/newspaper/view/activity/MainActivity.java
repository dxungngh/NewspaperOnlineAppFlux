package com.daniel.flux.newspaper.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.daniel.flux.newspaper.R;
import com.daniel.flux.newspaper.store.NewsStoreChangeEvent;
import com.squareup.otto.Subscribe;

public class MainActivity extends BaseActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
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
    public void onHomeStoreChange(NewsStoreChangeEvent event) {
        if (TextUtils.isEmpty(event.getError())) {
            this.goToHomeActivity();
            super.finish();
        }
    }

    private void fetchCategoriesOfServer() {
        super.mainActivityActionCreator.fetchCategoriesOfServer();
    }

    private void goToHomeActivity() {
        Intent intent = new Intent(this, CategoryActivity.class);
        super.startActivity(intent);
    }
}