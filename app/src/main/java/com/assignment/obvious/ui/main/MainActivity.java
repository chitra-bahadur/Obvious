package com.assignment.obvious.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.assignment.obvious.ObviousApplication;
import com.assignment.obvious.R;
import com.assignment.obvious.di.component.MainComponent;
import com.assignment.obvious.ui.grid.ImageGridFragment;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    //Reference to the Main graph
    public MainComponent mainComponent;

    @Inject
    MainViewModel mainViewModel;

    @Inject
    ImageGridFragment mGridFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Creation of the main graph using the application graph
        mainComponent = ((ObviousApplication) getApplicationContext())
                .appComponent.mainComponent().create();

        mainComponent.inject(this);

        setContentView(R.layout.activity_main);

        loadGridFragment();

    }

    private void loadGridFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.container, mGridFragment);
        ft.commitNow();
    }
}
