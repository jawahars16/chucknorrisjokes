package com.chucknorrisjokes.mvp.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chucknorrisjokes.ChuckNorrisApplication;
import com.chucknorrisjokes.R;
import com.chucknorrisjokes.di.component.DaggerApplicationComponent;
import com.chucknorrisjokes.di.component.DaggerMainActivityComponent;
import com.chucknorrisjokes.di.component.MainActivityComponent;
import com.chucknorrisjokes.di.module.MainActivityModule;
import com.chucknorrisjokes.mvp.presenter.MainPresenter;
import com.chucknorrisjokes.mvp.view.MainView;

import java.util.Objects;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainView {

    @Inject
    MainPresenter mainPresenter;
    TextView displayText;
    TextView jokeId;
    Button randomJokeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayText = (TextView)findViewById(R.id.displayText);
        jokeId = (TextView)findViewById(R.id.jokeId);
        randomJokeButton = (Button)findViewById(R.id.randomButton);
        randomJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.getRandomJoke();
            }
        });
        mainPresenter.getRandomJoke();
    }

    @Override
    protected void setupDependencies() {
        DaggerMainActivityComponent.builder()
                .applicationComponent(ChuckNorrisApplication.from(this).getAppComponent())
                .mainActivityModule(new MainActivityModule(this))
                .build().inject(this);
    }

    @Override
    public void displayJoke(String joke, String id) {
        displayText.setText(joke);
        jokeId.setText(id);
    }
}
