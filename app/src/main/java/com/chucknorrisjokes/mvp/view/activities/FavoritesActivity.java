package com.chucknorrisjokes.mvp.view.activities;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.chucknorrisjokes.ChuckNorrisApplication;
import com.chucknorrisjokes.R;
import com.chucknorrisjokes.di.component.DaggerFavoritesActivityComponent;
import com.chucknorrisjokes.di.component.FavoritesActivityComponent;
import com.chucknorrisjokes.di.module.FavoritesActivityModule;
import com.chucknorrisjokes.mvp.model.Favorite;
import com.chucknorrisjokes.mvp.presenter.BasePresenter;
import com.chucknorrisjokes.mvp.presenter.FavoritesPresenter;
import com.chucknorrisjokes.mvp.view.FavoritesView;
import com.chucknorrisjokes.mvp.view.adapters.JokesListAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FavoritesActivity extends BaseActivity implements FavoritesView {

    @Inject
    FavoritesPresenter presenter;
    @Bind(R.id.favoritesList)
    ListView favoritesList;

    @Bind(R.id.toolBar)
    Toolbar toolBar;
    @Bind(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @Bind(R.id.drawerPane)
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        ButterKnife.bind(this);
        presenter.getFavorites();
        super.initializeDrawer();
    }

    @Override
    protected BasePresenter setupDependencies() {
        DaggerFavoritesActivityComponent.builder()
                .applicationComponent(ChuckNorrisApplication.from(this).getAppComponent())
                .favoritesActivityModule(new FavoritesActivityModule(this))
                .build()
                .inject(this);
        return presenter;
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

    public void showFavorites(List<Favorite> favorites){
        JokesListAdapter adapter = new JokesListAdapter(this, favorites);
        favoritesList.setAdapter(adapter);
    }
}
