package com.example.jngoogle.keionbu.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.ImageButton;

import com.example.jngoogle.keionbu.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends BaseActivity {

    @BindView(R.id.ib_back)
    ImageButton backIb;
    @BindView(R.id.searchView)
    SearchView searchView;

    private FragmentManager fragmentMgr;

    @OnClick({R.id.ib_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_back:
                finish();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        // 创建 搜索热词的fragment
        fragmentMgr = getSupportFragmentManager();
        searchView.onActionViewExpanded();
        searchView.post(new Runnable() {
            @Override
            public void run() {
                searchView.clearFocus();
            }
        });
    }
}
