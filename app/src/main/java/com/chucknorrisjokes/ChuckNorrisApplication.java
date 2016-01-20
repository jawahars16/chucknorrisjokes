package com.chucknorrisjokes;

import android.app.Application;
import android.content.Context;

import com.chucknorrisjokes.di.component.ApplicationComponent;
import com.chucknorrisjokes.di.component.DaggerApplicationComponent;
import com.chucknorrisjokes.di.module.ApplicationModule;

/**
 * Created by Jawahar on 1/20/2016.
 */
public class ChuckNorrisApplication extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        initialize();
    }

    public ApplicationComponent getAppComponent(){
        return component;
    }

    public void initialize(){
        component = DaggerApplicationComponent.
                    builder().
                    applicationModule(new ApplicationModule(this)).
                    build();
    }

    public static ChuckNorrisApplication from(Context context){
        return (ChuckNorrisApplication)context.getApplicationContext();
    }
}
