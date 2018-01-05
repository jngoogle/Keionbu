package com.example.jngoogle.keionbu.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
//import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jngoogle on 2017/5/1.
 * Email: jammicnicoole@gmail.com
 */

public abstract class CommonRecyclerAdapter<Data> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private int resId;
    private List<Data> dataList;
    private IOnItemClickListener onItemClickListener;

    public CommonRecyclerAdapter(Context context, int resId) {
        this(context, resId, null);
    }

    public CommonRecyclerAdapter(Context context, int resId, List<Data> dataList) {
        this.context = context;
        this.resId = resId;
        this.dataList = dataList;
    }

    /**
     * set datalist for adapter, if you dont want set data in contructor
     * you should set data use this method
     *
     * @param dataList
     */
    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();// 注意此处需要更新列表数据
    }

    public List<Data> getDataList() {
        return dataList;
    }

    public void clearDataList() {
        if (dataList != null) {
            dataList.clear();
            notifyDataSetChanged();
        }
    }

    public void addDataList(List<Data> dataList) {
        if (this.dataList == null) {
            this.dataList = new ArrayList<>();
        }
        this.dataList.addAll(dataList);
        notifyDataSetChanged();
    }

    public abstract void bindData(MyViewHolder holder, int position, Data itemData);

    public void setOnItemClickListener(IOnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(context, LayoutInflater.from(context).inflate(resId, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (dataList == null) {
            return;
        } else {
            bindData((MyViewHolder) holder, position, dataList.get(position));
        }

    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Context context;

        public MyViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            itemView.setOnClickListener(this);
        }

        public <T extends View> T getView(int viewId) {
            View childView = itemView.findViewById(viewId);
            return (T) childView;
        }


        @Override
        public void onClick(View v) {
            if (onItemClickListener != null) {
                onItemClickListener.onClick(itemView, this.getAdapterPosition());
            }
        }

        /**
         * @param viewId
         * @param text
         * @return ViewHolder 方便后续操作可多次调用该方法（连续点）
         */
        public MyViewHolder setText(int viewId, String text) {
            TextView textView = getView(viewId);
            textView.setText(text);
            return this;
        }


        /**
         * 设置textView的文本的颜色
         *
         * @param viewId
         * @param color
         * @return ViewHolder
         */
        public MyViewHolder setTextColor(int viewId, int color) {
            TextView textView = getView(viewId);
            textView.setTextColor(context.getResources().getColor(color));
            return this;
        }


        /**
         * 设置imageView的图像
         *
         * @param viewId
         * @param drawableId
         * @return ViewHolder
         */
        public MyViewHolder setImageResource(int viewId, int drawableId) {
            ImageView imageView = getView(viewId);
            imageView.setImageResource(drawableId);
            return this;
        }

        /**
         * 设置imageView的图像
         *
         * @param viewId
         * @param bm
         * @return ViewHolder
         */
        public MyViewHolder setImageBitmap(int viewId, Bitmap bm) {
            ImageView view = getView(viewId);
            view.setImageBitmap(bm);
            return this;
        }

//        已废弃不用fresco 改用Glide
//        public MyViewHolder setImageUri(int viewId, Uri uri) {
//            SimpleDraweeView view = getView(viewId);
//            view.setImageURI(uri);
//            return this;
//        }

        // use glide to load image by imageuri
        public MyViewHolder setImageUriGlide(int viewId, Uri uri) {
            ImageView imageView = getView(viewId);
            Glide.with(context)
                    .load(uri)
                    .into(imageView);
            return this;
        }

        /**
         * use glide to load image
         * @param viewId
         * @param uri
         * @param placeHolder
         * @return
         */
        public MyViewHolder setImageUriGlide(int viewId, Uri uri, int placeHolder) {
            ImageView imageView = getView(viewId);
            Glide.with(context)
                    .load(uri)
                    .placeholder(placeHolder)
                    .into(imageView);
            return this;
        }

        /**
         * use glide to load image
         *
         * @param viewId
         * @param uri
         * @param placeHolder picture placeholder
         * @param errorId use this pic when network abort
         * @return
         */
        public MyViewHolder setImageUriGlide(int viewId, Uri uri, int placeHolder, int errorId) {
            ImageView imageView = getView(viewId);
            Glide.with(context)
                    .load(uri)
                    .placeholder(placeHolder)
                    .error(errorId)
                    .into(imageView);
            return this;
        }

    }

    /**
     * 点击事件监听器
     */
    public interface IOnItemClickListener {
        void onClick(View view, int position);
    }

}
