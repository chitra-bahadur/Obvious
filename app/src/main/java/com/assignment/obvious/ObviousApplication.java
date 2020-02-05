package com.assignment.obvious;

import android.app.Application;

import com.assignment.obvious.di.component.ApplicationComponent;
import com.assignment.obvious.di.component.DaggerApplicationComponent;
import com.assignment.obvious.di.module.ApplicationModule;


//app component lives in the application class to share its life cycle
public class ObviousApplication extends Application {

    public ApplicationComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        //Reference to the application graph that is used across the whole app
        appComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }
}
