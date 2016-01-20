package com.chucknorrisjokes.di.component;

import com.chucknorrisjokes.di.module.ApplicationModule;
import com.chucknorrisjokes.di.module.MainActivityModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Jawahar on 1/20/2016.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    MainActivityComponent plus(MainActivityModule module);
}
