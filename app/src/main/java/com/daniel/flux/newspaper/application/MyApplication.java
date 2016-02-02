package com.daniel.flux.newspaper.application;

import android.app.Application;

import com.daniel.flux.newspaper.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by danielnguyen on 1/11/16.
 */
public class MyApplication extends Application {
    private static final String TAG = MyApplication.class.getSimpleName();

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        this.component = ApplicationComponent.Initializer.init(this);
        this.initialize();
    }

    public ApplicationComponent getComponent() {
        return this.component;
    }

    private void initialize() {
        this.initializeImageLoader();
    }

    private void initializeImageLoader() {
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
            .cacheInMemory(true)
            .cacheOnDisk(true)
            .showImageOnLoading(R.mipmap.ic_placeholder)
            .build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
            .defaultDisplayImageOptions(defaultOptions)
            .build();
        ImageLoader.getInstance().init(config);
    }
}