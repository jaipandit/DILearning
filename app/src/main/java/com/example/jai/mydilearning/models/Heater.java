package com.example.jai.mydilearning.models;


import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by pandj009 on 11/3/16.
 *
 * Showing how to allow Dagger to create the Object using the constructor(and not the provides method
 * from the module. @Singleton retains the singleton behavior of this object.) Aka Constructor Injection.
 */

@Singleton
public class Heater {

    private static final String TAG = Heater.class.getSimpleName();

    private Water water;

    @Inject
    public Heater(Water water){
        Log.i(TAG, "Heater Constructor Called.");
        this.water = water;
    }

    public Water getHotWater(){
        return warm();
    }

    private Water warm(){
        return water;
    }
}
