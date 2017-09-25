package com.example.jngoogle.keionbu.network.service;

/**
 * Created by jngoogle on 2017/2/23 15:01.
 * email: guyuanhaofan@cnicg.cn
 */

import com.example.jngoogle.keionbu.network.entity.RankingEntity;
import com.example.jngoogle.keionbu.network.entity.RankingEntity;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 音乐榜歌曲
 */

/**
 * from:     anroid
 * version:  5.6.5.6
 * format:   json
 * fields:   song_id,title,author,album_title,pic_big,pic_small,havehigh,all_rate,charge,has_mv_mobile,learn,song_source,korean_bb_song
 * <p>
 * 以上的参数为非必须，有默认值。需要更改的时候再改版
 */
public interface IBillSongListService {
    @GET("v1/restserver/ting?")
    Observable<RankingEntity> getBillSongList(@Query("method") String method,
                                              @Query("type") int type,
                                              @Query("offset") int offset,
                                              @Query("size") int size);
}
