package com.chucknorrisjokes.mvp.presenter;

import com.activeandroid.query.Select;
import com.chucknorrisjokes.mvp.model.Favorite;
import com.chucknorrisjokes.mvp.view.FavoritesView;

import java.util.List;

/**
 * Created by Jawahar on 1/21/2016.
 */
public class FavoritePresenterImpl implements FavoritesPresenter {

    private FavoritesView view;

    public FavoritePresenterImpl(FavoritesView view){
        this.view = view;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void getFavorites() {
        List<Favorite> favoriteJokes = new Select()
                .from(Favorite.class)
                .execute();
        view.showFavorites(favoriteJokes);
    }
}
