package com.chenshun.learnsummarize.ui.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Message;
import android.util.DisplayMetrics;

import com.chenshun.learnsummarize.R;
import com.chenshun.learnsummarize.constant.SPConst;
import com.chenshun.learnsummarize.service.CoreService;
import com.chenshun.learnsummarize.ui.activity.base.BaseActivity;
import com.chenshun.learnsummarize.util.AppUtils;
import com.chenshun.learnsummarize.util.PreferensesUtil;

/**
 * User: chenshun <p />
 * Time: 16/10/18 16:07  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class InitActivity extends BaseActivity
{
    private PreferensesUtil mPreferensesUtil;
    private String mVersionName;
    private int mLocalAppVersionCode;

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
        mPreferensesUtil = new PreferensesUtil(InitActivity.this, SPConst.SP_USER);
        mVersionName = AppUtils.getVerName(InitActivity.this);
        mLocalAppVersionCode = AppUtils.getVerCode(InitActivity.this);// 本地版本序号

        // 初始化 CoreService
        Intent intent = new Intent(InitActivity.this, CoreService.class);
        startService(intent);
    }

    @Override
    protected void initView()
    {
        setContentView(R.layout.activity_init);
    }

    @Override
    protected void setUI(Configuration newConfig, DisplayMetrics dm)
    {
    }

    @Override
    protected String setFragmentTag()
    {
        return "InitActivity";
    }
}
