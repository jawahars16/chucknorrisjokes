package com.chucknorrisjokes.di.component;

import android.app.Application;

import com.chucknorrisjokes.di.module.ApplicationModule;
import com.chucknorrisjokes.di.module.MainActivityModule;
import com.chucknorrisjokes.rest.RestService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Jawahar on 1/20/2016.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    RestService getRestService();
    Application getApplication();
}
