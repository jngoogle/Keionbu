package com.example.jngoogle.keionbu.network.serviceManger;

import com.example.jngoogle.keionbu.BuildConfig;
import com.example.jngoogle.keionbu.network.service.IBillSongListService;
import com.example.jngoogle.keionbu.util.Const;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jngoogle on 2017/2/23 11:08.
 * email: guyuanhaofan@cnicg.cn
 */

public class ServiceManger {

    private String BASE_URL = Const.BASE_URL;
    private static ServiceManger instance;

    public static ServiceManger getInstance() {
        return instance != null ? instance : new ServiceManger();
    }

    private OkHttpClient okHttpClient = new OkHttpClient()
            .newBuilder()
            .addInterceptor(new HttpLoggingInterceptor()
                    .setLevel(BuildConfig.DEBUG ?
                            HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE))
            .build();

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())// use rxjava
            .build();

    // 创建服务
    private IBillSongListService iBillSongListService = retrofit.create(IBillSongListService.class);

    //获取榜单歌曲
    public IBillSongListService getBillSongListService() {
        return iBillSongListService;
    }
}
