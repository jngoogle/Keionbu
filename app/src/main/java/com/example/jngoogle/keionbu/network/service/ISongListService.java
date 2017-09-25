package com.example.jngoogle.keionbu.network.service;

import com.example.jngoogle.keionbu.network.entity.SongMenuEntity;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2017/3/27.
 * <p>
 * from      adnroid
 * <p>
 * version  5.6.5.6
 * <p>
 * format   json
 * <p>
 * 上面为非必须参数
 * <p>
 * method    baidu.ting.diy.gedan
 * <p>
 * page_size    3
 * <p>
 * page_no      1
 */

// 获取全部歌单
public interface ISongListService {
    @GET("v1/restserver/ting?")
    Observable<SongMenuEntity> getSongList(@Query("method") String method,
                                           @Query("page_size") int page_size,// 每页返回的条数
                                           @Query("page_no") int page_no// 当前第几页
    );
}
