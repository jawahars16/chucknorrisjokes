package com.chucknorrisjokes.di.component;

import com.chucknorrisjokes.di.module.ApplicationModule;
import com.chucknorrisjokes.di.module.FavoritesActivityModule;
import com.chucknorrisjokes.di.scopes.PerActivity;
import com.chucknorrisjokes.mvp.view.activities.FavoritesActivity;

import dagger.Component;

/**
 * Created by Jawahar on 1/21/2016.
 */
@PerActivity
@Component(modules = FavoritesActivityModule.class, dependencies = ApplicationComponent.class)
public interface FavoritesActivityComponent {
    void inject(FavoritesActivity activity);
}
