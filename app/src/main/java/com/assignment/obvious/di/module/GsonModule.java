package com.assignment.obvious.di.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import dagger.Module;
import dagger.Provides;

@Module
public class GsonModule<T> {

    @Provides
    public Gson gson() {
        Gson gson = new GsonBuilder().create();
        return gson;
    }

    @Provides
    public Type type(T typeToken) {
        Type type = new TypeToken<T>(){}.getType();
        return type;
    }
}
