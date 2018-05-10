package com.example.jngoogle.keionbu.fragment.subTabFragment.newSongs;

import android.net.Uri;

/**
 * Created by jngoogle on 2017/10/17.
 */
public class NewAlbum {

    Uri coverUri;
    String title;
    String author;

    public NewAlbum(Uri coverUri, String title, String author) {
        this.coverUri = coverUri;
        this.title = title;
        this.author = author;
    }
}