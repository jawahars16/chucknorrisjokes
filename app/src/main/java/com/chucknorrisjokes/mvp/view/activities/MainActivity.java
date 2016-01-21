package com.chucknorrisjokes.mvp.view.activities;

import android.app.ProgressDialog;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.chucknorrisjokes.ChuckNorrisApplication;
import com.chucknorrisjokes.R;
import com.chucknorrisjokes.di.component.DaggerApplicationComponent;
import com.chucknorrisjokes.di.component.DaggerMainActivityComponent;
import com.chucknorrisjokes.di.component.MainActivityComponent;
import com.chucknorrisjokes.di.module.MainActivityModule;
import com.chucknorrisjokes.mvp.presenter.BasePresenter;
import com.chucknorrisjokes.mvp.presenter.MainPresenter;
import com.chucknorrisjokes.mvp.view.MainView;

import java.util.Objects;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainView {

    @Inject
    MainPresenter mainPresenter;
    @Bind(R.id.displayText)
    TextView displayText;
    @Bind(R.id.jokeId)
    TextView jokeId;
    @Bind(R.id.progressBar)
    ProgressBar progress;

    @Bind(R.id.toolBar)
    Toolbar toolBar;
    @Bind(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @Bind(R.id.drawerPane)
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainPresenter.getRandomJoke();
        super.initializeDrawer();
    }

    @OnClick(R.id.randomButton)
    public void onClickRandomButton(){
        displayText.setText("");
        jokeId.setText("");
        mainPresenter.getRandomJoke();
    }

    @Override
    protected BasePresenter setupDependencies() {
        DaggerMainActivityComponent.builder()
                .applicationComponent(ChuckNorrisApplication.from(this).getAppComponent())
                .mainActivityModule(new MainActivityModule(this))
                .build().inject(this);
        return mainPresenter;
    }

    @Override
    protected Toolbar getToolBar() {
        return toolBar;
    }

    @Override
    protected DrawerLayout getDrawerLayout() {
        return drawerLayout;
    }

    @Override
    protected NavigationView getNavigationView() {
        return navigationView;
    }

    @Override
    public void displayJoke(String joke, String id) {
        displayText.setText(joke);
        jokeId.setText(id);
    }

    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        if(progress != null){
            progress.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.favoriteButton)
    public void favoriteJoke(){
        mainPresenter.favoriteJoke();
    }
}
