package com.daniel.flux.newspaper.view.widget;

/**
 * Created by danielnguyen on 1/28/16.
 */

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.daniel.flux.newspaper.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoadingDialog extends Dialog {
    private static LoadingDialog loadingDialog;

    @Bind(R.id.loading)
    protected ImageView loadingImageView;

    private static final String TAG = LoadingDialog.class.getSimpleName();

    public static LoadingDialog getInstance(Activity activity) {
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(activity);
        }
        return loadingDialog;
    }

    public LoadingDialog(Activity activity) {
        super(activity);
    }

    private void drawComponentView() {
        super.setCancelable(false);
        this.loadingImageView.setVisibility(View.VISIBLE);
        this.showLoading();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        super.setContentView(R.layout.dialog_loading);

        ButterKnife.bind(this);
        this.drawComponentView();
    }

    @Override
    protected void onStop() {
        loadingDialog = null;
    }

    private void showLoading() {
        this.loadingImageView.setVisibility(View.VISIBLE);
        this.loadingImageView.setImageResource(R.drawable.loading);
        AnimationDrawable loadAnimation = (AnimationDrawable) this.loadingImageView.getDrawable();
        this.loadingImageView.setVisibility(View.VISIBLE);
        loadAnimation.start();
    }
}