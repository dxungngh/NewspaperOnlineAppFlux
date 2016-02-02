package com.daniel.flux.newspaper.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.daniel.flux.newspaper.R;
import com.daniel.flux.newspaper.action.CategoryActivityActionCreator;
import com.daniel.flux.newspaper.action.NewsDetailActivityActionCreator;
import com.daniel.flux.newspaper.application.ApplicationComponent;
import com.daniel.flux.newspaper.application.MyApplication;
import com.daniel.flux.newspaper.dispatcher.Dispatcher;
import com.daniel.flux.newspaper.store.NewsStore;
import com.daniel.flux.newspaper.view.widget.LoadingDialog;
import com.squareup.otto.Bus;

import javax.inject.Inject;

/**
 * Created by danielnguyen on 1/9/16.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private static final String TAG = BaseActivity.class.getSimpleName();

    protected ApplicationComponent component;

    @Inject
    protected Bus bus;
    @Inject
    protected Dispatcher dispatcher;
    @Inject
    protected CategoryActivityActionCreator categoryActivityActionCreator;
    @Inject
    protected NewsDetailActivityActionCreator newsDetailActivityActionCreator;

    @Inject
    protected NewsStore newsStore;

    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.initDependencies();
    }

    private void initDependencies() {
        MyApplication myApplication = (MyApplication) this.getApplication();
        this.component = myApplication.getComponent();
        this.component.inject(this);
    }

    protected void showError(String error) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(super.getString(R.string.app_name));
        builder.setMessage(error);
        builder.setCancelable(true);
        builder.show();
    }

    protected void hideLoadingDialog() {
        try {
            if (this.loadingDialog != null) {
                this.loadingDialog.dismiss();
            }
            this.loadingDialog = null;
        } catch (Exception e) {
            Log.e(TAG, "hideLoadingDialog", e);
        }
    }

    protected void showLoadingDialog(final Activity activity) {
        this.hideLoadingDialog();
        if (this.loadingDialog == null && !activity.isFinishing()) {
            try {
                this.loadingDialog = LoadingDialog.getInstance(activity);
                this.loadingDialog.show();
            } catch (Exception e) {
                Log.e(TAG, "showLoadingDialog", e);
                this.hideLoadingDialog();
            }
        }
    }

    protected void hideActionBar() {
        try {
            ActionBar actionBar = super.getSupportActionBar();
            if (actionBar.isShowing()) {
                super.getSupportActionBar().hide();
            }
        } catch (Exception e) {
            Log.e(TAG, "hideActionBar", e);
        }
    }

    protected void showActionBar() {
        try {
            ActionBar actionBar = super.getSupportActionBar();
            if (!actionBar.isShowing()) {
                super.getSupportActionBar().show();
            }
        } catch (Exception e) {
            Log.e(TAG, "showActionBar", e);
        }
    }
}