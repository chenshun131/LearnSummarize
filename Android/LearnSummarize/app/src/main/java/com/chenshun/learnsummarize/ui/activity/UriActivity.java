package com.chenshun.learnsummarize.ui.activity;

import android.content.res.Configuration;
import android.os.Message;
import android.util.DisplayMetrics;

import com.chenshun.learnsummarize.ui.activity.base.BaseActivity;

/**
 * User: chenshun <p />
 * Time: 16/12/8 06:56 <p />
 * Version V1.0  <p />
 * Description: <p />
 */
public class UriActivity extends BaseActivity
{
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

    }

    @Override
    protected void setUI(Configuration newConfig, DisplayMetrics dm)
    {

    }

    @Override
    protected String setFragmentTag()
    {
        return null;
    }
}
