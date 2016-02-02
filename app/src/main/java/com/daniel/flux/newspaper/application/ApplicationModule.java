package com.daniel.flux.newspaper.application;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;

import com.daniel.flux.newspaper.action.CategoryActivityActionCreator;
import com.daniel.flux.newspaper.action.NewsDetailActivityActionCreator;
import com.daniel.flux.newspaper.dispatcher.Dispatcher;
import com.daniel.flux.newspaper.store.NewsStore;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by danielnguyen on 1/11/16.
 */
@Module
public class ApplicationModule {
    private final MyApplication application;
    private final Bus bus;
    private final Dispatcher dispatcher;

    private final CategoryActivityActionCreator categoryActivityActionCreator;
    private final NewsDetailActivityActionCreator newsDetailActivityActionCreator;

    private final NewsStore newsStore;

    public ApplicationModule(MyApplication application) {
        this.application = application;
        this.bus = new Bus();
        this.dispatcher = new Dispatcher(this.bus);

        this.categoryActivityActionCreator = new CategoryActivityActionCreator(this.application, this.dispatcher);
        this.newsDetailActivityActionCreator = new NewsDetailActivityActionCreator(this.application, this.dispatcher);

        this.newsStore = new NewsStore(this.dispatcher, this.application.getApplicationContext());
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return this.application;
    }

    @Provides
    @Singleton
    SharedPreferences providePreferenceManager() {
        return PreferenceManager.getDefaultSharedPreferences(this.application);
    }

    @Provides
    @Singleton
    Resources provideResources() {
        return this.application.getResources();
    }

    @Provides
    @Singleton
    Bus provideBus() {
        return this.bus;
    }

    @Provides
    @Singleton
    Dispatcher provideDispatcher() {
        return this.dispatcher;
    }

    @Provides
    @Singleton
    CategoryActivityActionCreator provideCategoryActivityActionCreator() {
        return this.categoryActivityActionCreator;
    }

    @Provides
    @Singleton
    NewsDetailActivityActionCreator provideNewsDetailActionCreator() {
        return this.newsDetailActivityActionCreator;
    }

    @Provides
    @Singleton
    NewsStore provideNewsStore() {
        return this.newsStore;
    }
}