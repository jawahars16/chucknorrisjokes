package com.chucknorrisjokes.mvp.view;

import com.chucknorrisjokes.mvp.model.Favorite;

import java.util.List;

/**
 * Created by Jawahar on 1/21/2016.
 */
public interface FavoritesView {
    void showFavorites(List<Favorite> favorites);
}
