package com.chenshun.learnsummarize.ui.activity.recyclerview;

import android.content.res.Configuration;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chenshun.learnsummarize.R;
import com.chenshun.learnsummarize.ui.activity.base.BaseActivity;
import com.chenshun.learnsummarize.ui.adapter.recyclerview.HeaderAndFooterAdapter;
import com.chenshun.learnsummarize.util.ToastUtil;

/**
 * User: chenshun <p />
 * Time: 17/3/7 13:40  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class HeaderAndFooterUseActivity extends BaseActivity
{
    private RecyclerView mListRv;

    private HeaderAndFooterAdapter mHeaderAndFooterAdapter;

    private static final int PAGE_SIZE = 3;

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
        setContentView(R.layout.base_recycleview);
        setTitle("HeaderAndFooter Use");

        mListRv = $(R.id.base_list_rv);
        mListRv.setLayoutManager(new LinearLayoutManager(this));

        // RecyclerView
        mHeaderAndFooterAdapter = new HeaderAndFooterAdapter(PAGE_SIZE);
        mHeaderAndFooterAdapter.openLoadAnimation();
        mListRv.addOnItemTouchListener(new OnItemClickListener()
        {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position)
            {
                ToastUtil.showShortToast(HeaderAndFooterUseActivity.this, Integer.toString(position));
            }
        });

        View headerView = getHeaderView(0, new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mHeaderAndFooterAdapter.addHeaderView(getHeaderView(1, getRemoveHeaderListener()), 0);
            }
        });
        mHeaderAndFooterAdapter.addHeaderView(headerView);

        View footerView = getFooterView(0, new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mHeaderAndFooterAdapter.addFooterView(getFooterView(1, getRemoveFooterListener()), 0);
            }
        });
        mHeaderAndFooterAdapter.addFooterView(footerView, 0);

        mListRv.setAdapter(mHeaderAndFooterAdapter);
    }

    @Override
    protected void setUI(Configuration newConfig, DisplayMetrics dm)
    {
    }

    @Override
    protected String setFragmentTag()
    {
        return "HeaderAndFooterUseActivity";
    }

    private View getHeaderView(int type, View.OnClickListener listener)
    {
        View view = getLayoutInflater().inflate(R.layout.head_view, (ViewGroup) mListRv.getParent(), false);
        if (type == 1)
        {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv);
            imageView.setImageResource(R.mipmap.rm_icon);
        }
        view.setOnClickListener(listener);
        return view;
    }

    private View getFooterView(int type, View.OnClickListener listener)
    {
        View view = getLayoutInflater().inflate(R.layout.footer_view, (ViewGroup) mListRv.getParent(), false);
        if (type == 1)
        {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv);
            imageView.setImageResource(R.mipmap.rm_icon);
        }
        view.setOnClickListener(listener);
        return view;
    }

    private View.OnClickListener getRemoveHeaderListener()
    {
        return new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mHeaderAndFooterAdapter.removeHeaderView(v);
            }
        };
    }

    private View.OnClickListener getRemoveFooterListener()
    {
        return new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mHeaderAndFooterAdapter.removeFooterView(v);
            }
        };
    }
}
