package com.example.jngoogle.keionbu.network.service;

/**
 * Created by jngoogle on 2017/9/26.
 * <p>
 * 推荐电台
 */

import com.example.jngoogle.keionbu.network.entity.RadioEntity;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * from:     anroid
 * version:  5.6.5.6
 * format:   json
 * 以上参数非必须
 * <p>
 * =============================
 * <p>
 * method: baidu.ting.radio.getRecommendRadioList 必须的参数
 */
public interface IRadioService {
    @GET("v1/restserver/ting?")
    Observable<RadioEntity> getRadio(@Query("method") String method);
}
