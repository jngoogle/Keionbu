package com.example.jngoogle.keionbu.fragment.subTabFragment.newSongs;

import android.net.Uri;

/**
 * Created by Administrator on 2017/10/14 0014.
 */
public class Radio {

    Uri coverUri;
    String title;
    String desc;

    public Radio(Uri coverUri, String title, String desc) {
        this.coverUri = coverUri;
        this.title = title;
        this.desc = desc;
    }
}