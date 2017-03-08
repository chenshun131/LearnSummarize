package com.chenshun.learnsummarize.ui.adapter.recyclerview;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chenshun.learnsummarize.App;
import com.chenshun.learnsummarize.R;
import com.chenshun.learnsummarize.model.ClickModel;
import com.chenshun.learnsummarize.util.Logs;
import com.chenshun.learnsummarize.util.ToastUtil;

import java.util.List;

/**
 * User: chenshun <p />
 * Time: 17/3/8 15:9  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class ItemClickAdapter extends BaseMultiItemQuickAdapter<ClickModel, BaseViewHolder>
{
    NestAdapter nestAdapter;

    public ItemClickAdapter(List<ClickModel> data)
    {
        super(data);
        addItemType(ClickModel.CLICK_ITEM_VIEW, R.layout.item_click_view);
        addItemType(ClickModel.CLICK_ITEM_CHILD_VIEW, R.layout.item_click_childview);
        addItemType(ClickModel.LONG_CLICK_ITEM_VIEW, R.layout.item_long_click_view);
        addItemType(ClickModel.LONG_CLICK_ITEM_CHILD_VIEW, R.layout.item_long_click_childview);
        addItemType(ClickModel.NEST_CLICK_ITEM_CHILD_VIEW, R.layout.item_nest_click);
    }

    @Override
    protected void convert(BaseViewHolder helper, ClickModel item)
    {
        switch (helper.getItemViewType())
        {
            case ClickModel.CLICK_ITEM_VIEW:
                helper.addOnClickListener(R.id.btn);
                break;
            case ClickModel.CLICK_ITEM_CHILD_VIEW:
                helper.addOnClickListener(R.id.iv_num_reduce).addOnClickListener(R.id.iv_num_add).addOnLongClickListener(R.id.iv_num_reduce).addOnLongClickListener(R.id.iv_num_add);
                // set img data
                break;
            case ClickModel.LONG_CLICK_ITEM_VIEW:
                helper.addOnLongClickListener(R.id.btn);
                break;
            case ClickModel.LONG_CLICK_ITEM_CHILD_VIEW:
                helper.addOnLongClickListener(R.id.iv_num_reduce).addOnLongClickListener(R.id.iv_num_add).addOnClickListener(R.id.iv_num_reduce).addOnClickListener(R.id.iv_num_add);
                break;
            case ClickModel.NEST_CLICK_ITEM_CHILD_VIEW:
                helper.setNestView(R.id.item_click); // u can set nestview id
                final RecyclerView recyclerView = helper.getView(R.id.nest_list);
                recyclerView.setLayoutManager(new LinearLayoutManager(helper.getConvertView().getContext(), LinearLayoutManager.VERTICAL, false));
                recyclerView.setHasFixedSize(true);
                nestAdapter = new NestAdapter();
                recyclerView.setAdapter(nestAdapter);
                recyclerView.addOnItemTouchListener(listener);
                break;
        }
    }

    final OnItemClickListener listener = new OnItemClickListener()
    {
        @Override
        public void onSimpleItemClick(final BaseQuickAdapter baseQuickAdapter, final View view, final int i)
        {
            Logs.d("嵌套RecycleView item 收到: " + "点击了第 " + i + " 一次");
            ToastUtil.showShortToast(App.getInstance(), "嵌套RecycleView item 收到: " + "点击了第 " + i + " 一次");
        }

        @Override
        public void onItemChildClick(BaseQuickAdapter adapter, View view, int position)
        {
            ToastUtil.showShortToast(App.getInstance(), "childView click");
        }
    };
}
