package com.chucknorrisjokes.di.module;

import com.chucknorrisjokes.mvp.presenter.FavoritePresenterImpl;
import com.chucknorrisjokes.mvp.presenter.FavoritesPresenter;
import com.chucknorrisjokes.mvp.view.FavoritesView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jawahar on 1/21/2016.
 */
@Module
public class FavoritesActivityModule {
    private FavoritesView view;

    public FavoritesActivityModule(FavoritesView view){
        this.view = view;
    }

    @Provides
    public FavoritesPresenter providePresenter(){
        return new FavoritePresenterImpl(view);
    }

    @Provides
    public FavoritesView provideView(){
        return view;
    }
}
