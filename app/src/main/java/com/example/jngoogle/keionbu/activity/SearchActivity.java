package com.example.jngoogle.keionbu.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;

import com.example.jngoogle.keionbu.R;
import com.example.jngoogle.keionbu.fragment.searchFragment.HotTagFragment;
import com.example.jngoogle.keionbu.fragment.searchFragment.SearchResultFragment;
import com.example.jngoogle.keionbu.util.AESTools;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends BaseActivity implements SearchView.OnQueryTextListener {

    @BindView(R.id.toolbar_search)
    Toolbar toolbar;
    @BindView(R.id.ib_back)
    ImageButton backIb;
    @BindView(R.id.searchView)
    SearchView searchView;

    private InputMethodManager imm;
    private FragmentManager fragmentMgr;
    HotTagFragment hotTagFragment;
    SearchResultFragment searchResultFragment;

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
        setSupportActionBar(toolbar);
        initView();
        createFragment();
        showFragment(hotTagFragment, R.id.fgLay_hot_tag);
    }

    private void initView() {
        searchView.onActionViewExpanded();
        searchView.post(new Runnable() {
            @Override
            public void run() {
                searchView.clearFocus();
            }
        });
        searchView.setIconifiedByDefault(false);
        searchView.setIconified(false);
        searchView.setOnQueryTextListener(this);

        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    private void createFragment() {
        fragmentMgr = getSupportFragmentManager();
        hotTagFragment = new HotTagFragment();
        searchResultFragment = new SearchResultFragment();
    }

    /**
     * show fragment
     *
     * @param fragment
     * @param resId    fragment layout resId
     */
    private void showFragment(Fragment fragment, int resId) {
        if (fragment != null) {
            fragmentMgr.beginTransaction().add(resId, fragment).commit();
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        hideSoftInput();
        // 替换原来的搜索热词fragment，替换成搜索结果 SearchResultFragment
        showFragment(searchResultFragment, R.id.fgLay_hot_tag);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    /**
     * 关闭软键盘且执行搜索SQL语句
     */
    private void hideSoftInput() {
        if (searchView != null) {
            if (imm != null) {// 有搜索结果
                imm.hideSoftInputFromWindow(searchView.getWindowToken(), 0);
            }
            searchView.clearFocus();
            // 执行搜索语句，执行SQL语句
//            searchView.getQuery().toString();
        }
    }
}
