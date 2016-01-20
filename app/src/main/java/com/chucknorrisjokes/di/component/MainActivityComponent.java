package com.chucknorrisjokes.di.component;

import com.chucknorrisjokes.di.module.MainActivityModule;
import com.chucknorrisjokes.di.scopes.PerActivity;
import com.chucknorrisjokes.mvp.view.activities.MainActivity;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Subcomponent;

/**
 * Created by Jawahar on 1/20/2016.
 */
@PerActivity
@Component(modules = MainActivityModule.class, dependencies = ApplicationComponent.class)
public interface MainActivityComponent {

    void inject(MainActivity activity);
}
