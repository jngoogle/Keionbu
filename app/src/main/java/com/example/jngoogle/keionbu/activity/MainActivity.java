package com.example.jngoogle.keionbu.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.jngoogle.keionbu.R;
import com.example.jngoogle.keionbu.fragment.DiscoverFragment;
import com.example.jngoogle.keionbu.fragment.FriendsFragment;
import com.example.jngoogle.keionbu.fragment.MyMusicFragment;
import com.example.jngoogle.keionbu.util.ExitUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements
        NavigationView.OnNavigationItemSelectedListener,
        RadioGroup.OnCheckedChangeListener {

    private static final String TAG = "testTab";

    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.toolbar_main)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    // toolbar 主页面tab 组件
    @BindView(R.id.rb_discover)
    RadioButton discoverRb;
    @BindView(R.id.rb_my_music)
    RadioButton myMusicRb;
    @BindView(R.id.rb_friends)
    RadioButton friendsRb;
    @BindView(R.id.rb_search)
    RadioButton searchRb;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;

    private int lastTabId = R.id.rb_discover;// 初始化
    private static final int discover = 0, myMusic = 1, friends = 2;

    DiscoverFragment discoverFragment;
    FriendsFragment friendsFragment;
    MyMusicFragment myMusicFragment;
    FragmentManager fmgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // 解决抽屉布局 沉浸式标题栏问题
        // http://www.jianshu.com/p/34a8b40b9308
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            drawerLayout.setFitsSystemWindows(true);
            drawerLayout.setClipToPadding(false);
        }


        fmgr = getSupportFragmentManager();
        showFragment(discover);
        radioGroup.setOnCheckedChangeListener(this);// 配置tab 的监听事件
        setSupportActionBar(toolbar);
        setDrawerAndNavi();
    }

    /**
     * 设置抽屉和菜单项的头部
     */
    private void setDrawerAndNavi() {
        setDrawerToggle();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);// 设置抽屉菜单的图标颜色（使用原本的颜色）
    }

    /**
     * 监听抽屉开关事件
     */
    private void setDrawerToggle() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
    }

    /**
     * 连按两次后退键退出App
     */
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {// 抽屉打开了就由抽屉先消费此后退事件
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            if (!ExitUtil.exitApp()) {// 再按一次退出
                Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
            } else {
                finish();
                System.exit(0);
            }
        }
    }
    //        @Override
    //        public boolean onCreateOptionsMenu(Menu menu) {
    //            // Inflate the menu; this adds items to the action bar if it is present.
    //            getMenuInflater().inflate(R.menu.main, menu);
    //            return true;
    //        }

    //    @Override
    //    public boolean onOptionsItemSelected(MenuItem item) {
    //        // Handle action bar item clicks here. The action bar will
    //        // automatically handle clicks on the Home/Up button, so long
    //        // as you specify a parent activity in AndroidManifest.xml.
    //        int id = item.getItemId();
    //
    //        //noinspection SimplifiableIfStatement
    //        if (id == R.id.action_settings) {
    //            return true;
    //        }
    //
    //        return super.onOptionsItemSelected(item);
    //    }

    /**
     * 菜单项 点击事件
     *
     * @param item
     * @return
     */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_night://night theme
                break;

            case R.id.nav_skin:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra("intent_key", "test share text to other app");
                sendIntent.setType("text/plain");

                if (sendIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(Intent.createChooser(sendIntent, "send this string to ..."));
                }
                break;

            case R.id.nav_time:
                break;

            case R.id.nav_download:
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        if (checkedId != R.id.rb_search) {
            lastTabId = checkedId;
        }
        switch (checkedId) {
            case R.id.rb_discover:
                showFragment(discover);
                break;

            case R.id.rb_my_music:
                showFragment(myMusic);
                break;

            case R.id.rb_friends:
                showFragment(friends);
                break;

            case R.id.rb_search:
                searchRb.setChecked(false);
                ((RadioButton) radioGroup.findViewById(lastTabId)).setChecked(true);
                startActivity(new Intent(MainActivity.this, SearchActivity.class));
                break;
        }
    }

    private void showFragment(int tabId) {
        hideAllFragment();
        switch (tabId) {
            case discover:
                if (discoverFragment == null) {
                    discoverFragment = new DiscoverFragment();
                    fmgr.beginTransaction().add(R.id.fg_content, discoverFragment).commit();
                } else {
                    fmgr.beginTransaction().show(discoverFragment).commit();
                    Log.d(TAG, "showFragment: discover exe");
                }
                break;

            case myMusic:
                if (myMusicFragment == null) {
                    myMusicFragment = new MyMusicFragment();
                    fmgr.beginTransaction().add(R.id.fg_content, myMusicFragment).commit();
                } else {
                    fmgr.beginTransaction().show(myMusicFragment).commit();
                    Log.d(TAG, "showFragment: music exe");
                }
                break;

            case friends:
                if (friendsFragment == null) {
                    friendsFragment = new FriendsFragment();
                    fmgr.beginTransaction().add(R.id.fg_content, friendsFragment).commit();
                } else {
                    fmgr.beginTransaction().show(friendsFragment).commit();
                    Log.d(TAG, "showFragment: friends exe");
                }
                break;
        }
    }

    private void hideAllFragment() {
        if (discoverFragment != null) {
            fmgr.beginTransaction().hide(discoverFragment).commit();
        }

        if (myMusicFragment != null) {
            fmgr.beginTransaction().hide(myMusicFragment).commit();
        }

        if (friendsFragment != null) {
            fmgr.beginTransaction().hide(friendsFragment).commit();
        }
    }

}
