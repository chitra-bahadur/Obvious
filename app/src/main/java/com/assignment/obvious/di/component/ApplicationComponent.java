package com.assignment.obvious.di.component;

import android.content.Context;

import com.assignment.obvious.data.model.ImageData;
import com.assignment.obvious.di.module.ApplicationModule;
import com.assignment.obvious.di.module.GsonModule;
import com.assignment.obvious.di.module.SubComponentModule;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import dagger.Component;

@Component(modules = {ApplicationModule.class, SubComponentModule.class, GsonModule.class})
public interface ApplicationComponent {

    // This function exposes the MainComponent Factory out of the graph so consumers
    // can use it to obtain new instances of MainComponent
    MainComponent.Factory mainComponent();

    void inject(Gson gson);

    void inject(Context context);

    void inject(List<ImageData> imageDataList);

    void inject(Type type);

    void inject(ImageData imageData);
}
