package com.example.jngoogle.keionbu.util;

/**
 * Created by jngoogle on 2017/2/21 15:41.
 * email: guyuanhaofan@cnicg.cn
 */

import android.content.Context;
import android.widget.Toast;

import rx.Subscriber;

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
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(Throwable e) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNext(T t) {

    }

}
