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
import android.widget.TextView;

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
import java.util.Random;
import java.util.stream.IntStream;

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
 * �������
 */
public class NewSongsFragment extends Fragment {

    private static final int AUTO_SCORLLING = 1;// �Զ�����viewpager
    private static String methodAdsPara = Const.methodAdsPicPara;// ��ȡ�ֲ�����ͼ����
    private static String methodSonglistPara = Const.methodSonglistPara;// ��ȡ�赥�Ĳ���
    private static String methodRadioPara = Const.methodRadioPara;// ��ȡ��̨�Ĳ���
    private static String methodNewAlbumPara = Const.methodNewAlbumPara;// ��ȡ��ר���Ĳ���

    private static int adsPicNum = Const.ADS_PIC_NUM;

    private List<View> adViews = new ArrayList<View>();

    private int havemore = -1;// 1 �����и��������
    private static int pageSize = Const.PAGE_SIZE;
    private int curPage = 1;// ��ǰҳ

    @BindView(R.id.vp_ads)
    ViewPager adsVp;
    @BindView(R.id.lay_dots)
    LinearLayout dots_lay;
    @BindView(R.id.tab_privateFm)
    FeatureTabView privateFm;// ˽�˵�̨
    @BindView(R.id.tab_dailyRecommend)
    FeatureTabView dailyRecommend;// ÿ���Ƽ�
    @BindView(R.id.tab_keionbuBillboard)
    FeatureTabView keionbuBillboard;// ���������ְ�
    @BindView(R.id.change_item_position)
    Button changeItemPositionBtn;// ������Ŀ˳���ܰ�ť
//    @BindView(R.id.test_api)
//    TextView testApiTv;
    @BindView(R.id.rv_radio)
    RecyclerView radioRv;// �Ƽ���̨�б�

    Items items;
    MultiTypeAdapter multiTypeAdapter;
    List<RadioEntity.RadioBean> radioList = new ArrayList<>();// ��������ŵĵط�
    List<NewAlbumEntity.PlazeAlbumListBean.RMBean.AlbumListBean.ListBean> albumList = new ArrayList<>();// ��������ŵĵط�

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                // handler�� uiHandler��������UI
                case AUTO_SCORLLING:
                    int totalIndex = adViews.size();
                    int curIndex = adsVp.getCurrentItem();
                    int nextIndex = curIndex + 1;
                    if (nextIndex >= totalIndex) {// ������ҳ�������»ص���һҳviewpager
                        nextIndex = 0;
                    }
                    adsVp.setCurrentItem(nextIndex, true);
                    handler.sendEmptyMessageDelayed(AUTO_SCORLLING, 2000);
                    break;
            }
        }
    };
    // ���ֲ�ͬ��д��
//    private Handler handler = new Handler();// UI handler
//    private Runnable runnable = new Runnable() {
//        @Override
//        public void run() {// ����UI
//            int totalIndex = adViews.size();
//            int curIndex = adsVp.getCurrentItem();
//            int nextIndex = curIndex + 1;
//            if (nextIndex >= totalIndex) {// ������ҳ�������»ص���һҳviewpager
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
     * init [˽�˵�̨] [ÿ���Ƽ�] [���������ְ�]
     */
    private void initFeatureTabView() {
        privateFm.setText("˽�˵�̨");
        dailyRecommend.setText("ÿ���Ƽ�");
        keionbuBillboard.setText("���������ְ�");

        privateFm.setImageRes(R.drawable.selector_fm);
        dailyRecommend.setImageRes(R.drawable.selector_daily);
        keionbuBillboard.setImageRes(R.drawable.selector_kbill);

        // ��ȡ��ǰ�����ڣ���䵽ÿ���Ƽ���ͼ����
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
     * �����Ƽ���̨�б�չʾ
     */
    private void initRadioView() {

        items = new Items();
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
    }

    private void loadData() {
        items.clear();
        items.add(new Category(R.mipmap.recommend_radio, "�Ƽ���̨"));
        getRecommendRadio(methodRadioPara);

        multiTypeAdapter.setItems(items);
        multiTypeAdapter.notifyDataSetChanged();
        radioRv.setAdapter(multiTypeAdapter);
    }

    /**
     * ��ȡ����ͼƬ
     *
     * @param methodPara
     * @param adsPicNum  ���û�ȡ����ͼ������
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
                        // ���������󲻵�ͼƬ��ʹ��Ĭ������ͼƬ
                        initViewPager(new ArrayList<String>() {
                            {
                                this.add("");
                            }
                        });
                    }
                });
    }

    /**
     * ��ȡ�Ƽ���̨
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

                        for (int i = 0; i < 6; i++) {
                            items.add(new Radio(
                                    Uri.parse(radioBeanList.get(i).getPic()),
                                    radioBeanList.get(i).getTitle(),
                                    radioBeanList.get(i).getDesc()));
                        }
                    }

                    @Override
                    public void onCompleted() {
                        super.onCompleted();
                        items.add(new Category(R.mipmap.recommend_newest, "��ר���ϼ�"));
                        getNewAlbumList(methodNewAlbumPara);
//                        for (Object item : items) {
//                            if (item instanceof RadioEntity.RadioBean) {
//                                radioList.add((RadioEntity.RadioBean) item);
//                            }
//                        }
                    }
                });
    }

    /**
     * ��ȡ��ר��
     */
    public void getNewAlbumList(String methodNewAlbumPara) {
        ServiceManger.getInstance()
                .getiNewAlbumService()
                .getNewAlbumList(methodNewAlbumPara)// �����ȡ��ר���Ĳ㼶�е�࣬��Ҫ��ϸ
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

                        for (int i = 0; i < 6; i++) {
                            items.add(new NewAlbum(
                                    Uri.parse(listBean.get(i).getPic_radio()),
                                    listBean.get(i).getTitle(),
                                    listBean.get(i).getAuthor()));
                        }

//                        testApiTv.setText(listBean.get(0).getCountry());
                    }
                });
    }

    /**
     * @param strings ����ͼ��uriList
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
