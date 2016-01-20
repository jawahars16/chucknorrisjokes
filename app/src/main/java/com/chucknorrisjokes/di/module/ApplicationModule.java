package com.chucknorrisjokes.di.module;

import android.app.Application;

import com.chucknorrisjokes.di.component.MainActivityComponent;
import com.chucknorrisjokes.mvp.presenter.MainPresenter;
import com.chucknorrisjokes.mvp.presenter.MainPresenterImpl;
import com.chucknorrisjokes.mvp.view.MainView;
import com.chucknorrisjokes.rest.RestService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import retrofit.CallAdapter;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by Jawahar on 1/20/2016.
 */
@Module
public class ApplicationModule {

    Application application;

    public ApplicationModule(Application application){
        this.application = application;
    }

    @Provides
    public RestService provideRestService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.icndb.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(RestService.class);
    }

    @Provides
    public Application provideApplicationContext(){
        return  application;
    }
}
