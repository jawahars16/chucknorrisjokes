package com.chucknorrisjokes.mvp.model;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

/**
 * Created by XAML on 20-01-2016.
 */
@Generated("org.jsonschema2pojo")
public class Joke {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("value")
    @Expose
    private Value value;

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The value
     */
    public Value getValue() {
        return value;
    }

    /**
     *
     * @param value
     * The value
     */
    public void setValue(Value value) {
        this.value = value;
    }

}
