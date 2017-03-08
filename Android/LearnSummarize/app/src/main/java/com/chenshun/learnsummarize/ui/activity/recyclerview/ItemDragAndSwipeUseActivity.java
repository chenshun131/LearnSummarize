package com.chenshun.learnsummarize.ui.activity.recyclerview;

import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Message;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import com.chenshun.learnsummarize.R;
import com.chenshun.learnsummarize.ui.activity.base.BaseActivity;
import com.chenshun.learnsummarize.ui.adapter.recyclerview.ItemDragAdapter;
import com.chenshun.learnsummarize.util.Logs;
import com.chenshun.learnsummarize.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * User: chenshun <p />
 * Time: 17/3/7 13:44  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class ItemDragAndSwipeUseActivity extends BaseActivity
{
    private RecyclerView mListRv;

    private ItemDragAdapter mAdapter;

    private List<String> mDataList;

    private ItemTouchHelper mItemTouchHelper;
    private ItemDragAndSwipeCallback mItemDragAndSwipeCallback;

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
        mDataList = new ArrayList(50);
        for (int i = 0; i < 50; i++)
        {
            mDataList.add("item " + i);
        }
    }

    @Override
    protected void initView()
    {
        setContentView(R.layout.base_recycleview);
        setTitle("ItemDrag And Swipe");

        mListRv = $(R.id.base_list_rv);

        OnItemDragListener listener = new OnItemDragListener()
        {
            @Override
            public void onItemDragStart(RecyclerView.ViewHolder viewHolder, int pos)
            {
                Logs.d(TAG, "drag start");
                BaseViewHolder holder = ((BaseViewHolder) viewHolder);
                // holder.setTextColor(R.id.tv, Color.WHITE);
            }

            @Override
            public void onItemDragMoving(RecyclerView.ViewHolder source, int from, RecyclerView.ViewHolder target, int to)
            {
                Logs.d(TAG, "move from: " + source.getAdapterPosition() + " to: " + target.getAdapterPosition());
            }

            @Override
            public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int pos)
            {
                Logs.d(TAG, "drag end");
                BaseViewHolder holder = ((BaseViewHolder) viewHolder);
                // holder.setTextColor(R.id.tv, Color.BLACK);
            }
        };
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextSize(20);
        paint.setColor(Color.BLACK);
        OnItemSwipeListener onItemSwipeListener = new OnItemSwipeListener()
        {
            @Override
            public void onItemSwipeStart(RecyclerView.ViewHolder viewHolder, int pos)
            {
                Log.d(TAG, "view swiped start: " + pos);
                BaseViewHolder holder = ((BaseViewHolder) viewHolder);
                // holder.setTextColor(R.id.tv, Color.WHITE);
            }

            @Override
            public void clearView(RecyclerView.ViewHolder viewHolder, int pos)
            {
                Log.d(TAG, "View reset: " + pos);
                BaseViewHolder holder = ((BaseViewHolder) viewHolder);
                // holder.setTextColor(R.id.tv, Color.BLACK);
            }

            @Override
            public void onItemSwiped(RecyclerView.ViewHolder viewHolder, int pos)
            {
                Log.d(TAG, "View Swiped: " + pos);
            }

            @Override
            public void onItemSwipeMoving(Canvas canvas, RecyclerView.ViewHolder viewHolder, float dX, float dY, boolean isCurrentlyActive)
            {
                canvas.drawColor(ContextCompat.getColor(ItemDragAndSwipeUseActivity.this, R.color.clickspan_color));
                // canvas.drawText("Just some text", 0, 40, paint);
            }
        };

        mAdapter = new ItemDragAdapter(mDataList);
        mItemDragAndSwipeCallback = new ItemDragAndSwipeCallback(mAdapter);
        mItemTouchHelper = new ItemTouchHelper(mItemDragAndSwipeCallback);
        mItemTouchHelper.attachToRecyclerView(mListRv);
        mItemDragAndSwipeCallback.setSwipeMoveFlags(ItemTouchHelper.START | ItemTouchHelper.END);
        mAdapter.enableSwipeItem();
        mAdapter.setOnItemSwipeListener(onItemSwipeListener);
        mAdapter.enableDragItem(mItemTouchHelper);
        mAdapter.setOnItemDragListener(listener);
        mListRv.setLayoutManager(new LinearLayoutManager(this));
        mListRv.setAdapter(mAdapter);
        mListRv.addOnItemTouchListener(new OnItemClickListener()
        {
            @Override
            public void onSimpleItemClick(final BaseQuickAdapter adapter, final View view, final int position)
            {
                ToastUtil.showShortToast(ItemDragAndSwipeUseActivity.this, "点击了" + position);
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
        return "ItemDragAndSwipeUseActivity";
    }
}
