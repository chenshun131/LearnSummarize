package com.chenshun.learnsummarize.ui.activity.recyclerview;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chenshun.learnsummarize.App;
import com.chenshun.learnsummarize.R;
import com.chenshun.learnsummarize.data.RecyclerviewData;
import com.chenshun.learnsummarize.ui.activity.base.BaseActivity;
import com.chenshun.learnsummarize.ui.adapter.recyclerview.PullToRefreshAdapter;
import com.chenshun.learnsummarize.ui.view.CustomLoadMoreView;
import com.chenshun.learnsummarize.util.ToastUtil;

/**
 * User: chenshun <p />
 * Time: 17/3/7 13:41  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class PullToRefreshUseActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener
{
    private RecyclerView mListRv;
    private SwipeRefreshLayout mSwipeLayoutSrl;

    private PullToRefreshAdapter mPullToRefreshAdapter;

    private int mCurrentCounter = 0;
    private int delayMillis = 1000;
    private boolean isErr;
    private boolean mLoadMoreEndGone = false;

    private static final int PAGE_SIZE = 6;
    private static final int TOTAL_COUNTER = 18;

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
        setContentView(R.layout.activity_pulltorefresh);
        setTitle("Pull TO Refresh Use");

        mListRv = $(R.id.pulltorefreshuse_list_rv);
        mSwipeLayoutSrl = $(R.id.pulltorefreshuse_swipeLayout_srl);

        // RecyclerView
        mListRv.setLayoutManager(new LinearLayoutManager(this));
        mPullToRefreshAdapter = new PullToRefreshAdapter();
        mPullToRefreshAdapter.setOnLoadMoreListener(this);
        mPullToRefreshAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        mListRv.setAdapter(mPullToRefreshAdapter);
        mListRv.addOnItemTouchListener(new OnItemClickListener()
        {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position)
            {
                ToastUtil.showShortToast(App.getInstance(), Integer.toString(position));
            }
        });
        mCurrentCounter = mPullToRefreshAdapter.getData().size();

        // SwipeRefreshLayout
        mSwipeLayoutSrl.setOnRefreshListener(this);
        mSwipeLayoutSrl.setColorSchemeColors(Color.rgb(47, 223, 189));

        // add Header
        View headView = getLayoutInflater().inflate(R.layout.head_view, (ViewGroup) mListRv.getParent(), false);
        headView.findViewById(R.id.iv).setVisibility(View.GONE);
        ((TextView) headView.findViewById(R.id.tv)).setText("setLoadMoreView");
        headView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mLoadMoreEndGone = true;
                mPullToRefreshAdapter.setLoadMoreView(new CustomLoadMoreView());
                mListRv.setAdapter(mPullToRefreshAdapter);
                Toast.makeText(PullToRefreshUseActivity.this, "change complete", Toast.LENGTH_LONG).show();
            }
        });
        mPullToRefreshAdapter.addHeaderView(headView);
    }

    @Override
    protected void setUI(Configuration newConfig, DisplayMetrics dm)
    {
    }

    @Override
    protected String setFragmentTag()
    {
        return "PullToRefreshUseActivity";
    }

    @Override
    public void onRefresh()
    {
        mPullToRefreshAdapter.setEnableLoadMore(false);
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                mPullToRefreshAdapter.setNewData(RecyclerviewData.getSampleData(PAGE_SIZE));
                isErr = false;
                mCurrentCounter = PAGE_SIZE;
                mSwipeLayoutSrl.setRefreshing(false);
                mPullToRefreshAdapter.setEnableLoadMore(true);
            }
        }, delayMillis);
    }

    @Override
    public void onLoadMoreRequested()
    {
        mSwipeLayoutSrl.setEnabled(false);
        mListRv.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                if (mPullToRefreshAdapter.getData().size() < PAGE_SIZE)
                {
                    mPullToRefreshAdapter.loadMoreEnd(true);
                }
                else
                {
                    if (mCurrentCounter >= TOTAL_COUNTER)
                    {
                        mPullToRefreshAdapter.loadMoreEnd(mLoadMoreEndGone);// true is gone,false is visible
                    }
                    else
                    {
                        if (isErr)
                        {
                            mPullToRefreshAdapter.addData(RecyclerviewData.getSampleData(PAGE_SIZE));
                            mCurrentCounter = mPullToRefreshAdapter.getData().size();
                            mPullToRefreshAdapter.loadMoreComplete();
                        }
                        else
                        {
                            ToastUtil.showShortToast(PullToRefreshUseActivity.this, R.string.network_err);
                            isErr = true;
                            mPullToRefreshAdapter.loadMoreFail();
                        }
                    }
                    mSwipeLayoutSrl.setEnabled(true);
                }
            }
        }, delayMillis);
    }
}
