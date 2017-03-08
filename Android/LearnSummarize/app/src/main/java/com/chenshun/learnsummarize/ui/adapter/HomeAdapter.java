package com.chenshun.learnsummarize.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chenshun.learnsummarize.R;

import java.util.List;

/**
 * User: chenshun <p />
 * Time: 17/1/15 21:48 <p />
 * Version V1.0  <p />
 * Description: <p />
 */
public class HomeAdapter extends BaseQuickAdapter<String, BaseViewHolder>
{
    public HomeAdapter(int layoutResId, List<String> data)
    {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item)
    {
        helper.setText(R.id.home_content_tv, item);
    }
}
