package com.assignment.obvious.ui.main;


import com.assignment.obvious.data.repository.Repository;

import javax.inject.Inject;

public class MainViewModel{

    private final Repository repository;

    @Inject
    public MainViewModel(Repository repository) {
        this.repository = repository;
    }
}
