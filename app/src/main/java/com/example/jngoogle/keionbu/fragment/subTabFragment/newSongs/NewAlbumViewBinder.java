package com.example.jngoogle.keionbu.fragment.subTabFragment.newSongs;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jngoogle.keionbu.R;
import com.example.jngoogle.keionbu.util.ActivitiesUtil;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by jngoogle on 2017/10/17.
 */
public class NewAlbumViewBinder extends ItemViewBinder<NewAlbum, NewAlbumViewBinder.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(
            @NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_new_album, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull NewAlbum newAlbum) {
        holder.bind(newAlbum);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView coverIv;
        TextView titleTv;
        TextView authorTv;

        ViewHolder(View itemView) {
            super(itemView);
            coverIv = (ImageView) itemView.findViewById(R.id.iv_cover);
            titleTv = (TextView) itemView.findViewById(R.id.tv_title);
            authorTv = (TextView) itemView.findViewById(R.id.tv_author);
        }

        public void bind(NewAlbum newAlbum) {
            Glide.with(ActivitiesUtil.getActivity(coverIv))
                    .load(newAlbum.coverUri)
                    .into(coverIv);

            titleTv.setText(newAlbum.title);
            authorTv.setText(newAlbum.author);
        }
    }
}
