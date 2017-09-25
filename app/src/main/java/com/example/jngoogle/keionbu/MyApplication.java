package com.example.jngoogle.keionbu;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by jngoogle on 2017/2/10 14:21.
 * email: guyuanhaofan@cnicg.cn
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initFresco();
    }

    private void initFresco() {
        Fresco.initialize(this);
    }
}
