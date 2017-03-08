package com.chenshun.learnsummarize.ui.adapter.recyclerview;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chenshun.learnsummarize.R;
import com.chenshun.learnsummarize.data.RecyclerviewData;
import com.chenshun.learnsummarize.model.StatusModel;

/**
 * User: chenshun <p />
 * Time: 17/3/8 14:20  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class QuickAdapter extends BaseQuickAdapter<StatusModel, BaseViewHolder>
{
    public QuickAdapter(int dataSize)
    {
        super(R.layout.item_emptyviewuse_list, RecyclerviewData.getSampleData(dataSize));
    }

    @Override
    protected void convert(BaseViewHolder helper, StatusModel item)
    {
        switch (helper.getLayoutPosition() % 3)
        {
            case 0:
                helper.setImageResource(R.id.img, R.mipmap.animation_img1);
                break;
            case 1:
                helper.setImageResource(R.id.img, R.mipmap.animation_img2);
                break;
            case 2:
                helper.setImageResource(R.id.img, R.mipmap.animation_img3);
                break;
        }
        helper.setText(R.id.tweetName, "Hoteis in Rio de Janeiro");
        helper.setText(R.id.tweetText, "O ever youthful,O ever weeping");
    }
}
