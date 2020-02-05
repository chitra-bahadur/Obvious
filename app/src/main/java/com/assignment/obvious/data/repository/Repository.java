package com.assignment.obvious.data.repository;

import com.assignment.obvious.data.local.LocalDataSource;

import java.time.LocalDate;

import javax.inject.Inject;

public class Repository {

    private LocalDataSource localDataSource;

    @Inject
    public Repository(LocalDataSource localDataSource) {
        this.localDataSource = localDataSource;
    }
}
