package com.example.jai.mydilearning.di;

import android.app.Application;

import com.example.jai.mydilearning.models.CoffeeMaker;
import com.example.jai.mydilearning.models.CoffeeMakerImpl;
import com.example.jai.mydilearning.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by pandj009 on 11/3/16.
 *
 * You will interact wil the methods in this interface, Generally you'd interact with inject method
 * to fulfill the field dependencies of the classes. See inject methods in this class.
 */
@Singleton
@Component(modules = {MyModule.class})
public interface Injector {

    /**
     * This method will inject all the field dependencies of the {@link CoffeeMaker} class.
     * This method has to be called manually.
     * @param coffeeMaker
     */
    void inject(CoffeeMakerImpl coffeeMaker);

    /**
     * This method will inject all the dependencies in the {@link MainActivity} class.
     * This method has to be called manually.
     * @param activity
     */
    void inject(MainActivity activity);

    final class Initializer{

        public static Injector init(final Application app){
            // DaggerInjector is created by Dagger code generator automatically.
            return DaggerInjector.builder()
                    // Register our module in this component.
                    .myModule(new MyModule(app))
                    .build();
        }
    }
}
