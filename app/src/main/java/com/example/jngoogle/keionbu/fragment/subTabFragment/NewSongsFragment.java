package com.example.jngoogle.keionbu.fragment.subTabFragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jngoogle.keionbu.R;
import com.example.jngoogle.keionbu.activity.VedioActivity;
import com.example.jngoogle.keionbu.customView.FeatureTabView;
import com.example.jngoogle.keionbu.network.entity.AdPic;
import com.example.jngoogle.keionbu.network.entity.AdsEntity;
import com.example.jngoogle.keionbu.network.serviceManger.ServiceManger;
import com.example.jngoogle.keionbu.util.Const;
import com.example.jngoogle.keionbu.util.MySubscriber;
import com.example.jngoogle.keionbu.util.NetWorkUtil;
import com.example.jngoogle.keionbu.util.NotifyUtil;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import android.os.Handler;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 新曲板块
 */
public class NewSongsFragment extends Fragment {

    private static final int AUTO_SCORLLING = 1;// 自动播放viewpager
    private String methodPara = Const.methodAdsPicPara;// 获取轮播宣传图参数

    private List<View> adViews = new ArrayList<View>();

    @BindView(R.id.vp_ads)
    ViewPager adsVp;
    @BindView(R.id.lay_dots)
    LinearLayout dots_lay;
    @BindView(R.id.tab_privateFm)
    FeatureTabView privateFm;// 私人电台
    @BindView(R.id.tab_dailyRecommend)
    FeatureTabView dailyRecommend;// 每日推荐
    @BindView(R.id.tab_keionbuBillboard)
    FeatureTabView keionbuBillboard;// 轻音社音乐榜

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                // handler是 uiHandler用来更新UI
                case AUTO_SCORLLING:
                    int totalIndex = adViews.size();
                    int curIndex = adsVp.getCurrentItem();
                    int nextIndex = curIndex + 1;
                    if (nextIndex >= totalIndex) {// 当超出页数则重新回到第一页viewpager
                        nextIndex = 0;
                    }
                    adsVp.setCurrentItem(nextIndex, true);
                    handler.sendEmptyMessageDelayed(AUTO_SCORLLING, 2000);
                    break;
            }
        }
    };
    // 两种不同的写法
//    private Handler handler = new Handler();// UI handler
//    private Runnable runnable = new Runnable() {
//        @Override
//        public void run() {// 更新UI
//            int totalIndex = adViews.size();
//            int curIndex = adsVp.getCurrentItem();
//            int nextIndex = curIndex + 1;
//            if (nextIndex >= totalIndex) {// 当超出页数则重新回到第一页viewpager
//                nextIndex = 0;
//            }
//            adsVp.setCurrentItem(nextIndex, true);
//            handler.postDelayed(this, 2000);
//        }
//    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_new_songs, container, false);
        ButterKnife.bind(this, view);
        initFeatureTabView();
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        loadAdsPic();
        Message msg = Message.obtain();
        msg.what = AUTO_SCORLLING;
        handler.sendEmptyMessageDelayed(AUTO_SCORLLING, 2000);


//        handler.postDelayed(runnable, 2000);
    }

    @Override
    public void onStop() {
        super.onStop();
        new Thread(new Runnable() {
            @Override
            public void run() {
                handler.removeMessages(AUTO_SCORLLING);
            }
        }).start();

    }

    // init viewpager indicator (small dots)
