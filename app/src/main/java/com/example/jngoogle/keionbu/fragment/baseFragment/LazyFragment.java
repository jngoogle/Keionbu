package com.example.jngoogle.keionbu.fragment.baseFragment;

import android.app.Activity;
import android.support.v4.app.Fragment;

/**
 * 懒加载
 * 在 fragment 需要显示的时候才加载，性能优化
 * 常用场景为 viewpager + fragment
 * 由于 viewpager 预加载至少加载当前可见page的前后页（共三页）
 * 懒加载保证了 fragment 中数据的后加载
 */
public abstract class LazyFragment extends Fragment {

    protected Activity context;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.context = activity;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser) {
            onvisible();
        } else {
            invisible();
        }
    }

    private void onvisible() {
        initViewLazyload();
    }

    private void invisible() {
    }

    protected abstract void initViewLazyload();
}
