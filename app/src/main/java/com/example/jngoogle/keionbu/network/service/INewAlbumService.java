package com.example.jngoogle.keionbu.network.service;

import com.example.jngoogle.keionbu.network.entity.NewAlbumEntity;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by jngoogle on 2017/10/17.
 */

public interface INewAlbumService {
    @GET("v1/restserver/ting?")
    Observable<NewAlbumEntity> getNewAlbumList(@Query("method") String method);
}
