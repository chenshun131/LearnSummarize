package com.chenshun.learnsummarize.ui.activity.database;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chenshun.learnsummarize.R;
import com.chenshun.learnsummarize.ui.activity.base.BaseActivity;
import com.chenshun.learnsummarize.ui.activity.database.greendao.GreenDaoActivity;
import com.chenshun.learnsummarize.ui.activity.database.realm.RealmActivity;
import com.chenshun.learnsummarize.ui.adapter.BaseTextViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * User: chenshun <p />
 * Time: 17/3/10 11:27 <p />
 * Version V1.0  <p />
 * Description: <p />
 */
public class DatabaseHomeActivity extends BaseActivity
{
    private RecyclerView mListRv;

    private List<String> mDataList;

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
        mDataList = new ArrayList<>();
        mDataList.add("Realm");
        mDataList.add("GreenDao");
    }

    @Override
    protected void initView()
    {
        setContentView(R.layout.base_recycleview);
        setTitle("Database");

        mListRv = $(R.id.base_list_rv);
        mListRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mListRv.setAdapter(new BaseTextViewAdapter(mDataList));
        mListRv.addOnItemTouchListener(new OnItemClickListener()
        {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position)
            {
                switch (position)
                {
                    case 0:// Realm
                        startActivity(new Intent(DatabaseHomeActivity.this, RealmActivity.class));
                        break;
                    case 1:// GreenDao
                        startActivity(new Intent(DatabaseHomeActivity.this, GreenDaoActivity.class));
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    protected void setUI(Configuration newConfig, DisplayMetrics dm)
    {
    }

    @Override
    protected String setFragmentTag()
    {
        return "DatabaseHomeActivity";
    }
}
