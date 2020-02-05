package com.assignment.obvious.di.module;

import com.assignment.obvious.data.model.ImageData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class GsonModule {

    @Provides
    public Gson gson() {
        Gson gson = new GsonBuilder().create();
        return gson;
    }

    @Provides
    public Type type() {
        Type type = new TypeToken<List<ImageData>>(){}.getType();
        return type;
    }
}
