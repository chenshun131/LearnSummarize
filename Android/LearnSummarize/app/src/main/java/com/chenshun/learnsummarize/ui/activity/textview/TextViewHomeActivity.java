package com.chenshun.learnsummarize.ui.activity.textview;

import android.content.res.Configuration;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chenshun.learnsummarize.R;
import com.chenshun.learnsummarize.model.LayoutMultipleItemModel;
import com.chenshun.learnsummarize.ui.activity.base.BaseActivity;
import com.chenshun.learnsummarize.ui.adapter.BaseMultipleAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * User: chenshun <p />
 * Time: 17/3/10 8:32 <p />
 * Version V1.0  <p />
 * Description: <p />
 */
public class TextViewHomeActivity extends BaseActivity
{
    private RecyclerView mListRv;

    private List<LayoutMultipleItemModel> mDataList;

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
        mDataList.add(new LayoutMultipleItemModel(LayoutMultipleItemModel.FadingTextView, "FadingTextView"));
    }

    @Override
    protected void initView()
    {
        setContentView(R.layout.base_recycleview);
        setTitle("TextView");

        mListRv = $(R.id.base_list_rv);

        mListRv.setLayoutManager(new LinearLayoutManager(TextViewHomeActivity.this, LinearLayoutManager.VERTICAL, false));
        mListRv.setAdapter(new BaseMultipleAdapter(mDataList));
        mListRv.addOnItemTouchListener(new OnItemClickListener()
        {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position)
            {
                switch (position)
                {
                    case 0:// FadingTextView
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
        return "TextViewHomeActivity";
    }
}
