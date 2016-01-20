package com.chucknorrisjokes.mvp.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.chucknorrisjokes.ChuckNorrisApplication;
import com.chucknorrisjokes.R;
import com.chucknorrisjokes.di.component.DaggerApplicationComponent;
import com.chucknorrisjokes.di.component.MainActivityComponent;
import com.chucknorrisjokes.di.module.MainActivityModule;
import com.chucknorrisjokes.mvp.presenter.MainPresenter;
import com.chucknorrisjokes.mvp.view.MainView;

import java.util.Objects;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainView {

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void setupDependencies() {
        ChuckNorrisApplication.
                    from(this).
                    getAppComponent().
                    plus(new MainActivityModule(this)).
                    inject(this);
    }
}
