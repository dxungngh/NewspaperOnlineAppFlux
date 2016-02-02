package com.daniel.flux.newspaper.application;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.res.Resources;

import com.daniel.flux.newspaper.action.CategoryActivityActionCreator;
import com.daniel.flux.newspaper.action.NewsDetailActivityActionCreator;
import com.daniel.flux.newspaper.dispatcher.Dispatcher;
import com.daniel.flux.newspaper.store.NewsStore;
import com.daniel.flux.newspaper.view.activity.BaseActivity;
import com.daniel.flux.newspaper.view.adapter.CategoriesListAdapter;
import com.daniel.flux.newspaper.view.adapter.NewsListAdapter;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by danielnguyen on 1/12/16.
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    public final static class Initializer {
        public static ApplicationComponent init(MyApplication app) {
            return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(app))
                .build();
        }

    }

    void inject(MyApplication application);

    void inject(BaseActivity activity);

    void inject(CategoriesListAdapter categoriesListAdapter);

    void inject(NewsListAdapter newsListAdapter);

    // Exported for child-components.
    Application provideApplication();

    SharedPreferences provideSharedPreferences();

    Resources provideResources();

    Bus provideBus();

    Dispatcher provideDispatcher();

    CategoryActivityActionCreator provideCategoryActivityActionCreator();

    NewsDetailActivityActionCreator provideNewsDetailActionCreator();

    NewsStore provideNewsStore();
}
