package com.assignment.obvious.ui.grid;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.assignment.obvious.R;
import com.assignment.obvious.data.model.ImageData;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.target.Target;

import java.util.List;

import javax.inject.Inject;

public class ImageGridAdapter extends RecyclerView.Adapter<ImageGridViewHolder> {

    List<ImageData> mImageDataList;

    @Inject
    public  ImageGridAdapter(List<ImageData> imageDataList) {
        mImageDataList = imageDataList;
    }


    @NonNull
    @Override
    public ImageGridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_grid_lv_items, parent, false);
        return new ImageGridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ImageGridViewHolder holder, int position) {

        RequestOptions requestOptions = new RequestOptions();

        requestOptions = requestOptions.transform(new CenterInside(), new RoundedCorners(16));
        requestOptions.override(100 * 100);
        requestOptions.downsample(DownsampleStrategy.CENTER_INSIDE);
        Glide.with(holder.itemView.getContext())
                .load(mImageDataList.get(position).getHdurl())
                .override(100 * 100)
                .placeholder(R.mipmap.ic_launcher)
                //.transition(DrawableTransitionOptions.withCrossFade())
                .apply(requestOptions)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mImageDataList.size();
    }

}
