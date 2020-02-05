package com.assignment.obvious.di.component;

import com.assignment.obvious.di.module.ApplicationModule;
import com.assignment.obvious.di.module.ContextModule;
import com.assignment.obvious.di.module.GsonModule;
import com.assignment.obvious.ui.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, ContextModule.class, GsonModule.class})
public interface ApplicationComponent {

    //this function tells the Dagger that MainActivity wants to access the graph and
    //request injection. Dagger needs to satisfy the dependencies that MainActivity requires
    void inject(MainActivity mainActivity);
}
