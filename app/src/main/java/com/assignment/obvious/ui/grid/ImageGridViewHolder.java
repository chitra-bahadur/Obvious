package com.assignment.obvious.ui.grid;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.assignment.obvious.R;

public class ImageGridViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;

    public ImageGridViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.imageView);
    }
}
