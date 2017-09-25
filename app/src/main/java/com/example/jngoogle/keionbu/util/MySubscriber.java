package com.example.jngoogle.keionbu.util;

/**
 * Created by jngoogle on 2017/2/21 15:41.
 * email: guyuanhaofan@cnicg.cn
 */

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import rx.Subscriber;

import static android.content.ContentValues.TAG;

/**
 * 自定义subscriber 封装一下默认的subscriber
 */
public abstract class MySubscriber<T> extends Subscriber<T> {

    private Context context;
    private String msg;

    public MySubscriber(Context context) {
        this(context, null);
    }

    public MySubscriber(Context context, String msg) {
        this.context = context;
        this.msg = msg;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

        if (e instanceof java.net.ConnectException) {
            Toast.makeText(context, "当前网络不可用", Toast.LENGTH_SHORT).show();
        }

        if (e instanceof IOException) {
            Toast.makeText(context, "当前网络不可用", Toast.LENGTH_SHORT).show();
        }

        if (e instanceof ConnectException) {
            Toast.makeText(context, "当前网络不可用", Toast.LENGTH_SHORT).show();
        }

        if (e instanceof UnknownHostException) {
            Log.d(TAG, "onError: Unable to resolve host \"adsfwe.tunnel.qydev.com\": No address associated with hostname");
        }

        if (e instanceof SocketTimeoutException) {
            Toast.makeText(context, "当前网络较慢，连接失败", Toast.LENGTH_SHORT).show();
        }
    }
}
