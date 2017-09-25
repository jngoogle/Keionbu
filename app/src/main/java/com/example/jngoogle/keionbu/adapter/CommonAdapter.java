package com.example.jngoogle.keionbu.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.jngoogle.keionbu.viewHolder.CommonViewHolder;

import java.util.List;

/**
 * Created by jngoogle on 2017/2/22 15:09.
 * email: guyuanhaofan@cnicg.cn
 */

/**
 * 通用 Adapter
 *
 * @param <B> 实体类（数据类）
 */
public abstract class CommonAdapter<B> extends BaseAdapter {

    protected Context mContext;
    private int mItemLayoutId;
    private List<B> mDataList;//存放实体类的列表（数据存放在实体类中）


    public CommonAdapter(Context mContext, int mItemLayoutId) {
        this(mContext, null, mItemLayoutId);
    }

    public CommonAdapter(Context mContext, List<B> dataList, int itemLayoutId) {
        this.mContext = mContext;
        this.mDataList = dataList;
        this.mItemLayoutId = itemLayoutId;
    }

    public void setDataList(List<B> listData) {
        this.mDataList = listData;
        notifyDataSetChanged();
    }

    public List<B> getDataList() {
        return mDataList;
    }

    @Override
    public int getCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    @Override
    public B getItem(int position) {
        return mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        CommonViewHolder commonViewHolder = CommonViewHolder.get(mContext, convertView, mItemLayoutId);
        B itemData = getItem(position);

        if (position < mDataList.size() && itemData != null) {
            bindData(commonViewHolder, position, itemData);
        }

        return commonViewHolder.getConvertView();
    }

    /**
     * @param commonViewHolder
     * @param position
     * @param itemData
     */
    public abstract void bindData(CommonViewHolder commonViewHolder, int position, B itemData);
}
