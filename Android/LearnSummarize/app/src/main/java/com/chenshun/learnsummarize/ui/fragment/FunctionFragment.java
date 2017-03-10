package com.chenshun.learnsummarize.ui.fragment;

import android.os.Bundle;
import android.os.Message;
import android.view.View;

import com.chenshun.learnsummarize.R;
import com.chenshun.learnsummarize.ui.fragment.base.BaseFragment;

/**
 * User: chenshun <p />
 * Time: 17/1/15 21:09 <p />
 * Version V1.0  <p />
 * Description: <p />
 */
public class FunctionFragment extends BaseFragment
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
        return R.layout.fragment_function;
    }

    @Override
    protected void initView(View rootView, Bundle bundle)
    {
    }

    @Override
    protected String setFragmentTag()
    {
        return "FunctionFragment";
    }

    public static FunctionFragment getInstance(Bundle bundle)
    {
        FunctionFragment functionFragment = new FunctionFragment();
        if (null != bundle)
        {
            functionFragment.setArguments(bundle);
        }
        return functionFragment;
    }
}
