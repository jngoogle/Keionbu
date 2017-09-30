package com.example.jngoogle.keionbu.network.serviceManger;

import
        com.example.jngoogle.keionbu.BuildConfig;
import com.example.jngoogle.keionbu.network.service.IAdsPicService;
import com.example.jngoogle.keionbu.network.service.IBillSongListService;
import com.example.jngoogle.keionbu.network.service.IRadioService;
import com.example.jngoogle.keionbu.network.service.ISearchWordsService;
import com.example.jngoogle.keionbu.network.service.ISongListService;

import com.example.jngoogle.keionbu.network.service.ISongsInSongListService;
import com.example.jngoogle.keionbu.util.Const;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
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

    public synchronized static ServiceManger getInstance() {
        return instance != null ? instance : new ServiceManger();
    }

    private OkHttpClient okHttpClient = new OkHttpClient()
            .newBuilder()
            .addInterceptor(new HttpLoggingInterceptor()
                    .setLevel(BuildConfig.DEBUG ?
                            HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE))
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();
                    Request android = request.newBuilder().addHeader("User-Agent:", "Android").build();
                    Response response = chain.proceed(android);
                    return response;
                }
            })
            .build();

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())// use rxjava
            .build();

    // 创建服务
    private IBillSongListService iBillSongListService = retrofit.create(IBillSongListService.class);
    private IAdsPicService iAdsPicService = retrofit.create(IAdsPicService.class);
    private ISearchWordsService iSearchWordsService = retrofit.create(ISearchWordsService.class);
    private ISongListService iSongListService = retrofit.create(ISongListService.class);
    private ISongsInSongListService iSongsInSongListService = retrofit.create(ISongsInSongListService.class);
    private IRadioService iRadioService = retrofit.create(IRadioService.class);


    // 获取榜单歌曲
    public IBillSongListService getBillSongListService() {
        return iBillSongListService;
    }

    // 获取新曲板块中广告位宣传图
    public IAdsPicService getiAdsPicService() {
        return iAdsPicService;
    }

    // 获取搜索热词
    public ISearchWordsService getiSearchWordsService() {
        return iSearchWordsService;
    }

    // 获取新曲板块中的songlist
    public ISongListService getiSongListService() {
        return iSongListService;
    }

    // 获取歌单中的歌曲信息
    public ISongsInSongListService getiSongsInSongListService() {
        return iSongsInSongListService;
    }

    // 获取推荐电台
    public IRadioService getiRadioService() {
        return iRadioService;
    }
}
