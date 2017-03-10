package com.chenshun.learnsummarize.ui.fragment;

import android.os.Bundle;
import android.os.Message;
import android.view.View;

import com.chenshun.learnsummarize.R;
import com.chenshun.learnsummarize.ui.fragment.base.BaseFragment;

/**
 * User: chenshun <p />
 * Time: 17/1/15 21:11 <p />
 * Version V1.0  <p />
 * Description: <p />
 */
public class SettingFragment extends BaseFragment
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
    protected void initData(Bundle bundle)
    {
    }

    @Override
    protected int setLayout()
    {
        return R.layout.fragment_setting;
    }

    @Override
    protected void initView(View rootView, Bundle bundle)
    {
    }

    @Override
    protected String setFragmentTag()
    {
        return "SettingFragment";
    }

    public static SettingFragment getInstance(Bundle bundle)
    {
        SettingFragment settingFragment = new SettingFragment();
        if (null != bundle)
        {
            settingFragment.setArguments(bundle);
        }
        return settingFragment;
    }
}
