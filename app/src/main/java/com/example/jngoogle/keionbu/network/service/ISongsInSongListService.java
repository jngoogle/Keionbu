package com.example.jngoogle.keionbu.network.service;

import com.example.jngoogle.keionbu.network.entity.SongMenuEntity;
import com.example.jngoogle.keionbu.network.entity.SongsInSongListEntity;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by jngoogle on 2017/5/18.
 * Email: jammicnicoole@gmail.com
 */

// 歌单中的歌曲
public interface ISongsInSongListService {
    @GET("v1/restserver/ting?")
    Observable<SongsInSongListEntity> getSongsInSongList(@Query("method") String method,
                                                         @Query("listid") String listid);
}
