package com.assignment.obvious.ui.grid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.assignment.obvious.R;
import com.assignment.obvious.data.model.ImageData;
import com.assignment.obvious.ui.main.MainActivity;
import com.assignment.obvious.ui.main.MainViewModel;

import java.util.List;

import javax.inject.Inject;

//we will show images in grid using this fragment.
public class ImageGridFragment extends Fragment {

    @Inject
    MainViewModel mViewModel;


    RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grid, container, false);
        mRecyclerView = view.findViewById(R.id.gridRecyclerView);
       return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ((MainActivity) getActivity()).mainComponent.inject(this);
        mViewModel.getImageDataList().observe(getActivity(), new Observer<List<ImageData>>() {
            @Override
            public void onChanged(List<ImageData> imageDataList) {
                ImageGridAdapter adapter = new ImageGridAdapter(imageDataList);
                GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
                //RecyclerView.ItemDecoration decoration = new DividerItemDecoration(getContext(), LinearLayout.VERTICAL);
                mRecyclerView.setLayoutManager(manager);
                //mRecyclerView.addItemDecoration(decoration);
                mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                mRecyclerView.setAdapter(adapter);
            }
        });
    }
}
