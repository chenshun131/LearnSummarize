package com.chenshun.learnsummarize.ui.activity;

import android.content.res.Configuration;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.chenshun.learnsummarize.R;
import com.chenshun.learnsummarize.constant.Constants;
import com.chenshun.learnsummarize.ui.activity.base.BaseActivity;
import com.chenshun.learnsummarize.ui.fragment.FunctionFragment;
import com.chenshun.learnsummarize.ui.fragment.HomeFragment;
import com.chenshun.learnsummarize.ui.fragment.SettingFragment;
import com.chenshun.learnsummarize.ui.util.Cache;
import com.chenshun.learnsummarize.ui.view.NoScrollViewPager;
import com.chenshun.learnsummarize.util.ToastUtil;
import com.umeng.analytics.MobclickAgent;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener
{
    private Toolbar mTitleT;
    private DrawerLayout mContainerDl;// 侧边菜单视图
    private NavigationView mNavigationNv;
    private NoScrollViewPager mContainerNsvp;
    private Button mHomeB;
    private Button mFunctionB;
    private Button mSettingB;

    private MenuItem mPreMenuItem;
    private ActionBarDrawerToggle mDrawerToggle;// 菜单开关
    private List<Fragment> mFragmentList;
    private int currentMainIndex = -1;

    private FragmentManager mFragmentManager;

    private long exitTime = 0;

    @Override
    public boolean handleNotifyMessage(Message msg)
    {
        return false;
    }

    @Override
    public boolean handleUIMessage(Message msg)
    {
        return false;
    }

    @Override
    public boolean handleMessage(Message msg)
    {
        return false;
    }

    @Override
    protected void initData()
    {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(HomeFragment.getInstance(null));
        mFragmentList.add(FunctionFragment.getInstance(null));
        mFragmentList.add(SettingFragment.getInstance(null));
    }

    @Override
    protected void initView()
    {
        setContentView(R.layout.activity_main);

        mTitleT = $(R.id.main_title_t);
        mContainerDl = $(R.id.main_container_dl);
        mNavigationNv = $(R.id.main_navigation_nv);
        mContainerNsvp = $(R.id.main_container_nsvp);
        mHomeB = $(R.id.main_home_b);
        mFunctionB = $(R.id.main_function_b);
        mSettingB = $(R.id.main_setting_b);

        mContainerNsvp.setOffscreenPageLimit(3);
        mContainerNsvp.setAdapter(new MyFrageStatePagerAdapter(getSupportFragmentManager(), mFragmentList));
        mContainerNsvp.setCurrentItem(0);

        mTitleT.setTitle(getString(R.string.homepage));
        setSupportActionBar(mTitleT);
        mNavigationNv.setNavigationItemSelectedListener(this);
        // ActionBarDrawerToggle配合Toolbar，实现Toolbar上菜单按钮开关效果
        mDrawerToggle = new ActionBarDrawerToggle(this, mContainerDl, mTitleT, R.string.drawer_open, R.string.drawer_close);
        mDrawerToggle.syncState();
        mContainerDl.addDrawerListener(mDrawerToggle);
        mTitleT.setNavigationIcon(R.mipmap.hamburg_home);

        bindOnClickLister(this, mHomeB, mFunctionB, mSettingB);
        MobclickAgent.onProfileSignIn(Cache.getInstance().getUserName());
    }

    @Override
    protected void setUI(Configuration newConfig, DisplayMetrics dm)
    {
    }

    @Override
    protected String setFragmentTag()
    {
        return "MainActivity";
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event)
    {
        switch (keyCode)
        {
            case KeyEvent.KEYCODE_BACK:
                long secondTime = System.currentTimeMillis();
                if ((secondTime - exitTime) > Constants.BACK_TIME)
                {
                    ToastUtil.showShortToast(MainActivity.this, "再按一次退出程序");
                    exitTime = secondTime;
                    return true;
                }
                else
                {
                    finish();
                }
                break;
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        if (mPreMenuItem != null)
        {
            mPreMenuItem.setChecked(false);
        }
        switch (item.getItemId())
        {
            case R.id.navigation_item_home:// 首页
                mTitleT.setTitle(getString(R.string.homepage));
                break;
            case R.id.navigation_item_source:// 干货
                mTitleT.setTitle(getString(R.string.welfare));
                break;
            case R.id.navigation_item_blog:// 博客
                mTitleT.setTitle(getString(R.string.my_blog));
                break;
            case R.id.navigation_item_custom_view:// 自定义View
                mTitleT.setTitle(getString(R.string.customer_view));
                break;
            case R.id.navigation_item_snackbar:// Snaclbar演示
                mTitleT.setTitle(getString(R.string.snackbar_demo));
                break;
            case R.id.navigation_item_switch_theme:// 主题切换
                mTitleT.setTitle(getString(R.string.topics_skin));
                break;
            case R.id.navigation_item_about:// 关于
                mTitleT.setTitle(getString(R.string.about));
                break;
        }
        return false;
    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.main_home_b:
                mContainerNsvp.setCurrentItem(0);
                break;
            case R.id.main_function_b:
                mContainerNsvp.setCurrentItem(1);
                break;
            case R.id.main_setting_b:
                mContainerNsvp.setCurrentItem(2);
                break;
        }
    }

    private class MyFrageStatePagerAdapter extends FragmentStatePagerAdapter
    {
        private List<Fragment> mFragmentList;

        public MyFrageStatePagerAdapter(FragmentManager fm, List<Fragment> fragmentList)
        {
            super(fm);
            mFragmentList = fragmentList;
        }

        @Override
        public Fragment getItem(int position)
        {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount()
        {
            return mFragmentList.size();
        }

        @Override
        public void finishUpdate(ViewGroup container)
        {
            super.finishUpdate(container);
            int currentItem = mContainerNsvp.getCurrentItem();
            if (currentItem == currentMainIndex)
            {
                return;
            }
            switch (currentMainIndex)
            {
                case 0:
                    setButtonState(mHomeB, false);
                    break;
                case 1:
                    setButtonState(mFunctionB, false);
                    break;
                case 2:
                    setButtonState(mSettingB, false);
                    break;
            }
            switch (currentItem)
            {
                case 0:
                    setButtonState(mHomeB, true);
                    break;
                case 1:
                    setButtonState(mFunctionB, true);
                    break;
                case 2:
                    setButtonState(mSettingB, true);
                    break;
            }
            currentMainIndex = currentItem;
        }
    }

    private void setButtonState(Button btn, boolean isCheck)
    {
        if (isCheck)
        {
            btn.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimaryDark));
            btn.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white));
        }
        else
        {
            btn.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.white));
            btn.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimaryDark));
        }
    }
}
