package com.example.jai.mydilearning.preferences;

import android.app.Application;

import com.example.jai.mydilearning.di.Injector;

/**
 * Created by pandj009 on 11/3/16.
 */

public class MyApplication extends Application {

    private Injector injector;

    public void onCreate(){
        super.onCreate();
        injector = Injector.Initializer.init(this);
    }

    public Injector getInjector(){
        return injector;
    }
}
