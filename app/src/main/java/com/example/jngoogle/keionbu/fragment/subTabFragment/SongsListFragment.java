package com.example.jngoogle.keionbu.fragment.subTabFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jngoogle.keionbu.R;
import com.example.jngoogle.keionbu.activity.SonglistDetailActivity;
import com.example.jngoogle.keionbu.adapter.CommonRecyclerAdapter;
import com.example.jngoogle.keionbu.adapter.SonglistAdapter;
import com.example.jngoogle.keionbu.network.entity.SongMenuEntity;
import com.example.jngoogle.keionbu.network.serviceManger.ServiceManger;
import com.example.jngoogle.keionbu.util.Const;
import com.example.jngoogle.keionbu.util.MySubscriber;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


/**
 * 歌单板块
 */
public class SongsListFragment extends Fragment implements CommonRecyclerAdapter.IOnItemClickListener,
        PullLoadMoreRecyclerView.PullLoadMoreListener {

    private static String methodPara = Const.methodSonglistPara;
    private static int pageSize = Const.PAGE_SIZE;
    private int curPage = 1;// 当前页
    private int havemore = -1;// 1 代表还有更多的数据

    @BindView(R.id.rv_songlist)
    PullLoadMoreRecyclerView songlistRv;

    private List<SongMenuEntity.ContentBean> songList;// 歌单列表
    private SonglistAdapter songlistAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle tanceState) {
        View contentLay = inflater.inflate(R.layout.fragment_songs_list, container, false);
        ButterKnife.bind(this, contentLay);
        configSonglist();
        return contentLay;
    }

    private void configSonglist() {
        songlistRv.setGridLayout(2);
        songlistRv.setOnPullLoadMoreListener(this);
        songlistAdapter = new SonglistAdapter(getContext(), R.layout.item_songlist);
        songlistAdapter.setOnItemClickListener(this);
        songlistRv.setAdapter(songlistAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (songlistAdapter != null) {
            songlistAdapter.clearDataList();
        }
        getAllSongList(methodPara, pageSize, curPage);// 获取所有的歌单
    }

    /**
     * 获取全部歌单
     *
     * @param methodPara
     * @param pageSize   分页中每一页数据的条数
     * @param curPage    当前第几页
     */
    public void getAllSongList(String methodPara, int pageSize, int curPage) {
        ServiceManger.getInstance()
                .getiSongListService()
                .getSongList(methodPara, pageSize, curPage)
                .flatMap(new Func1<SongMenuEntity, Observable<SongMenuEntity.ContentBean>>() {
                    @Override
                    public Observable<SongMenuEntity.ContentBean> call(SongMenuEntity songMenuEntity) {
                        SongsListFragment.this.havemore = songMenuEntity.getHavemore();
                        return Observable.from(songMenuEntity.getContentList());
                    }
                })
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MySubscriber<List<SongMenuEntity.ContentBean>>(getContext()) {
                    @Override
                    public void onNext(List<SongMenuEntity.ContentBean> contentBeanList) {
                        if (contentBeanList != null) {
                            songList = contentBeanList;
                            if (curPage == 1) {
                                songlistAdapter.clearDataList();
                            }
                            songlistAdapter.addDataList(contentBeanList);
                        }
                    }

                    @Override
                    public void onCompleted() {
                        songlistRv.setPullLoadMoreCompleted();
                        super.onCompleted();

                    }
                });
    }

    @Override
    public void onRefresh() {
        if (songlistAdapter != null) {
            songlistAdapter.clearDataList();
        }
        getAllSongList(methodPara, pageSize, 1);
        curPage = 1;
    }

    @Override
    public void onLoadMore() {
        if (havemore == 1) {
            curPage = curPage + 1;
            getAllSongList(methodPara, pageSize, curPage);
        }

        if (havemore != 0) {// 数据滑动到最后一页
            songlistRv.setPullLoadMoreCompleted();
        }
    }

    /**
     * recyclerview 的点击事件
     * 从歌单列表跳转到歌单详情
     *
     * @param view     itemView
     * @param position
     */
    @Override
    public void onClick(View view, int position) {
        Intent songListIntent = new Intent();
        songListIntent.putExtra("listid", songlistAdapter.getDataList().get(position).getListid());
        songListIntent.setClass(getContext(), SonglistDetailActivity.class);
        startActivity(songListIntent);
    }
}
