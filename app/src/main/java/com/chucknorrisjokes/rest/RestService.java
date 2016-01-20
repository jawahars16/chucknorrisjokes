package com.chucknorrisjokes.rest;

import com.chucknorrisjokes.mvp.model.Joke;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by Jawahar on 1/20/2016.
 */
public interface RestService {

    @GET("/jokes/random")
    Call<Joke> getRandomJoke();
}
