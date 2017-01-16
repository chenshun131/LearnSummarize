package com.chenshun.learnsummarize.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chenshun.learnsummarize.R;
import com.chenshun.learnsummarize.ui.activity.realm.RealmActivity;
import com.chenshun.learnsummarize.ui.adapter.HomeAdapter;
import com.chenshun.learnsummarize.ui.adapter.recyclerview.AlphaAnimatorAdapter;
import com.chenshun.learnsummarize.ui.fragment.base.BaseFragment;

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
    private RecyclerView mContentRv;

    private HomeAdapter mHomeAdapter;

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
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle bundle)
    {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        mContentRv = (RecyclerView) root.findViewById(R.id.home_content_rv);

        mContentRv.setLayoutManager(new LinearLayoutManager(activity));
        mHomeAdapter = new HomeAdapter(activity, mList, new HomeAdapter.OnItemClickLitener()
        {
            @Override
            public void onItemClick(View view, int position)
            {
                switch (position)
                {
                    case 0:
                        startActivity(new Intent(activity, RealmActivity.class));
                        break;
                }
            }

            @Override
            public void onItemLongClick(View view, int position)
            {
            }
        });
        mContentRv.setAdapter(new AlphaAnimatorAdapter(mHomeAdapter, mContentRv));

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
