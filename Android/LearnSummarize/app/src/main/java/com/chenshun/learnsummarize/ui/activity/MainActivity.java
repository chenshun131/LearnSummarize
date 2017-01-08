package com.chenshun.learnsummarize.ui.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MenuItem;

import com.chenshun.learnsummarize.R;
import com.chenshun.learnsummarize.constant.Constants;
import com.chenshun.learnsummarize.ui.activity.base.BaseActivity;
import com.chenshun.learnsummarize.ui.util.Cache;
import com.chenshun.learnsummarize.util.ToastUtil;
import com.umeng.analytics.MobclickAgent;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener
{
    private Toolbar mTitleT;
    private DrawerLayout mContainerDl;// 侧边菜单视图
    private NavigationView mNavigationNv;

    private MenuItem mPreMenuItem;
    private ActionBarDrawerToggle mDrawerToggle;// 菜单开关

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
    }

    @Override
    protected void initView()
    {
        setContentView(R.layout.activity_main);

        mTitleT = $(R.id.main_title_t);
        mContainerDl = $(R.id.main_container_dl);
        mNavigationNv = $(R.id.main_navigation_nv);

        mTitleT.setTitle(getString(R.string.homepage));
        setSupportActionBar(mTitleT);
        mNavigationNv.setNavigationItemSelectedListener(this);
        // ActionBarDrawerToggle配合Toolbar，实现Toolbar上菜单按钮开关效果
        mDrawerToggle = new ActionBarDrawerToggle(this, mContainerDl, mTitleT, R.string.drawer_open, R.string.drawer_close);
        mDrawerToggle.syncState();
        mContainerDl.addDrawerListener(mDrawerToggle);
        mTitleT.setNavigationIcon(R.drawable.hamburg_home);

        MobclickAgent.onProfileSignIn(Cache.getInstance().getUserName());

        startActivity(new Intent(this, InitActivity.class));
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
}
