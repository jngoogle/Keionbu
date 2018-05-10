package com.example.jngoogle.keionbu.adapter;

import android.content.Context;
import android.view.View;

import com.example.jngoogle.keionbu.R;
import com.example.jngoogle.keionbu.network.entity.SongsInSongListEntity;

/**
 * Created by jngoogle on 2017/5/18.
 * Email: jammicnicoole@gmail.com
 */

public class SongInSonglistAdapter extends CommonRecyclerAdapter<SongsInSongListEntity.ContentBean> {

    public SongInSonglistAdapter(Context mContext, int mItemLayoutId) {
        super(mContext, mItemLayoutId);
    }

    @Override
    public void bindData(MyViewHolder holder, int position, SongsInSongListEntity.ContentBean itemData) {
        holder.setText(R.id.tv_song_number, (position + 1) + "");// 歌曲的流水号
        holder.setText(R.id.tv_song_title, itemData.getTitle());
        holder.setText(R.id.tv_author, itemData.getAuthor());
        if (itemData.getAlbum_title() != null) {
            holder.setText(R.id.tv_album_title, " - " + itemData.getAlbum_title());
        } else {
            holder.getView(R.id.tv_album_title).setVisibility(View.GONE);
        }

        holder.getView(R.id.ib_song_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
