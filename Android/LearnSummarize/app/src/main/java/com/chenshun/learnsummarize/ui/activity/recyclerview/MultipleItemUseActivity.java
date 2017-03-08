package com.chenshun.learnsummarize.ui.activity.recyclerview;

import android.content.res.Configuration;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chenshun.learnsummarize.R;
import com.chenshun.learnsummarize.data.RecyclerviewData;
import com.chenshun.learnsummarize.model.MultipleItemModel;
import com.chenshun.learnsummarize.ui.activity.base.BaseActivity;
import com.chenshun.learnsummarize.ui.adapter.recyclerview.MultipleItemQuickAdapter;

import java.util.List;

/**
 * User: chenshun <p />
 * Time: 17/3/7 13:39  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class MultipleItemUseActivity extends BaseActivity
{
    private RecyclerView mListRv;

    private List<MultipleItemModel> mDataList;

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
        mDataList = RecyclerviewData.getMultipleItemData();
    }

    @Override
    protected void initView()
    {
        setContentView(R.layout.base_recycleview);
        setTitle("Multiple Use");

        mListRv = $(R.id.base_list_rv);

        MultipleItemQuickAdapter multipleItemAdapter = new MultipleItemQuickAdapter(this, mDataList);
        mListRv.setLayoutManager(new GridLayoutManager(this, 4));
        mListRv.setAdapter(multipleItemAdapter);
        multipleItemAdapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup()
        {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position)
            {
                return mDataList.get(position).getSpanSize();
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
        return "MultipleItemUseActivity";
    }
}