//    private void initViewPager() {
//
//        adViews = new ArrayList<View>();
//        int[] images = new int[]{
//                R.mipmap.ad_first,
//                R.mipmap.ad_second,
//                R.mipmap.ad_third,
//                R.mipmap.ad_fourth,
//                R.mipmap.ad_five,
//                R.mipmap.ad_six,
//                R.mipmap.ad_seven};
//
//
//        for (int i = 0; i < images.length; i++) {
//            adViews.add(initItemView(images[i]));
//        }
//
//        initDots(images);
//    }

    /**
     * 获取宣传图片
     */
    private void loadAdsPic() {
        ServiceManger.getInstance()
                .getiAdsPicService()
                .getAdsPic(methodPara, 7)
                .flatMap(new Func1<AdsEntity, Observable<AdPic>>() {
                    @Override
                    public Observable<AdPic> call(AdsEntity adsEntity) {
                        return Observable.from(adsEntity.getAdPics());
                    }
                })
                .map(new Func1<AdPic, String>() {
                    @Override
                    public String call(AdPic adPic) {
                        return adPic.getRandpic();
                    }
                })
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MySubscriber<List<String>>(getContext()) {
                    @Override
                    public void onNext(List<String> strings) {
                        initViewPager(strings);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        // 当网络请求不到图片，使用默认宣传图片
                        initViewPager(new ArrayList<String>() {
                            {
                                this.add("");
                            }
                        });
                    }
                });
//                .subscribe(new Action1<List<String>>() {
//                    @Override
//                    public void call(List<String> strings) {
//                        for (int i = 0; i < strings.size(); i++) {
//                            Uri uri = Uri.parse(strings.get(i));
//                            adViews.add(initItemView(uri));
//                        }
//
//                        initDots(strings.size());
//                        setViewPagerAdapter();
//                    }
//                });
    }

    /**
     * @param strings 宣传图的uriList
     */
    private void initViewPager(List<String> strings) {
        for (int i = 0; i < strings.size(); i++) {
            Uri uri = Uri.parse(strings.get(i));
            adViews.add(initItemView(uri));
        }

        initDots(strings.size());
        setViewPagerAdapter();
    }

    /**
     * init viewpager item
     *
     * @param uri pic uri
     * @return
     */
    private View initItemView(Uri uri) {
        View layout = LayoutInflater.from(getContext()).inflate(R.layout.item_ad_viewpager, null);
        SimpleDraweeView draweeView = (SimpleDraweeView) layout.findViewById(R.id.iv_ad);
        draweeView.setImageURI(uri);
        draweeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), VedioActivity.class));
            }
        });
        return layout;
    }

//    private View initItemView(int res) {
//        View layout = LayoutInflater.from(getContext()).inflate(R.layout.item_ad_viewpager, null);
//        SimpleDraweeView draweeView = (SimpleDraweeView) layout.findViewById(R.id.iv_ad);
//        draweeView.setImageResource(res);
//        draweeView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getContext(), VedioActivity.class));
//            }
//        });
//        return layout;
//    }

    private void initDots(int picNum) {
        for (int i = 0; i < picNum; i++) {
            View dot_lay = LayoutInflater.from(getContext()).inflate(R.layout.dot_layout, null);
            dots_lay.addView(dot_lay);
        }

        dots_lay.getChildAt(0).setSelected(true);
    }

    private void setViewPagerAdapter() {
        MyAdsViewPagerAdapter myAdsViewPagerAdapter = new MyAdsViewPagerAdapter(adViews);
        adsVp.setAdapter(myAdsViewPagerAdapter);
        adsVp.addOnPageChangeListener(new MyPageChangeListener());
    }

    /**
     * init [私人电台] [每日推荐] [轻音社音乐榜]
     */
    private void initFeatureTabView() {
        privateFm.setText("私人电台");
        dailyRecommend.setText("每日推荐");
        keionbuBillboard.setText("轻音社音乐榜");

        privateFm.setImageRes(R.drawable.selector_fm);
        dailyRecommend.setImageRes(R.drawable.selector_daily);
        keionbuBillboard.setImageRes(R.drawable.selector_kbill);
    }

    private class MyAdsViewPagerAdapter extends PagerAdapter {

        private List<View> views;

        private MyAdsViewPagerAdapter(List<View> views) {
            this.views = views;
        }

        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(views.get(position));
            return views.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(views.get(position));
        }
    }

    /**
     * viewpager pager change listener
     */
    private class MyPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            int totalIndex = dots_lay.getChildCount();
            for (int i = 0; i < totalIndex; i++) {
                if (i != position) {
                    dots_lay.getChildAt(i).setSelected(false);
                } else {
                    dots_lay.getChildAt(i).setSelected(true);
                }
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
