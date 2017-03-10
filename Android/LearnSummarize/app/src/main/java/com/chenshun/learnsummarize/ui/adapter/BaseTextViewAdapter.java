package com.chenshun.learnsummarize.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chenshun.learnsummarize.R;

import java.util.List;

/**
 * User: chenshun <p />
 * Time: 17/3/10 8:57 <p />
 * Version V1.0  <p />
 * Description: <p />
 */
public class BaseTextViewAdapter extends BaseQuickAdapter<String, BaseViewHolder>
{
    public BaseTextViewAdapter(List<String> data)
    {
        super(R.layout.item_base_text_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item)
    {
        helper.setText(R.id.tv, item);
    }
}
