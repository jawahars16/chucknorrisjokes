package com.chucknorrisjokes.di.module;

import com.chucknorrisjokes.mvp.presenter.MainPresenter;
import com.chucknorrisjokes.mvp.presenter.MainPresenterImpl;
import com.chucknorrisjokes.mvp.view.MainView;
import com.chucknorrisjokes.rest.RestService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jawahar on 1/20/2016.
 */
@Module
public class MainActivityModule {

    private MainView view;

    public MainActivityModule(MainView view){
        this.view = view;
    }

    @Provides
    public MainView provideView(){
        return view;
    }

    @Provides
    public MainPresenter providePresenter(RestService restService){
       return new MainPresenterImpl(view, restService);
    }
}
