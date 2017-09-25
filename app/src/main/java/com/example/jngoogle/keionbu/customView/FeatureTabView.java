package com.example.jngoogle.keionbu.customView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jngoogle.keionbu.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jngoogle on 2017/3/14.
 * <p>custom view
 * <p>
 * description:
 * 以下三个栏目的快捷入口
 * [私人电台] [每日推荐] [云音乐新歌榜]
 */

public class FeatureTabView extends LinearLayout {

    @BindView(R.id.ib_icon)
    ImageButton iconIb;
    @BindView(R.id.tv_text)
    TextView textTv;
    @BindView(R.id.tv_date)
    TextView dateTv;

    public FeatureTabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View layout = LayoutInflater.from(context).inflate(R.layout.feature_tab, this);
        ButterKnife.bind(this);
    }

    public void setImageRes(int drawable) {
        iconIb.setImageResource(drawable);
    }

    public void setText(String text) {
        textTv.setText(text);
    }

    public void setDateText(String date) {
        dateTv.setText(date);
    }
}
