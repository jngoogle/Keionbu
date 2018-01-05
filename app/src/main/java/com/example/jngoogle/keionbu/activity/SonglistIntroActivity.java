package com.example.jngoogle.keionbu.activity;

import android.net.Uri;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jngoogle.keionbu.R;
import com.example.jngoogle.keionbu.network.entity.SongsInSongListEntity;
import com.example.jngoogle.keionbu.network.serviceManger.ServiceManger;
import com.example.jngoogle.keionbu.util.Const;
import com.example.jngoogle.keionbu.util.MySubscriber;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SonglistIntroActivity extends BaseActivity {

    // 歌单id
    private String listid;
    private static String methodPara = Const.methodSongsInSongListPara;

    @BindView(R.id.iv_close)
    ImageView closeIv;
    @BindView(R.id.dv_songlist_pic)
    ImageView songlistPicDv;
    @BindView(R.id.tv_songlist_title)
    TextView songlistTitleTv;
    @BindView(R.id.tv_songlist_spec)
    TextView songlistSpecTv;// 歌单介绍
    @BindView(R.id.tv_songlist_tag)
    TextView songlistTagTv;

    @OnClick(R.id.iv_close)
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_close:
                finish();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songlist_intro);
        ButterKnife.bind(this);
        Bundle songlistBundle = getIntent().getExtras();
        listid = songlistBundle.getString("listid");
    }

    @Override
    protected void onResume() {
        super.onResume();
        getSonglistIntro(methodPara, listid);
    }

    /**
     * 获取歌单介绍信息
     */
    public void getSonglistIntro(String methodPara, String listid) {
        ServiceManger.getInstance()
                .getiSongsInSongListService()
                .getSongsInSongList(methodPara, listid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MySubscriber<SongsInSongListEntity>(SonglistIntroActivity.this) {
                    @Override
                    public void onNext(SongsInSongListEntity songsInSongListEntity) {
                        if (songsInSongListEntity != null) {

                            String songlistDesc = songsInSongListEntity.getDesc();
                            Spannable textSpan = new SpannableString(songlistDesc);
                            textSpan.setSpan(new AbsoluteSizeSpan(46), 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                            songlistSpecTv.setText(textSpan);// 歌单介绍
//                            songlistSpecTv.setText(songsInSongListEntity.getDesc());
                            songlistTitleTv.setText(songsInSongListEntity.getTitle());// 歌单名
                            songlistTagTv.setText(songsInSongListEntity.getTag());// 歌单tag
                            songlistPicDv.setImageURI(Uri.parse(songsInSongListEntity.getPic_300()));// 歌单封面
                        }
                    }
                });

    }
}
