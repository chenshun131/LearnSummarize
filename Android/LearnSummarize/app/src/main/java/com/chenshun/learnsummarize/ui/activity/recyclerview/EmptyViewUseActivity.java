package com.chenshun.learnsummarize.ui.activity.recyclerview;

import android.content.res.Configuration;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;

import com.chenshun.learnsummarize.R;
import com.chenshun.learnsummarize.data.RecyclerviewData;
import com.chenshun.learnsummarize.ui.activity.base.BaseActivity;
import com.chenshun.learnsummarize.ui.adapter.recyclerview.QuickAdapter;

/**
 * User: chenshun <p />
 * Time: 17/3/7 13:43  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class EmptyViewUseActivity extends BaseActivity implements View.OnClickListener
{
    private RecyclerView mListRv;

    private QuickAdapter mQuickAdapter;

    private View mNotDataView;
    private View mErrorView;

    private boolean mError = true;
    private boolean mNoData = true;

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
        setContentView(R.layout.activity_empty_view_use);
        setTitle("EmptyView Use");

        mListRv = (RecyclerView) findViewById(R.id.emptyviewuse_list_rv);
        mListRv.setHasFixedSize(true);
        mListRv.setLayoutManager(new LinearLayoutManager(this));
        mQuickAdapter = new QuickAdapter(0);
        mListRv.setAdapter(mQuickAdapter);

        mNotDataView = getLayoutInflater().inflate(R.layout.empty_view, (ViewGroup) mListRv.getParent(), false);
        mNotDataView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onRefresh();
            }
        });
        mErrorView = getLayoutInflater().inflate(R.layout.error_view, (ViewGroup) mListRv.getParent(), false);
        mErrorView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onRefresh();
            }
        });
        onRefresh();

        bindOnClickLister(this, findViewById(R.id.emptyviewuse_reset_fab));
    }

    @Override
    protected void setUI(Configuration newConfig, DisplayMetrics dm)
    {
    }

    @Override
    protected String setFragmentTag()
    {
        return "EmptyViewUseActivity";
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.emptyviewuse_reset_fab:
                mError = true;
                mNoData = true;
                mQuickAdapter.setNewData(null);
                onRefresh();
                break;
        }
    }

    private void onRefresh()
    {
        mQuickAdapter.setEmptyView(R.layout.loading_view, (ViewGroup) mListRv.getParent());
        mHandler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                if (mError)
                {
                    mQuickAdapter.setEmptyView(mErrorView);
                    mError = false;
                }
                else
                {
                    if (mNoData)
                    {
                        mQuickAdapter.setEmptyView(mNotDataView);
                        mNoData = false;
                    }
                    else
                    {
                        mQuickAdapter.setNewData(RecyclerviewData.getSampleData(10));
                    }
                }
            }
        }, 1000);
    }
}
