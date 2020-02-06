package com.assignment.obvious.ui.detail;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.assignment.obvious.ui.main.MainActivity;
import com.assignment.obvious.ui.main.MainViewModel;

import javax.inject.Inject;

//image with details will be implemented in this fragment
public class ImageDetailsFragment extends Fragment {

    @Inject
    MainViewModel mainViewModel;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        ((MainActivity) getActivity()).mainComponent.inject((MainActivity) getActivity());
    }
}
