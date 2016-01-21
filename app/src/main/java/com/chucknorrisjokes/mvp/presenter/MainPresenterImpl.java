package com.chucknorrisjokes.mvp.presenter;

import android.os.Debug;

import com.chucknorrisjokes.mvp.model.Favorite;
import com.chucknorrisjokes.mvp.model.Joke;
import com.chucknorrisjokes.mvp.model.Value;
import com.chucknorrisjokes.mvp.view.MainView;
import com.chucknorrisjokes.rest.RestService;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


/**
 * Created by Jawahar on 1/20/2016.
 */
public class MainPresenterImpl implements MainPresenter {

    private RestService restServie;
    private MainView mainView;
    private Value randomJoke;

    public MainPresenterImpl(MainView mainView, RestService restService){
        this.mainView = mainView;
        this.restServie = restService;
    }

    @Override
    public void favoriteJoke() {
        if(randomJoke != null){
            Favorite favorite = new Favorite(randomJoke.getId(), randomJoke.getJoke());
            favorite.save();
        }
    }

    @Override
    public void getRandomJoke() {
        mainView.showProgress();
        Call<Joke> call = restServie.getRandomJoke();
        call.enqueue(new Callback<Joke>() {
            @Override
            public void onResponse(Response<Joke> response, Retrofit retrofit) {
                mainView.hideProgress();
                randomJoke = response.body().getValue();
                mainView.displayJoke(randomJoke.getJoke(), String.format("#%s", randomJoke.getId().toString()));
            }

            @Override
            public void onFailure(Throwable t) {
                mainView.displayJoke(t.getMessage(), "");
                mainView.hideProgress();
                randomJoke = null;
            }
        });
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {
        randomJoke = null;
    }
}
