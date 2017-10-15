package com.example.jngoogle.keionbu.fragment.subTabFragment.newSongs;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jngoogle.keionbu.R;

import me.drakeet.multitype.ItemViewBinder;
import me.drakeet.multitype.Items;

/**
 * Created by Administrator on 2017/10/14 0014.
 */
public class CategoryViewBinder extends ItemViewBinder<Category, CategoryViewBinder.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_category, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Category category) {
        holder.bind(category);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView iconIv;
        TextView titleTv;
        TextView moreTv;

        ViewHolder(View itemView) {
            super(itemView);

            iconIv = (ImageView) itemView.findViewById(R.id.iv_icon);
            titleTv = (TextView) itemView.findViewById(R.id.tv_title);
            moreTv = (TextView) itemView.findViewById(R.id.tv_more);
        }

        public void bind(Category category) {
            iconIv.setImageResource(category.icon);
            titleTv.setText(category.title);
        }
    }
}
