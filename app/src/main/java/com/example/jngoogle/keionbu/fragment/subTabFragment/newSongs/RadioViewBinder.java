package com.example.jngoogle.keionbu.fragment.subTabFragment.newSongs;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jngoogle.keionbu.R;
import com.example.jngoogle.keionbu.util.ActivitiesUtil;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by Administrator on 2017/10/14 0014.
 */
public class RadioViewBinder extends ItemViewBinder<Radio, RadioViewBinder.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_radio, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Radio radio) {
        holder.bind(radio);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView coverIv;
        TextView titleTv;
        TextView descTv;

        ViewHolder(View itemView) {
            super(itemView);
            coverIv = (ImageView) itemView.findViewById(R.id.iv_cover);
            titleTv = (TextView) itemView.findViewById(R.id.tv_title);
            descTv = (TextView) itemView.findViewById(R.id.tv_desc);
        }

        // 这里有关于如何在 viewBinder 中使用Glide 需要得到 context 的问题
        // 只要你能得到一个 view， 使用 view.getContext() 就能够得到 context
        public void bind(Radio radio) {

            Glide.with(ActivitiesUtil.getActivity(coverIv))
                    .load(radio.coverUri)
                    .placeholder(R.mipmap.placeholder_disk_210)
                    .into(coverIv);
            titleTv.setText(radio.title);
            descTv.setText(radio.desc);
        }
    }
}
