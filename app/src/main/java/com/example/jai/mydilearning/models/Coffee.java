package com.example.jai.mydilearning.models;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by pandj009 on 11/3/16.
 *
 * Dagger will use this constructor to create Coffee Object whenever it needs to make a object of
 * {@link Coffee}
 */

@Singleton
public class Coffee {

    private static final String TAG = Coffee.class.getSimpleName();

    @Inject
    public Coffee(){
        Log.i(TAG, "Coffee Constructor called");
    }
}
