package com.example.jngoogle.keionbu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jngoogle on 2018/5/8.
 */

public class HeaderAdapterWrapper extends CommonRecyclerAdapter {
    private final int HEAD_ITEM_TYPE = 1000;
    private final int FOOT_ITEM_TYPE = 2000;

    private final RecyclerView.Adapter innerAdapter;
    private View headerView;

    public HeaderAdapterWrapper(Context context, RecyclerView.Adapter innerAdapter) {
        this(context, 0, innerAdapter);

    }

    public HeaderAdapterWrapper(Context context, int resId, RecyclerView.Adapter innerAdapter) {
        super(context, resId);
        this.innerAdapter = innerAdapter;
        this.innerAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == HEAD_ITEM_TYPE && headerView != null) {
            return new MyViewHolder(parent.getContext(), headerView);
        }
        return innerAdapter.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (isHeaderView(position) && headerView != null) {
            return;
        }
        innerAdapter.onBindViewHolder(holder, position - 1);
    }

    @Override
    public int getItemCount() {
        if (headerView != null) {
            return innerAdapter.getItemCount() + 1;
        }
        return innerAdapter.getItemCount();
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeaderView(position)) {
            return HEAD_ITEM_TYPE;
        }
        // 此处经过分析不用position-1 也是没有问题的，因为默认返回的值为0，足够区分开两种类型的view
        return innerAdapter.getItemViewType(position - 1);
    }

    public boolean isHeaderView(int position) {
        return position < 1 ? true : false;
    }

    public void addHeaderView(View headerView) {
        this.headerView = headerView;
    }

    @Override
    public void bindData(MyViewHolder holder, int position, Object itemData) {
        //空实现，具体实现留给 innerAdapter
    }
}
