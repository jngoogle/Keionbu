package com.example.jngoogle.keionbu.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jngoogle.keionbu.R;
import com.example.jngoogle.keionbu.network.entity.SongMenuEntity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Retrofit;

/**
 * Created by Administrator on 2017/3/25.
 */

public class SonglistAdapter extends CommonRecyclerAdapter<SongMenuEntity.ContentBean> {

    public SonglistAdapter(Context context, int resId) {
        super(context, resId);
    }

    @Override
    public void bindData(MyViewHolder holder, int position, SongMenuEntity.ContentBean itemData) {
        holder.setText(R.id.tv_title, itemData.getTitle());// 歌单简介
        holder.setText(R.id.amount_play, itemData.getListenum());// 歌单播放量
        holder.setImageUri(R.id.songlist_image, Uri.parse(itemData.getPic_300()));// 歌单封面图
    }
}

