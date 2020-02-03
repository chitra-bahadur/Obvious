package com.assignment.obvious.di.component;

import com.assignment.obvious.ui.main.MainActivity;

import dagger.Component;

@Component
public interface ApplicationComponent {

    //this function tells the Dagger that MainActivity wants to access the graph and
    //request injection. Dagger needs to satisfy the dependencies that MainActivity requires
    void inject(MainActivity mainActivity);
}
