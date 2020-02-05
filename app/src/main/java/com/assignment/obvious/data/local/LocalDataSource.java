package com.assignment.obvious.data.local;

import android.content.Context;

import com.assignment.obvious.data.model.ImageData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class LocalDataSource {

    Context context;
    Gson gson;
    Type type;
    List<ImageData> imageDataList;

    @Inject
    public LocalDataSource(Context context, Gson gson, Type type,
                           List<ImageData> imageDataList) {
        this.context = context;
        this.gson = gson;
        this.type = type;
        this.imageDataList = imageDataList;
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
        try {
            imageDataList = gson.fromJson(loadJSONFromAssets(), type);
        } catch (Exception ae) {
            ae.printStackTrace();
        }

        return imageDataList;
    }
}
