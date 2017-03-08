package com.chenshun.learnsummarize.ui.adapter.recyclerview;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chenshun.learnsummarize.R;
import com.chenshun.learnsummarize.data.RecyclerviewData;
import com.chenshun.learnsummarize.model.StatusModel;

/**
 * User: chenshun <p />
 * Time: 17/3/8 10:9  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class HeaderAndFooterAdapter extends BaseQuickAdapter<StatusModel, BaseViewHolder>
{
    public HeaderAndFooterAdapter(int dataSize)
    {
        super(R.layout.item_header_and_footer, RecyclerviewData.getSampleData(dataSize));
    }

    @Override
    protected void convert(BaseViewHolder helper, StatusModel item)
    {
        switch (helper.getLayoutPosition() % 3)
        {
            case 0:
                helper.setImageResource(R.id.iv, R.mipmap.animation_img1);
                break;
            case 1:
                helper.setImageResource(R.id.iv, R.mipmap.animation_img2);
                break;
            case 2:
                helper.setImageResource(R.id.iv, R.mipmap.animation_img3);
                break;
        }
    }
}
