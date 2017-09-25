package com.example.jngoogle.keionbu.fragment.subTabFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.jngoogle.keionbu.R;
import com.example.jngoogle.keionbu.adapter.RankingAdapter;
import com.example.jngoogle.keionbu.fragment.baseFragment.LazyFragment;
import com.example.jngoogle.keionbu.network.entity.RankingEntity;
import com.example.jngoogle.keionbu.network.serviceManger.ServiceManger;
import com.example.jngoogle.keionbu.util.Const;
import com.example.jngoogle.keionbu.util.MySubscriber;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
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
    private static String methodPara = Const.methodBillboardPara;
    // 偏移量
    private static int offset = Const.OFFSET;
    // 返回榜单的总数
    private static int size = Const.BILLBORAD_SIZE;

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
        getBillboardData(methodPara, types, offset, size);// 获取榜单信息
    }


    /**
     * 获取榜单信息
     * @param methodPara
     * @param types 榜单类型
     * @param offset 偏移量
     * @param size 设置获取榜单中歌曲的总数，如3代表只展示榜单中排名前三的歌曲
     */
    private void getBillboardData(String methodPara, Integer[] types, int offset, int size) {
        Observable.from(types)
                .flatMap(new Func1<Integer, Observable<RankingEntity>>() {
                    @Override
                    public Observable<RankingEntity> call(Integer type) {
                        return ServiceManger
                                .getInstance()
                                .getBillSongListService()
                                .getBillSongList(methodPara, type, offset, size);
                    }
                })
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MySubscriber<List<RankingEntity>>(getContext()) {
                    @Override
                    public void onNext(List<RankingEntity> rankingEntities) {
                        rankingLayout = (LinearLayout) LayoutInflater.from(context)
                                .inflate(R.layout.fragment_ranking, null);

                        rankingLv = (ListView) rankingLayout.findViewById(R.id.lv_ranking);
                        rankingAdapter = new RankingAdapter(context, R.layout.ranking_list_item, pics);
                        rankingAdapter.setDataList(rankingEntities);
                        rankingLv.setAdapter(rankingAdapter);
                        // 更新UI, 移除loading布局加载rankingFragment的布局
                        View rootView = getView();
                        ((ViewGroup) rootView).removeAllViews();
                        ((ViewGroup) rootView).addView(rankingLayout);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                    }
                });
    }

}
