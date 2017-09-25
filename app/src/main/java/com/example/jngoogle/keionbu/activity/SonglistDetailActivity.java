package com.example.jngoogle.keionbu.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


import com.example.jngoogle.keionbu.R;
import com.example.jngoogle.keionbu.adapter.CommonRecyclerAdapter;
import com.example.jngoogle.keionbu.adapter.SongInSonglistAdapter;
import com.example.jngoogle.keionbu.customView.MarqueeTextview;
import com.example.jngoogle.keionbu.network.entity.SongsInSongListEntity;
import com.example.jngoogle.keionbu.network.serviceManger.ServiceManger;
import com.example.jngoogle.keionbu.util.Const;
import com.example.jngoogle.keionbu.util.DividerItemDecoration;
import com.example.jngoogle.keionbu.util.MySubscriber;
import com.example.jngoogle.keionbu.util.ViewUtil;
import com.facebook.drawee.view.SimpleDraweeView;


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
public class SonglistDetailActivity extends BaseActivity implements CommonRecyclerAdapter.IOnItemClickListener{

    private static String methodPara = Const.methodSongsInSongListPara;

    @BindView(R.id.toolbar_songlist_detail)
    Toolbar toolbar;

    @BindView(R.id.dv_songlist_pic)
    SimpleDraweeView songlistPic;
    @BindView(R.id.tv_songlist_title)
    MarqueeTextview songlistTitleTv;
    @BindView(R.id.tv_songlist_tag)
    TextView songlistTagTv;
    @BindView(R.id.rv_songs_songlist)
    RecyclerView songsInSonglistRv;
    @BindView(R.id.collapsingToolbarLay)
    CollapsingToolbarLayout collapsingToolbarLayout;

    private SongInSonglistAdapter songInSonglistAdapter;
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
        setSupportActionBar(toolbar);
        songlistTitleTv.setMarqueeEnable(true);

        Intent intent = getIntent();
        listid = intent.getExtras().getString("listid");


    }

    @Override
    protected void onResume() {
        super.onResume();
        getSongsInSongList(methodPara, listid);
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
                            songInSonglistAdapter = new SongInSonglistAdapter(SonglistDetailActivity.this, R.layout.item_songs_in_songlist);
                            songInSonglistAdapter.setDataList(contentBeans);
                            songsInSonglistRv.setLayoutManager(new LinearLayoutManager(SonglistDetailActivity.this));
                            songsInSonglistRv.setAdapter(songInSonglistAdapter);
                            songsInSonglistRv.addItemDecoration(new DividerItemDecoration(SonglistDetailActivity.this, DividerItemDecoration.HORIZONTAL_LIST));
                        }

                        songlistTitleTv.setText(songlistTitle);
                        songlistPic.setImageURI(Uri.parse(songlistPicUrl));
                        songlistTagTv.setText(songlistTag);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                    }
                });
    }

    @Override
    public void onClick(View view, int position) {
        // 跳转到歌曲播放页
    }
}
