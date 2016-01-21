package com.chucknorrisjokes.mvp.view.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.chucknorrisjokes.ChuckNorrisApplication;
import com.chucknorrisjokes.R;
import com.chucknorrisjokes.di.module.MainActivityModule;
import com.chucknorrisjokes.mvp.presenter.BasePresenter;

/**
 * Created by Jawahar on 1/20/2016.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected BasePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = setupDependencies();
        presenter.onCreate();
    }

    public void initializeDrawer(){
        Toolbar toolBar = getToolBar();
        final DrawerLayout drawerLayout = getDrawerLayout();
        setSupportActionBar(toolBar);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolBar, 0,0);
        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();

        getNavigationView().setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                drawerLayout.closeDrawer(GravityCompat.START);

                Intent intent = null;
                if (item.getItemId() == R.id.homeMenu) {
                    intent = new Intent(BaseActivity.this, MainActivity.class);
                } else if (item.getItemId() == R.id.favoritesMenu) {
                    intent = new Intent(BaseActivity.this, FavoritesActivity.class);
                }
                startActivity(intent);
                return false;
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    protected abstract BasePresenter setupDependencies();

    protected abstract Toolbar getToolBar();

    protected abstract DrawerLayout getDrawerLayout();

    protected abstract NavigationView getNavigationView();
}
