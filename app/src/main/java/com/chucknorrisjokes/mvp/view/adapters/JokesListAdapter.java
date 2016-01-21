package com.chucknorrisjokes.mvp.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.chucknorrisjokes.R;
import com.chucknorrisjokes.mvp.model.Favorite;

import java.util.List;

/**
 * Created by Jawahar on 1/21/2016.
 */
public class JokesListAdapter extends BaseAdapter {

    private List<Favorite> favoriteJokes;
    private Context context;

    public JokesListAdapter(Context context, List<Favorite> favoriteJokes){
        this.favoriteJokes = favoriteJokes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return favoriteJokes.size();
    }

    @Override
    public Object getItem(int position) {
        return favoriteJokes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return favoriteJokes.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.joke_list_item, parent, false);
        }

        TextView jokeDisplay = (TextView)convertView.findViewById(R.id.jokeText);
        TextView jokeId = (TextView)convertView.findViewById(R.id.jokeId);

        Favorite favorite = favoriteJokes.get(position);
        jokeDisplay.setText(favorite.Joke);
        jokeId.setText(String.format("#%s", favorite.Id.toString()));
        return convertView;
    }
}
