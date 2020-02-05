package com.assignment.obvious.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.assignment.obvious.ObviousApplication;
import com.assignment.obvious.R;
import com.assignment.obvious.di.component.MainComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    //Reference to the Main graph
    MainComponent mainComponent;

    @Inject
    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Creation of the main graph using the application graph
        mainComponent = ((ObviousApplication) getApplicationContext())
                .appComponent.mainComponent().create();
    }
}
