package com.daniel.flux.newspaper.view.widget;

/**
 * Created by danielnguyen on 1/28/16.
 */

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.daniel.flux.newspaper.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoadingDialog extends Dialog {
    private static final String TAG = LoadingDialog.class.getSimpleName();

    private static LoadingDialog loadingDialog;

    @Bind(R.id.dialog_loading_layout)
    protected RelativeLayout dialogLayout;
    @Bind(R.id.dialog_loading_image)
    protected ImageView loadingImageView;

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
        this.dialogLayout.setVisibility(View.VISIBLE);
        this.loadingImageView.setVisibility(View.VISIBLE);
        this.loadingImageView.setImageResource(R.drawable.loading);
        AnimationDrawable loadAnimation = (AnimationDrawable) this.loadingImageView.getDrawable();
        loadAnimation.start();
    }

    @Override
    public void dismiss() {
        Log.i(TAG, "dismiss");
        AnimationDrawable loadAnimation = (AnimationDrawable) this.loadingImageView.getDrawable();
        loadAnimation.stop();

        this.loadingImageView.setVisibility(View.GONE);
        this.dialogLayout.setVisibility(View.GONE);

        super.dismiss();
    }
}