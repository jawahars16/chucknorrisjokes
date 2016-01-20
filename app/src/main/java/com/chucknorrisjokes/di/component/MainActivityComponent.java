package com.chucknorrisjokes.di.component;

import com.chucknorrisjokes.di.module.MainActivityModule;
import com.chucknorrisjokes.mvp.view.activities.MainActivity;

import dagger.Component;
import dagger.Subcomponent;

/**
 * Created by Jawahar on 1/20/2016.
 */
@Subcomponent(modules = MainActivityModule.class)
public interface MainActivityComponent {

    void inject(MainActivity activity);
}
