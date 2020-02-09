package com.assignment.obvious.ui.main;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.assignment.obvious.data.model.ImageData;
import com.assignment.obvious.data.repository.Repository;
import com.assignment.obvious.ui.grid.ImageGridAdapter;

import java.util.List;

import javax.inject.Inject;

public class MainViewModel extends ViewModel {

    private final Repository repository;

    @Inject
    public MainViewModel(Repository repository) {
        this.repository = repository;
    }


    public LiveData<List<ImageData>> getImageDataList() {
        MutableLiveData<List<ImageData>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(repository.getData());
        return mutableLiveData;
    }
 }
