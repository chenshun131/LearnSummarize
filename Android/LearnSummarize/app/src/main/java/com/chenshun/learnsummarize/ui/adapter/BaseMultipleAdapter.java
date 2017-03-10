package com.chenshun.learnsummarize.ui.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chenshun.learnsummarize.R;
import com.chenshun.learnsummarize.model.LayoutMultipleItemModel;

import java.util.List;

/**
 * User: chenshun <p />
 * Time: 17/3/10 9:42 <p />
 * Version V1.0  <p />
 * Description: <p />
 */
public class BaseMultipleAdapter extends BaseMultiItemQuickAdapter<LayoutMultipleItemModel, BaseViewHolder>
{
    public BaseMultipleAdapter(List<LayoutMultipleItemModel> data)
    {
        super(data);
        addItemType(LayoutMultipleItemModel.FadingTextView, R.layout.item_fadingtextview_list);
    }

    @Override
    protected void convert(BaseViewHolder helper, LayoutMultipleItemModel item)
    {
        helper.setText(R.id.title, item.getTitle());
        switch (item.getItemType())
        {
            case LayoutMultipleItemModel.FadingTextView:
                break;
        }
    }
}
