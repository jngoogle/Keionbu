package com.example.jngoogle.keionbu.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jngoogle.keionbu.R;
import com.example.jngoogle.keionbu.fragment.subTabFragment.NewSongsFragment;
import com.example.jngoogle.keionbu.fragment.subTabFragment.RankingFragment;
import com.example.jngoogle.keionbu.fragment.subTabFragment.SongsListFragment;
import com.example.jngoogle.keionbu.util.Const;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.jngoogle.keionbu.R.id.tabLayout;

public class DiscoverFragment extends Fragment {

    NewSongsFragment newSongsFragment;
    SongsListFragment songsListFragment;
    RankingFragment rankingFragment;
    List<Fragment> subFragmentList;

    @BindView(R.id.vp_content)
    ViewPager contentVp;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_discover, container, false);
        ButterKnife.bind(this, layout);
        initFragment();
        setSubFragmentAdapter();
        return layout;
    }

    private void initFragment() {
        newSongsFragment = new NewSongsFragment();
        songsListFragment = new SongsListFragment();
        rankingFragment = new RankingFragment();

        subFragmentList = new ArrayList<Fragment>();
        subFragmentList.add(newSongsFragment);
        subFragmentList.add(songsListFragment);
        subFragmentList.add(rankingFragment);
    }

    private void setSubFragmentAdapter() {
        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter(getChildFragmentManager(),
                subFragmentList);
        contentVp.setAdapter(myViewPagerAdapter);
        tabLayout.setupWithViewPager(contentVp);
    }

    /**
     * 二级tab 的适配器
     * 新曲、歌单、排行榜
     */
    private class MyViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments;
        private String[] titles = {Const.newSongs, Const.songslist, Const.ranking};

        public MyViewPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        // 添加fragment 的名字
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }

}
