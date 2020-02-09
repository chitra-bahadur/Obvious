package com.assignment.obvious.di.module;

import android.app.Application;
import android.content.Context;

import com.assignment.obvious.data.model.ImageData;
import com.assignment.obvious.ui.grid.ImageGridAdapter;
import com.assignment.obvious.ui.grid.ImageGridFragment;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private Application application;

    @Inject
    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application application() {
        return application;
    }

    @Provides
    public Context context() {
        return application;
    }

    @Provides
    public ImageGridFragment getImageGridFragment() {
        return new ImageGridFragment();
    }


}
