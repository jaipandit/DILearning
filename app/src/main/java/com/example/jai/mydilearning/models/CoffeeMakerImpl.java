package com.example.jai.mydilearning.models;

import android.content.Context;
import android.util.Log;

import com.example.jai.mydilearning.preferences.MyApplication;

import javax.inject.Inject;

/**
 * Created by pandj009 on 11/3/16.
 *
 * This class is showing how the field injection is setup, and the object of this class
 * will be provided by provides method in the module(it will also show how the parameterized constructor
 * is invoked by Dagger. please see MyModule.)
 *
 * Notice, how this object will be created first with the provides method and in the constructor inject the
 * fields by writing the first line in the constructor.
 */

public class CoffeeMakerImpl implements CoffeeMaker {

    private static final String TAG = CoffeeMakerImpl.class.getSimpleName();

    // This field cannot be private, As dagger cannot inject the private fields.
    @Inject
    Heater heater;

    @Inject
    Brewer brewer;

    private Coffee coffee;

    public CoffeeMakerImpl(Context context, Coffee coffee){
        Log.i(TAG, "CoffeeMakerImpl Constructor called.");
        ((MyApplication)context).getInjector().inject(this);
        this.coffee = coffee;
    }

    @Override
    public Coffee getCoffee() {
        return new Coffee();
    }

    @Override
    public Heater getHeater() {
        return heater;
    }

    @Override
    public Brewer getBrewer() {
        return brewer;
    }
}
