package com.example.jngoogle.keionbu.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.jngoogle.keionbu.R;
import com.example.jngoogle.keionbu.adapter.CommonRecyclerAdapter;
import com.example.jngoogle.keionbu.adapter.HeaderAdapterWrapper;
import com.example.jngoogle.keionbu.adapter.HeaderFooterAdapterWrapper;
import com.example.jngoogle.keionbu.adapter.SongInSonglistAdapter;
import com.example.jngoogle.keionbu.customView.MarqueeTextview;
import com.example.jngoogle.keionbu.network.entity.SongsInSongListEntity;
import com.example.jngoogle.keionbu.network.serviceManger.ServiceManger;
import com.example.jngoogle.keionbu.util.Const;
import com.example.jngoogle.keionbu.util.DividerItemDecoration;
import com.example.jngoogle.keionbu.util.MySubscriber;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 歌单详情页
 */
public class SonglistDetailActivity extends BaseActivity {

    private static String methodPara = Const.methodSongsInSongListPara;
    private Context context;
    @BindView(R.id.toolbar_songlist_detail)
    Toolbar toolbar;
    @BindView(R.id.dv_songlist_pic)
    ImageView songlistPic;
    @BindView(R.id.tv_songlist_title)
    MarqueeTextview songlistTitleTv;
    @BindView(R.id.tv_songlist_tag)
    TextView songlistTagTv;
    @BindView(R.id.rv_songs_songlist)
    RecyclerView songsInSonglistRv;
    @BindView(R.id.collapsingToolbarLay)
    CollapsingToolbarLayout collapsingToolbarLayout;

    private TextView songlistCountTv;
    private SongInSonglistAdapter songInSonglistAdapter;
    private HeaderFooterAdapterWrapper adapterWrapper;
    private HeaderAdapterWrapper headerAdapterWrapper;
    private String listid;// 歌单id
    private String songlistTitle;// 歌单标题
    private String songlistPicUrl;// 歌单封面图
    private String songlistTag;// 歌单tag

    @OnClick({R.id.ib_back, R.id.dv_songlist_pic})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_back:
                finish();
                break;

            case R.id.dv_songlist_pic:// 跳转至歌单介绍页
                Intent listidIntent = new Intent();
                listidIntent.putExtra("listid", listid);
                listidIntent.setClass(SonglistDetailActivity.this, SonglistIntroActivity.class);
                startActivity(listidIntent);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songlist_detail);
        ButterKnife.bind(this);
        context = SonglistDetailActivity.this;
        setSupportActionBar(toolbar);
        songlistTitleTv.setMarqueeEnable(true);

        Intent intent = getIntent();
        listid = intent.getExtras().getString("listid");
    }

    @Override
    protected void onResume() {
        super.onResume();
        initSongsInSonglist();
        getSongsInSongList(methodPara, listid);
    }

    // 定义歌单内的歌曲列表View
    private void initSongsInSonglist() {
        songsInSonglistRv.setLayoutManager(new LinearLayoutManager(context));
        songsInSonglistRv.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL_LIST));

        songInSonglistAdapter = new SongInSonglistAdapter(context, R.layout.item_songs_in_songlist);
        songInSonglistAdapter.setOnItemClickListener(new CommonRecyclerAdapter.IOnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                // 整体item的点击事件, 跳转到播放页面
                Toast.makeText(context, "跳转去播放页面", Toast.LENGTH_SHORT).show();
                // songItem 每一项菜单的点击事件
                // 弹出popupwindow，主要包含 下一首播放、收藏、分享等功能
                ImageView songMenuIv = (ImageView) view.findViewById(R.id.ib_song_menu);
                songMenuIv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "跳转去菜单", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        headerAdapterWrapper = new HeaderAdapterWrapper(context, songInSonglistAdapter);
        View headerView = LayoutInflater.from(context).inflate(R.layout.item_header_songs_in_songlist, songsInSonglistRv, false);
        songlistCountTv = (TextView) headerView.findViewById(R.id.tv_song_count);
        headerAdapterWrapper.addHeaderView(headerView);
        songsInSonglistRv.setAdapter(headerAdapterWrapper);

//        adapterWrapper = new HeaderFooterAdapterWrapper(context, songInSonglistAdapter);
//        View headerView = LayoutInflater.from(context).inflate(R.layout.item_header_songs_in_songlist, songsInSonglistRv, false);
//        songlistCountTv = (TextView) headerView.findViewById(R.id.tv_song_count);
//        adapterWrapper.addHeaderView(headerView);
//        adapterWrapper.setOnItemClickListener(new CommonRecyclerAdapter.IOnItemClickListener() {
//            @Override
//            public void onClick(View view, int position) {
//                // header 整体点击事件
//                Toast.makeText(context, "播放所有歌曲页面", Toast.LENGTH_SHORT).show();
//                // header 菜单点击事件
//                ImageView songMenuIv = (ImageView) view.findViewById(R.id.ib_song_menu);
//                songMenuIv.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(context, "header跳转去菜单", Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//        });
//
//        songsInSonglistRv.setAdapter(adapterWrapper);

    }

    /**
     * 获取歌单内歌曲信息
     */
    public void getSongsInSongList(String methodPara, String listid) {
        ServiceManger.getInstance()
                .getiSongsInSongListService()
                .getSongsInSongList(methodPara, listid)
                .flatMap(new Func1<SongsInSongListEntity, Observable<SongsInSongListEntity.ContentBean>>() {
                    @Override
                    public Observable<SongsInSongListEntity.ContentBean> call(SongsInSongListEntity songsInSongListEntity) {

                        if (songsInSongListEntity != null) {
                            songlistTitle = songsInSongListEntity.getTitle();
                            songlistPicUrl = songsInSongListEntity.getPic_300();
                            songlistTag = songsInSongListEntity.getTag();

                        }
                        return Observable.from(songsInSongListEntity.getContent());
                    }
                })
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MySubscriber<List<SongsInSongListEntity.ContentBean>>(SonglistDetailActivity.this) {
                    @Override
                    public void onNext(List<SongsInSongListEntity.ContentBean> contentBeans) {
                        if (contentBeans != null) {
                            songInSonglistAdapter.setDataList(contentBeans);
                            songlistCountTv.setText(contentBeans.size() + "");
                        }

                        songlistTitleTv.setText(songlistTitle);
//                        songlistPic.setImageURI(Uri.parse(songlistPicUrl));
                        songlistTagTv.setText(songlistTag);
                        Glide.with(context)
                                .load(songlistPicUrl)
                                .placeholder(R.mipmap.placeholder_disk_210)
                                .into(songlistPic);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                    }
                });
    }

}
