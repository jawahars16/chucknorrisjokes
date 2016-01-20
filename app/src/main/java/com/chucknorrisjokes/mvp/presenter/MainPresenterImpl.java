package com.chucknorrisjokes.mvp.presenter;

import com.chucknorrisjokes.mvp.view.MainView;

/**
 * Created by Jawahar on 1/20/2016.
 */
public class MainPresenterImpl implements MainPresenter {

    private MainView mainView;

    public MainPresenterImpl(MainView mainView){
        this.mainView = mainView;
    }

    @Override
    public void onCreate() {

    }
}
