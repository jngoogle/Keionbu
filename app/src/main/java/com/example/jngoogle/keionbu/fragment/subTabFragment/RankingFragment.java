package com.example.jngoogle.keionbu.fragment.subTabFragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.jngoogle.keionbu.R;
import com.example.jngoogle.keionbu.adapter.CommonAdapter;
import com.example.jngoogle.keionbu.fragment.baseFragment.LazyFragment;
import com.example.jngoogle.keionbu.network.entity.RankingEntity;
import com.example.jngoogle.keionbu.network.entity.SongList;
import com.example.jngoogle.keionbu.network.serviceManger.ServiceManger;
import com.example.jngoogle.keionbu.util.Const;
import com.example.jngoogle.keionbu.util.MySubscriber;
import com.example.jngoogle.keionbu.util.NetWorkUtil;
import com.example.jngoogle.keionbu.viewHolder.CommonViewHolder;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


/**
 * 榜单板块
 */


public class RankingFragment extends LazyFragment {

    private final String TAG = RankingFragment.this.getClass().getSimpleName();

    private LinearLayout rankingLayout;// 榜单布局
    private FrameLayout loadingView;// loading布局
    private ListView rankingLv;
    private RankingAdapter rankingAdapter;


    // 获取榜单信息的参数
    private String methodPara = Const.methodBillboardPara;
    // 榜单类别
    private Integer[] types = {
            Const.BILLBOARD_NEW_MUSIC,  // 新歌榜
            Const.BILLBOARD_ORIGINAL,   // 原创榜
            Const.BILLBOARD_HOT_MUSIC,  // 热歌榜
    };
    // 榜单图片
    private int[] pics = {
            R.mipmap.ranklist_first,
            R.mipmap.ranklist_second,
            R.mipmap.ranklist_third};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 预先加载loadingView
        loadingView = (FrameLayout) inflater.inflate(R.layout.loading_ranking, container, false);
        Log.e(TAG, "onCreateView");
        return loadingView;
    }


    /**
     * 注意！ 此方法会在 onCreateView() 方法前执行
     * 这里加载的是 RankingFragment的真正布局
     * 使用懒加载的方式
     */
    @Override
    protected void initViewLazyload() {
        Log.e(TAG, "initViewLazyload");
        initData();
    }


    private void initData() {
        Observable.from(types)
                .flatMap(new Func1<Integer, Observable<RankingEntity>>() {
                    @Override
                    public Observable<RankingEntity> call(Integer type) {
                        return ServiceManger
                                .getInstance()
                                .getBillSongListService()
                                .getBillSongList(methodPara, type, 0, 3);
                    }
                })
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MySubscriber<List<RankingEntity>>(getContext()) {
                    @Override
                    public void onError(Throwable e) {
                        if (!NetWorkUtil.isNetworkAvailable(getContext())) {// 当前网络不可用

                        }
                    }

                    @Override
                    public void onNext(List<RankingEntity> rankingEntities) {
                        rankingLayout = (LinearLayout) LayoutInflater.from(context)
                                .inflate(R.layout.fragment_ranking, null);

                        rankingLv = (ListView) rankingLayout.findViewById(R.id.lv_ranking);
                        rankingAdapter = new RankingAdapter(context, R.layout.ranking_list_item);
                        rankingAdapter.setDataList(rankingEntities);
                        rankingLv.setAdapter(rankingAdapter);
                        // 更新UI, 移除loading布局加载rankingFragment的布局
                        View rootView = getView();
                        ((ViewGroup) rootView).removeAllViews();
                        ((ViewGroup) rootView).addView(rankingLayout);
                    }
                });
    }

    private class RankingAdapter extends CommonAdapter<RankingEntity> {

        public RankingAdapter(Context mContext, int mItemLayoutId) {
            super(mContext, mItemLayoutId);
        }

        @Override
        public void bindData(CommonViewHolder commonViewHolder, int position, RankingEntity itemData) {

            if (itemData.getSongList() != null && itemData.getSongList().size() >= 3) {
                int[] ids = new int[]{R.id.tv_no1, R.id.tv_no2, R.id.tv_no3};
                for (int i = 0; i < ids.length; i++) {
                    SongList songList = itemData.getSongList().get(i);
                    commonViewHolder.setText(ids[i], songList.getTitle() + "-" + songList.getAuthor());
                }
            }
            commonViewHolder.setImageResource(R.id.draweeView_rankingPic, pics[position]);
        }
    }

}
