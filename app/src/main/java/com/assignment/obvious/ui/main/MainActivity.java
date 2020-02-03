package com.assignment.obvious.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.assignment.obvious.ObviousApplication;
import com.assignment.obvious.R;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    //dagger will provide an instance of MainViewModel from the graph
    @Inject
    MainViewModel mMainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Make Dagger instantiate @Inject fields in MainActivity
        ((ObviousApplication) getApplicationContext()).appComponent.inject(this);
        //Now MainViewModel is available

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
