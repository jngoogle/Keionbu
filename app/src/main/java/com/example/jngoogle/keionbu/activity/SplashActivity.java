package com.example.jngoogle.keionbu.activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.jngoogle.keionbu.R;
import com.example.jngoogle.keionbu.util.Const;

import java.util.concurrent.TimeUnit;

import rx.Observable;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // 延迟启动splash
        //        Observable.timer(Const.getDelayTime(), TimeUnit.SECONDS)
        //                .subscribe(new Action1<Long>() {
        //                    @Override
        //                    public void call(Long aLong) {
        //                        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        //                        finish();
        //                    }
        //                });

        /**
         * 延迟启动
         */
        Observable.timer(Const.DELAY_TIME, TimeUnit.SECONDS)
                .subscribe(aLong -> {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                });
    }
}
