package com.example.jngoogle.keionbu.fragment.searchFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jngoogle.keionbu.R;
import com.example.jngoogle.keionbu.network.entity.SearchEntity;
import com.example.jngoogle.keionbu.network.serviceManger.ServiceManger;
import com.example.jngoogle.keionbu.util.Const;
import com.example.jngoogle.keionbu.util.ConvertUtil;
import com.example.jngoogle.keionbu.util.MySubscriber;
import com.example.jngoogle.keionbu.widgetController.WidgetController;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 搜索 Activity 中的热词标签
 */
public class HotTagFragment extends Fragment {

    private List<TextView> hotWordsViews;// 热词列表views
    private static String methodPara = Const.methodSearchWordsPara;

    @BindView(R.id.text1)
    TextView textView1;
    @BindView(R.id.text2)
    TextView textView2;
    @BindView(R.id.text3)
    TextView textView3;
    @BindView(R.id.text4)
    TextView textView4;
    @BindView(R.id.text5)
    TextView textView5;
    @BindView(R.id.text6)
    TextView textView6;
    @BindView(R.id.text7)
    TextView textView7;
    @BindView(R.id.text8)
    TextView textView8;
    @BindView(R.id.lay_hot_words)
    FrameLayout hotWordsLay;
    @BindView(R.id.lv_search_history)
    ListView searchHistoryLv;// 热词搜索历史列表

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_hot_tag, container, false);
        ButterKnife.bind(this, layout);
        initHotWordsViews();
        loadSearchHotWords(methodPara);
        return layout;
    }

    /**
     * 获取搜索热词
     *
     * @param methodPara
     */
    private void loadSearchHotWords(String methodPara) {
        ServiceManger.getInstance()
                .getiSearchWordsService()
                .getSearchWords(methodPara)
                .flatMap(new Func1<SearchEntity, Observable<SearchEntity.ResultBean>>() {
                    @Override
                    public Observable<SearchEntity.ResultBean> call(SearchEntity searchEntity) {
                        return Observable.from(searchEntity.getResult());
                    }
                })
                .map(new Func1<SearchEntity.ResultBean, String>() {
                    @Override
                    public String call(SearchEntity.ResultBean resultBean) {
                        return resultBean.getWord();
                    }
                })
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MySubscriber<List<String>>(getContext()) {
                    @Override
                    public void onNext(List<String> strings) {

                        for (int i = 0; i < 8; i++) {// 只取8个热词
                            hotWordsViews.get(i).setText(strings.get(i));
                        }

                        setHotTagLocation();
                    }
                });
    }

    private void initHotWordsViews() {
        hotWordsViews = new ArrayList<>();
        hotWordsViews.add(textView1);
        hotWordsViews.add(textView2);
        hotWordsViews.add(textView3);
        hotWordsViews.add(textView4);
        hotWordsViews.add(textView5);
        hotWordsViews.add(textView6);
        hotWordsViews.add(textView7);
        hotWordsViews.add(textView8);
    }

    /**
     * 设置热词标签组件的位置
     */
    private void setHotTagLocation() {

        int screenWidth = getContext().getResources().getDisplayMetrics().widthPixels;// parent layout width
        int xoffset = -1;// init x offset, set -1 represent the first hotTag in a row
        int yoffset = 0;// init y offset
        int distance = ConvertUtil.dip2px(getContext(), 16);// distance between hotTags

        for (int i = 0; i < hotWordsViews.size(); i++) {
            if (xoffset == -1) {// when set the first hotTag in a row
                xoffset = 0;
                WidgetController.setViewLocation(hotWordsViews.get(i), xoffset, yoffset);
                continue;
            }

            xoffset = xoffset + WidgetController.getWidth(hotWordsViews.get(i - 1)) + distance;
            if (xoffset + WidgetController.getWidth(hotWordsViews.get(i)) + distance > screenWidth) {
                // hotTag beyond screen to display
                xoffset = -1;
                yoffset = yoffset + 120;
                i--;
                continue;
            }

            WidgetController.setViewLocation(hotWordsViews.get(i), xoffset, yoffset);
        }

    }

}
