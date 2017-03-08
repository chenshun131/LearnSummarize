package com.chenshun.learnsummarize.ui.activity.recyclerview;

import android.content.res.Configuration;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chenshun.learnsummarize.R;
import com.chenshun.learnsummarize.model.ClickModel;
import com.chenshun.learnsummarize.ui.activity.base.BaseActivity;
import com.chenshun.learnsummarize.ui.adapter.recyclerview.ItemClickAdapter;
import com.chenshun.learnsummarize.util.Logs;
import com.chenshun.learnsummarize.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * User: chenshun <p />
 * Time: 17/3/7 13:45  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class ItemClickActivity extends BaseActivity
{
    private RecyclerView mListRv;

    private ItemClickAdapter mItemClickAdapter;

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
        setTitle("ItemDrag And Swipe");

        mListRv = $(R.id.base_list_rv);

        mListRv.setLayoutManager(new LinearLayoutManager(this));
        List<ClickModel> data = new ArrayList<>();
        data.add(new ClickModel(ClickModel.CLICK_ITEM_VIEW));
        data.add(new ClickModel(ClickModel.CLICK_ITEM_CHILD_VIEW));
        data.add(new ClickModel(ClickModel.LONG_CLICK_ITEM_VIEW));
        data.add(new ClickModel(ClickModel.LONG_CLICK_ITEM_CHILD_VIEW));
        data.add(new ClickModel(ClickModel.NEST_CLICK_ITEM_CHILD_VIEW));
        mItemClickAdapter = new ItemClickAdapter(data);
        mItemClickAdapter.openLoadAnimation();
        mListRv.setAdapter(mItemClickAdapter);
        mListRv.addOnItemTouchListener(new OnItemClickListener()
        {
            /**
             * Callback method to be invoked when an item in this AdapterView has
             * been clicked.
             *
             * @param view     The view within the AdapterView that was clicked (this
             *                 will be a view provided by the adapter)
             * @param position The position of the view in the adapter.
             */
            @Override
            public void onSimpleItemClick(final BaseQuickAdapter adapter, final View view, final int position)
            {
                Logs.d(TAG, "SimpleOnItemClick: ");
                ToastUtil.showShortToast(ItemClickActivity.this, "onSimpleItemClick" + position);
            }

            /**
             * callback method to be invoked when an chidview in this view has been
             * click and held
             *
             * @param view     The view whihin the AbsListView that was clicked
             * @param position The position of the view int the adapter
             * @return true if the callback consumed the long click ,false otherwise
             */
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position)
            {
                Logs.d("onItemChildClick " + position + " be click");
                ToastUtil.showShortToast(ItemClickActivity.this, "onItemChildClick" + position);
            }

            /**
             * Callback method to be invoked when an item in this view has been clicked and held.
             * @param adapter
             * @param view
             * @param position
             */
            @Override
            public void onItemLongClick(final BaseQuickAdapter adapter, final View view, final int position)
            {
                ToastUtil.showShortToast(ItemClickActivity.this, "onItemLongClick" + position);
            }

            /**
             * Callback method to be invoked when an itemchild in this view has been clicked and held.
             * @param adapter
             * @param view
             * @param position
             */
            @Override
            public void onItemChildLongClick(final BaseQuickAdapter adapter, final View view, final int position)
            {
                ToastUtil.showShortToast(ItemClickActivity.this, "onItemChildLongClick" + position);
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
        return "ItemClickActivity";
    }
}
