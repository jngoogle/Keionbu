package com.example.jngoogle.keionbu.adapter;

import android.content.Context;

import com.example.jngoogle.keionbu.R;
import com.example.jngoogle.keionbu.network.entity.RankingEntity;
import com.example.jngoogle.keionbu.viewHolder.CommonViewHolder;

/**
 * Created by jngoogle on 2017/3/29.
 * Email: jammicnicoole@gmail.com
 */


public class RankingAdapter extends CommonAdapter<RankingEntity> {

    private int[] pics;

    /**
     * @param mContext
     * @param mItemLayoutId
     * @param pics          排行榜的图片
     */
    public RankingAdapter(Context mContext, int mItemLayoutId, int[] pics) {
        super(mContext, mItemLayoutId);
        this.pics = pics;
    }

    @Override
    public void bindData(CommonViewHolder commonViewHolder, int position, RankingEntity itemData) {

        if (itemData.getSongList() != null && itemData.getSongList().size() >= 3) {
            int[] ids = new int[]{R.id.tv_no1, R.id.tv_no2, R.id.tv_no3};
            for (int i = 0; i < ids.length; i++) {
                RankingEntity.SongList songList = itemData.getSongList().get(i);
                commonViewHolder.setText(ids[i], songList.getTitle() + "-" + songList.getAuthor());
            }
        }
        commonViewHolder.setImageResource(R.id.draweeView_rankingPic, pics[position]);
    }
}
