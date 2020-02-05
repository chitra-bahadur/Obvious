package com.assignment.obvious.data.repository;

import android.content.Context;

import com.assignment.obvious.data.model.ImageData;
import com.google.gson.Gson;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;

public class Repository {

    Context context;
    Gson gson;
    Type type;

    @Inject
    public Repository(Context context, Gson gson, Type type) {
        this.context = context;
        this.gson = gson;
        this.type = type;
    }

    public String loadJSONFromAssets() {
        String json = null;
        try {
            InputStream is = context.getAssets().open("data.json");
            int size = is.available();
            byte[] bytes = new byte[size];
            is.read(bytes);
            is.close();
            json = new String(bytes, "UTF-8");
        } catch (Exception ae) {
            ae.printStackTrace();
            return null;
        }
        return json;
    }

    public List<ImageData> getData() {
        List<ImageData> imageDataList = null;
        try {
            imageDataList = gson.fromJson(loadJSONFromAssets(), type);
        } catch (Exception ae) {
            ae.printStackTrace();
        }

        return imageDataList;
    }
}
