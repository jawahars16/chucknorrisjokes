package com.chucknorrisjokes.mvp.view.activities;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.chucknorrisjokes.ChuckNorrisApplication;
import com.chucknorrisjokes.di.module.MainActivityModule;

/**
 * Created by Jawahar on 1/20/2016.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        setupDependencies();
    }

    protected abstract void setupDependencies();
}
