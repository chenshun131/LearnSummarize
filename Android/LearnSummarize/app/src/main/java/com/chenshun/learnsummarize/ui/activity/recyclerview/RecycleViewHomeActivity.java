package com.chenshun.learnsummarize.ui.activity.recyclerview;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chenshun.learnsummarize.R;
import com.chenshun.learnsummarize.model.RecycleViewModel;
import com.chenshun.learnsummarize.ui.activity.base.BaseActivity;
import com.chenshun.learnsummarize.ui.adapter.RecycleViewHomeAdapter;

import java.util.ArrayList;

/**
 * User: chenshun <p />
 * Time: 17/3/7 11:50  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class RecycleViewHomeActivity extends BaseActivity
{
    private RecyclerView mListRv;

    private ArrayList<RecycleViewModel> mDataList;

    private static final Class<?>[] ACTIVITY = {AnimationUseActivity.class, MultipleItemUseActivity.class, HeaderAndFooterUseActivity.class, PullToRefreshUseActivity.class, SectionUseActivity.class, EmptyViewUseActivity.class, ItemDragAndSwipeUseActivity.class, ItemClickActivity.class, ExpandableUseActivity.class, DataBindingUseActivity.class};
    private static final String[] TITLE = {"Animation", "MultipleItem", "Header/Footer", "PullToRefresh", "Section", "EmptyView", "DragAndSwipe", "ItemClick", "ExpandableItem", "DataBinding"};
    private static final int[] IMG = {R.mipmap.gv_animation, R.mipmap.gv_multipleltem, R.mipmap.gv_header_and_footer, R.mipmap.gv_pulltorefresh, R.mipmap.gv_section, R.mipmap.gv_empty, R.mipmap.gv_drag_and_swipe, R.mipmap.gv_item_click, R.mipmap.gv_expandable, R.mipmap.gv_databinding,};

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
        for (int i = 0; i < TITLE.length; i++)
        {
            RecycleViewModel item = new RecycleViewModel();
            item.setTitle(TITLE[i]);
            item.setActivity(ACTIVITY[i]);
            item.setImageResource(IMG[i]);
            mDataList.add(item);
        }
    }

    @Override
    protected void initView()
    {
        setContentView(R.layout.base_recycleview);
        setTitle("BaseRecyclerViewAdapterHelper");

        mListRv = $(R.id.base_list_rv);

        mListRv.setLayoutManager(new GridLayoutManager(this, 2));
        BaseQuickAdapter homeAdapter = new RecycleViewHomeAdapter(R.layout.recycle_view_item_view, mDataList);
        homeAdapter.openLoadAnimation();
        View top = getLayoutInflater().inflate(R.layout.recycle_view_top_view, (ViewGroup) mListRv.getParent(), false);
        homeAdapter.addHeaderView(top);
        mListRv.addOnItemTouchListener(new OnItemClickListener()
        {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position)
            {
                startActivity(new Intent(RecycleViewHomeActivity.this, ACTIVITY[position]));
            }
        });
        mListRv.setAdapter(homeAdapter);
    }

    @Override
    protected void setUI(Configuration newConfig, DisplayMetrics dm)
    {
    }

    @Override
    protected String setFragmentTag()
    {
        return "RecycleViewHomeActivity";
    }
}
