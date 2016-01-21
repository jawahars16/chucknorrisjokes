package com.chucknorrisjokes.mvp.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Jawahar on 1/21/2016.
 */
@Table(name = "favorites")
public class Favorite extends Model {

    @Column(name = "local_id", unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    public Integer Id;

    @Column(name = "joke")
    public String Joke;

    public Favorite(){
        super();
    }

    public Favorite(Integer id, String joke){
        Id = id;
        Joke = joke;
    }
}
