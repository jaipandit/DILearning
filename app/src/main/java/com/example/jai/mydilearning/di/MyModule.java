package com.example.jai.mydilearning.di;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.example.jai.mydilearning.models.Brewer;
import com.example.jai.mydilearning.models.Coffee;
import com.example.jai.mydilearning.models.CoffeeMaker;
import com.example.jai.mydilearning.models.CoffeeMakerImpl;
import com.example.jai.mydilearning.models.Water;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pandj009 on 11/3/16.
 *
 * The methods in the the Module classes are for Dagger to call automatically within from the generated code.
 * We would never call this method by ourselves.
 *
 * Remember: All classes whose objects are to be created by Dagger by specifying (@Inject) on the constructor,
 * their parameters should also be auto creatable, i.e the types should have a providesType() method or
 * have a @Inject annoted constructor(and if it has dependency, it goes more deep.)
 */

@Module
public class MyModule {

    private static final String TAG = MyModule.class.getSimpleName();

    private Context appContext;

    public MyModule(Application app){
        appContext = app;
    }

    @Provides
    public Context providesContext(){
        Log.i(TAG, "providesContext() is called");
        return appContext;
    }

    @Provides
    @Singleton
    public Water providesWater(){
        Log.i(TAG, "providesWater() is called.");
        return new Water();
    }

    @Provides
    @Singleton
    public Brewer providesBrewer(){
        Log.i(TAG, "providesBrewer() is called.");
        return new Brewer();
    }

    @Provides
    @Singleton
    public CoffeeMaker providesCoffeeMaker(Context appContext, Coffee coffee){
        Log.i(TAG, "providesCoffeeMaker() is called.");
        return new CoffeeMakerImpl(appContext, coffee);
    }
}
