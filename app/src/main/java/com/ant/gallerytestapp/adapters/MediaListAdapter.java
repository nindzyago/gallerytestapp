package com.ant.gallerytestapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ant.gallerytestapp.R;
import com.ant.gallerytestapp.models.Photo;
import com.ant.gallerytestapp.models.Photos;
import com.ant.gallerytestapp.util.Consts;
import com.squareup.picasso.Picasso;

/**
 * Created by mihailantipev on 30.01.18.
 */

public class MediaListAdapter extends RecyclerView.Adapter<MediaListAdapter.MediaListHolder> {

    private static final int LAYOUT = R.layout.item_media;
    private Context context;
    private Photos photos;

    public MediaListAdapter(Context context, Photos photos) {
        this.context = context;
        this.photos = photos;
    }

    @Override
    public MediaListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(LAYOUT, parent, false);
        return new MediaListAdapter.MediaListHolder(view);
    }

    @Override
    public void onBindViewHolder(MediaListHolder holder, int position) {
        Picasso.with(context)
                .load(photos.get(position).toString())
                .resize(Consts.PHOTO_SIZE, Consts.PHOTO_SIZE)
                .into(holder.ivPhoto);
        holder.ivPhoto.setOnClickListener(v -> onClickPhoto(position));
    }

    private void onClickPhoto(int position) {
        //TODO: Implement method
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
        notifyDataSetChanged();
    }

    public void addPhoto(Photo photo) {
        photos.add(photo);
        notifyDataSetChanged();
    }

    static class MediaListHolder extends RecyclerView.ViewHolder {
        ImageView ivPhoto;

        MediaListHolder(View itemView) {
            super(itemView);
            ivPhoto = itemView.findViewById(R.id.ivPhoto);
        }
    }

}
