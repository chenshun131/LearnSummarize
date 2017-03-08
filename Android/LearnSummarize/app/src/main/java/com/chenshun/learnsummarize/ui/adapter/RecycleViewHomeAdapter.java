package com.chenshun.learnsummarize.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chenshun.learnsummarize.R;
import com.chenshun.learnsummarize.model.RecycleViewModel;

import java.util.List;

/**
 * User: chenshun <p />
 * Time: 17/3/7 12:39  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class RecycleViewHomeAdapter extends BaseQuickAdapter<RecycleViewModel, BaseViewHolder>
{
    public RecycleViewHomeAdapter(int layoutResId, List<RecycleViewModel> data)
    {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RecycleViewModel item)
    {
        helper.setText(R.id.recycleview_text_tv, item.getTitle());
        helper.setImageResource(R.id.recycleview_icon_iv, item.getImageResource());
    }
}
