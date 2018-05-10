package com.example.jngoogle.keionbu;

import android.app.Application;

//import com.facebook.drawee.backends.pipeline.Fresco;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by jngoogle on 2017/2/10 14:21.
 * email: guyuanhaofan@cnicg.cn
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        initFresco();
        initCustomFont();
    }

//    private void initFresco() {
//        Fresco.initialize(this);
//    }

    private void initCustomFont() {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Roboto-Monospace-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
    }
}
