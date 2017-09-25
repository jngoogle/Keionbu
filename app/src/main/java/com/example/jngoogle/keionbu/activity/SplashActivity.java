package com.example.jngoogle.keionbu.activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.jngoogle.keionbu.R;
import com.example.jngoogle.keionbu.util.Const;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // delay start
        Observable.timer(Const.DELAY_TIME, TimeUnit.SECONDS)
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        startActivity(new Intent(SplashActivity.this, MainActivity.class));
                        finish();
                    }
                });
    }
}
