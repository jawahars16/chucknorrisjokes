package com.chucknorrisjokes.mvp.presenter;

import com.chucknorrisjokes.rest.RestService;

import javax.inject.Inject;

/**
 * Created by Jawahar on 1/20/2016.
 */
public interface MainPresenter extends BasePresenter {
    void favoriteJoke();
    void getRandomJoke();
}
