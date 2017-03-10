package com.chenshun.learnsummarize.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chenshun.learnsummarize.R;
import com.chenshun.learnsummarize.ui.activity.realm.RealmActivity;
import com.chenshun.learnsummarize.ui.activity.recyclerview.RecycleViewHomeActivity;
import com.chenshun.learnsummarize.ui.activity.textview.TextViewHomeActivity;
import com.chenshun.learnsummarize.ui.adapter.HomeAdapter;
import com.chenshun.learnsummarize.ui.fragment.base.BaseFragment;
import com.chenshun.learnsummarize.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * User: chenshun <p />
 * Time: 17/1/15 19:31 <p />
 * Version V1.0  <p />
 * Description: <p />
 */
public class HomeFragment extends BaseFragment
{
    private List<String> mList;

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
        mList = new ArrayList<>();
        mList.add("Realm for Android");
        mList.add("BaseRecyclerViewAdapterHelper");
        mList.add("TextView");
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle bundle)
    {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView contentRv = (RecyclerView) root.findViewById(R.id.home_content_rv);

        contentRv.setHasFixedSize(true);
        contentRv.setLayoutManager(new LinearLayoutManager(activity));
        HomeAdapter homeAdapter = new HomeAdapter(R.layout.item_home_list, mList);
        homeAdapter.openLoadAnimation();
        contentRv.setAdapter(homeAdapter);
        contentRv.addOnItemTouchListener(new OnItemClickListener()
        {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position)
            {
                switch (position)
                {
                    case 0:// Realm for Android
                        startActivity(new Intent(activity, RealmActivity.class));
                        break;
                    case 1:// BaseRecyclerViewAdapterHelper
                        startActivity(new Intent(activity, RecycleViewHomeActivity.class));
                        break;
                    case 2:// TextView
                        startActivity(new Intent(activity, TextViewHomeActivity.class));
                        break;
                    default:
                        ToastUtil.showShortToast(activity, "HomeFragment 无效列表点击事件");
                        break;
                }
            }
        });
        return root;
    }

    @Override
    protected String setFragmentTag()
    {
        return "HomeFragment";
    }

    public static HomeFragment getInstance(Bundle bundle)
    {
        HomeFragment homeFragment = new HomeFragment();
        if (null != bundle)
        {
            homeFragment.setArguments(bundle);
        }
        return homeFragment;
    }
}
