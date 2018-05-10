package com.example.jngoogle.keionbu.adapter;

import android.content.Context;
import android.net.Uri;

import com.example.jngoogle.keionbu.R;
import com.example.jngoogle.keionbu.network.entity.SongMenuEntity;

/**
 * Created by Administrator on 2017/3/25.
 */

public class SonglistAdapter extends CommonRecyclerAdapter<SongMenuEntity.ContentBean> {

    private Context context;

    public SonglistAdapter(Context context, int resId) {
        super(context, resId);
        this.context = context;
    }

    @Override
    public void bindData(MyViewHolder holder, int position, SongMenuEntity.ContentBean itemData) {
        holder.setText(R.id.tv_title, itemData.getTitle());// 歌单简介
        holder.setText(R.id.amount_play, itemData.getListenum());// 歌单播放量
        holder.setImageUriGlide(R.id.songlist_image, Uri.parse(itemData.getPic_300()),
                R.mipmap.placeholder_disk_210);// 歌单封面图

    }
}

