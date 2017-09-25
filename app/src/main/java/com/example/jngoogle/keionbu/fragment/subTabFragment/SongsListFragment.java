package com.example.jngoogle.keionbu.fragment.subTabFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jngoogle.keionbu.R;

/**
 * 歌单板块
 */
public class SongsListFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle tanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_songs_list, container, false);
    }

}
