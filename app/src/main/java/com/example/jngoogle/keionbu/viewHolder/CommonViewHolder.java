package com.example.jngoogle.keionbu.viewHolder;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by jngoogle on 2017/2/22 15:11.
 * email: guyuanhaofan@cnicg.cn
 */

public class CommonViewHolder {

    private int mPosition;
    private Context mContext;
    private View mConvertView;
    private SparseArray<View> viewList;//在viewholder中用来存放列表项中的多个控件的数组

    private CommonViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
        mContext = context;
        mPosition = position;
        viewList = new SparseArray<View>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        mConvertView.setTag(this);
    }

    private CommonViewHolder(Context mContext, int layoutId) {
        viewList = new SparseArray<View>();
        mConvertView = LayoutInflater.from(mContext).inflate(layoutId, null);
        mConvertView.setTag(this);

    }

    /**
     * 拿到一个viewholder对象
     *
     * @param context
     * @param convertView
     * @param layoutId
     * @return ViewHolder
     */
    public static CommonViewHolder get(Context context, View convertView, int layoutId) {
        if (convertView == null) {
            return new CommonViewHolder(context, layoutId);
        }

        return (CommonViewHolder) convertView.getTag();
    }


    /**
     * 拿到一个ViewHolder对象
     *
     * @param context
     * @param convertView
     * @param parent
     * @param layoutId
     * @param position
     * @return
     */
    public static CommonViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId, int position) {
        if (convertView == null) {
            return new CommonViewHolder(context, parent, layoutId, position);
        }
        return (CommonViewHolder) convertView.getTag();
    }


    /**
     * 得到当前列表项的布局
     *
     * @return
     */
    public View getConvertView() {
        return mConvertView;
    }


    /**
     * 拿到列表项中的控件
     *
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int viewId) {

        View childView = viewList.get(viewId);
        if (childView == null) {//还未绑定列表项中的控件到viewholder中
            childView = mConvertView.findViewById(viewId);
            viewList.put(viewId, childView);
        }

        return (T) childView;
    }


    /**
     * @param viewId
     * @param text
     * @return ViewHolder 方便后续操作可多次调用该方法（连续点）
     */
    public CommonViewHolder setText(int viewId, String text) {
        TextView textView = getView(viewId);
        textView.setText(text);

        return this;
    }

    public CommonViewHolder setText(int viewId, int text) {
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
    public CommonViewHolder setTextColor(int viewId, int color) {
        TextView textView = getView(viewId);
        textView.setTextColor(mContext.getResources().getColor(color));

        return this;
    }


    /**
     * 设置imageView的图像
     *
     * @param viewId
     * @param drawableId
     * @return ViewHolder
     */
    public CommonViewHolder setImageResource(int viewId, int drawableId) {
        ImageView imageView = getView(viewId);
        imageView.setImageResource(drawableId);

        return this;
    }


    /**
     * 设置imageView的图像
     *
     * @param viewId
     * @param picUrl - 使用Fresco框架加载服务器的图片
     * @return ViewHolder
     */
    public CommonViewHolder setImageResource(int viewId, String picUrl) {
        SimpleDraweeView view = getView(viewId);
        view.setImageURI(Uri.parse(picUrl));

        return this;
    }


    /**
     * 设置imageView的图像
     *
     * @param viewId
     * @param bm
     * @return ViewHolder
     */
    public CommonViewHolder setImageBitmap(int viewId, Bitmap bm) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);

        return this;
    }
}
