package com.chenshun.learnsummarize.ui.activity.recyclerview;

import android.content.res.Configuration;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.DisplayMetrics;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chenshun.learnsummarize.R;
import com.chenshun.learnsummarize.data.RecyclerviewData;
import com.chenshun.learnsummarize.model.SectionModel;
import com.chenshun.learnsummarize.ui.activity.base.BaseActivity;
import com.chenshun.learnsummarize.ui.adapter.recyclerview.SectionAdapter;
import com.chenshun.learnsummarize.util.ToastUtil;

import java.util.List;

/**
 * User: chenshun <p />
 * Time: 17/3/7 13:42  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class SectionUseActivity extends BaseActivity
{
    private RecyclerView mListRv;

    private List<SectionModel> mDataList;

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
        mDataList = RecyclerviewData.getSampleData();
    }

    @Override
    protected void initView()
    {
        setContentView(R.layout.base_recycleview);
        setTitle("Section Use");

        // RecyclerView
        mListRv = (RecyclerView) findViewById(R.id.base_list_rv);
        mListRv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        SectionAdapter sectionAdapter = new SectionAdapter(R.layout.item_section_content, R.layout.def_section_head, mDataList);
        mListRv.setAdapter(sectionAdapter);
        mListRv.addOnItemTouchListener(new OnItemClickListener()
        {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position)
            {
                SectionModel section = mDataList.get(position);
                if (section.isHeader)
                {
                    ToastUtil.showShortToast(SectionUseActivity.this, section.header);
                }
                else
                {
                    ToastUtil.showShortToast(SectionUseActivity.this, section.t.getName());
                }
            }

            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position)
            {
                ToastUtil.showShortToast(SectionUseActivity.this, "onItemChildClick" + position);
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
        return "SectionUseActivity";
    }
}
