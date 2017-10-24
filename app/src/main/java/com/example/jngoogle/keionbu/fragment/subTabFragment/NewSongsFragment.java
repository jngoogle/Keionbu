package com.example.jngoogle.keionbu.fragment.subTabFragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.jngoogle.keionbu.R;
import com.example.jngoogle.keionbu.activity.VedioActivity;
import com.example.jngoogle.keionbu.adapter.AdsViewPagerAdapter;
import com.example.jngoogle.keionbu.customView.FeatureTabView;
import com.example.jngoogle.keionbu.fragment.subTabFragment.newSongs.Category;
import com.example.jngoogle.keionbu.fragment.subTabFragment.newSongs.CategoryViewBinder;
import com.example.jngoogle.keionbu.fragment.subTabFragment.newSongs.NewAlbum;
import com.example.jngoogle.keionbu.fragment.subTabFragment.newSongs.NewAlbumViewBinder;
import com.example.jngoogle.keionbu.fragment.subTabFragment.newSongs.Radio;
import com.example.jngoogle.keionbu.fragment.subTabFragment.newSongs.RadioViewBinder;
import com.example.jngoogle.keionbu.network.entity.AdsEntity;
import com.example.jngoogle.keionbu.network.entity.NewAlbumEntity;
import com.example.jngoogle.keionbu.network.entity.RadioEntity;
import com.example.jngoogle.keionbu.network.serviceManger.ServiceManger;
import com.example.jngoogle.keionbu.util.Const;
import com.example.jngoogle.keionbu.util.MySubscriber;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 新曲板块
 */
public class NewSongsFragment extends Fragment {

    private static final int AUTO_SCORLLING = 1;// 自动播放viewpager
    private static String methodAdsPara = Const.methodAdsPicPara;// 获取轮播宣传图参数
    private static String methodSonglistPara = Const.methodSonglistPara;// 获取歌单的参数
    private static String methodRadioPara = Const.methodRadioPara;// 获取歌单的参数
    private static String methodNewAlbumPara = Const.methodNewAlbumPara;// 获取新专辑的参数

    private static int adsPicNum = Const.ADS_PIC_NUM;

    private List<View> adViews = new ArrayList<View>();

    private int havemore = -1;// 1 代表还有更多的数据
    private static int pageSize = Const.PAGE_SIZE;
    private int curPage = 1;// 当前页

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
    @BindView(R.id.change_item_position)
    Button changeItemPositionBtn;// 更改栏目顺序功能按钮
    //    @BindView(R.id.test_api)
//    TextView testApiTv;
    @BindView(R.id.rv_radio)
    RecyclerView radioRv;// 推荐电台列表

    Items items;// 总体的items
    Items radioItems, newAlbumItems;

    MultiTypeAdapter multiTypeAdapter;

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
        initRadioView();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getAdsPic(methodAdsPara, adsPicNum);
        loadData();
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

