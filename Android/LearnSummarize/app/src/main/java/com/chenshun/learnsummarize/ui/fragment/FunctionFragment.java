package com.chenshun.learnsummarize.ui.fragment;

import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle bundle)
    {
        View root = inflater.inflate(R.layout.fragment_function, container, false);
        return root;
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
