package com.chucknorrisjokes.mvp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

/**
 * Created by XAML on 20-01-2016.
 */
@Generated("org.jsonschema2pojo")
public class Value {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("joke")
    @Expose
    private String joke;

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The joke
     */
    public String getJoke() {
        return joke;
    }

    /**
     *
     * @param joke
     * The joke
     */
    public void setJoke(String joke) {
        this.joke = joke;
    }

}