        // 获取当前的日期，填充到每日推荐的图标中
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
        String monthStr = dateFormat.format(new Date());
        dailyRecommend.setDateText(monthStr);
    }

    @OnClick(R.id.change_item_position)
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.change_item_position:

                break;
        }
    }

    /**
     * 定义推荐电台列表展示
     */
    private void initRadioView() {
        items = new Items();
        radioItems = new Items();
        newAlbumItems = new Items();
        multiTypeAdapter = new MultiTypeAdapter();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), Const.SPAN_COUNT_RADIO);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return items.get(position) instanceof Category ? Const.SPAN_COUNT_RADIO : 1;
            }
        });

        radioRv.setLayoutManager(gridLayoutManager);
        multiTypeAdapter.register(Category.class, new CategoryViewBinder());
        multiTypeAdapter.register(Radio.class, new RadioViewBinder());
        multiTypeAdapter.register(NewAlbum.class, new NewAlbumViewBinder());
        multiTypeAdapter.setItems(items);
        radioRv.setAdapter(multiTypeAdapter);

    }

    private void loadData() {
        getRecommendRadio(methodRadioPara);
        getNewAlbumList(methodNewAlbumPara);
    }

    /**
     * 重新整理数据顺序
     */
    private void reloadItems() {
        items.clear();
        items.addAll(radioItems);
        items.addAll(newAlbumItems);
        multiTypeAdapter.notifyDataSetChanged();
    }

    /**
     * 获取宣传图片
     *
     * @param methodPara
     * @param adsPicNum  设置获取宣传图的总数
     */
    private void getAdsPic(String methodPara, int adsPicNum) {
        ServiceManger.getInstance()
                .getiAdsPicService()
                .getAdsPic(methodPara, adsPicNum)
                .flatMap(new Func1<AdsEntity, Observable<AdsEntity.AdPic>>() {
                    @Override
                    public Observable<AdsEntity.AdPic> call(AdsEntity adsEntity) {
                        return Observable.from(adsEntity.getAdPics());
                    }
                })
                .map(new Func1<AdsEntity.AdPic, String>() {
                    @Override
                    public String call(AdsEntity.AdPic adPic) {
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
    }

    /**
     * 获取推荐电台
     */
    public void getRecommendRadio(String methodRadioPara) {
        ServiceManger.getInstance()
                .getiRadioService()
                .getRadio(methodRadioPara)
                .flatMap(new Func1<RadioEntity, Observable<RadioEntity.RadioBean>>() {
                    @Override
                    public Observable<RadioEntity.RadioBean> call(RadioEntity radioEntity) {
                        return Observable.from(radioEntity.getList());
                    }
                })
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MySubscriber<List<RadioEntity.RadioBean>>(getContext()) {
                    @Override
                    public void onNext(List<RadioEntity.RadioBean> radioBeanList) {
                        radioItems.clear();
                        radioItems.add(new Category(R.mipmap.recommend_radio, "推荐电台"));
                        for (int i = 0; i < 6; i++) {
                            radioItems.add(new Radio(
                                    Uri.parse(radioBeanList.get(i).getPic()),
                                    radioBeanList.get(i).getTitle(),
                                    radioBeanList.get(i).getDesc()));
                        }

                        reloadItems();
                    }
                });
    }

    /**
     * 获取新专辑
     */
    public void getNewAlbumList(String methodNewAlbumPara) {
        ServiceManger.getInstance()
                .getiNewAlbumService()
                .getNewAlbumList(methodNewAlbumPara)// 这里获取新专辑的层级有点多，需要仔细
                .flatMap(new Func1<NewAlbumEntity, Observable<NewAlbumEntity.PlazeAlbumListBean.RMBean.AlbumListBean.ListBean>>() {
                    @Override
                    public Observable<NewAlbumEntity.PlazeAlbumListBean.RMBean.AlbumListBean.ListBean> call(NewAlbumEntity newAlbumEntity) {
                        return Observable.from(newAlbumEntity.getPlaze_album_list().getRM().getAlbum_list().getList());
                    }
                })
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MySubscriber<List<NewAlbumEntity.PlazeAlbumListBean.RMBean.AlbumListBean.ListBean>>(getContext()) {
                    @Override
                    public void onNext(List<NewAlbumEntity.PlazeAlbumListBean.RMBean.AlbumListBean.ListBean> listBean) {
//                        testApiTv.setText(listBean.get(0).getAuthor());

                        newAlbumItems.clear();
                        newAlbumItems.add(new Category(R.mipmap.recommend_radio, "新专辑上架"));
                        for (int i = 0; i < 6; i++) {
                            newAlbumItems.add(new NewAlbum(
                                    Uri.parse(listBean.get(i).getPic_radio()),
                                    listBean.get(i).getTitle(),
                                    listBean.get(i).getAuthor()));
                        }

                        reloadItems();
                    }
                });

    }

    /**
     * @param strings 宣传图的uriList
     */
    private void initViewPager(List<String> strings) {
        adViews.clear();
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
        draweeView.setScaleType(ImageView.ScaleType.FIT_XY);
        draweeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), VedioActivity.class));
            }
        });
        return layout;
    }

    private void initDots(int picNum) {
        dots_lay.removeAllViews();
        for (int i = 0; i < picNum; i++) {
            View dot_lay = LayoutInflater.from(getContext()).inflate(R.layout.dot_layout, null);
            dots_lay.addView(dot_lay);
        }

        dots_lay.getChildAt(0).setSelected(true);
    }

    private void setViewPagerAdapter() {
        AdsViewPagerAdapter adsViewPagerAdapter = new AdsViewPagerAdapter(adViews);
        adsVp.setAdapter(adsViewPagerAdapter);
        adsVp.addOnPageChangeListener(new MyPageChangeListener());
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
