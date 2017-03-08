package com.chenshun.learnsummarize.ui.adapter.recyclerview;

import android.content.Context;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chenshun.learnsummarize.R;
import com.chenshun.learnsummarize.model.MultipleItemModel;

import java.util.List;

/**
 * User: chenshun <p />
 * Time: 17/3/8 9:28  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class MultipleItemQuickAdapter extends BaseMultiItemQuickAdapter<MultipleItemModel, BaseViewHolder>
{
    public MultipleItemQuickAdapter(Context context, List<MultipleItemModel> data)
    {
        super(data);
        addItemType(MultipleItemModel.TEXT, R.layout.item_text_list);
        addItemType(MultipleItemModel.IMG, R.layout.item_image_list);
        addItemType(MultipleItemModel.IMG_TEXT, R.layout.item_image_text_list);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultipleItemModel item)
    {
        switch (helper.getItemViewType())
        {
            case MultipleItemModel.TEXT:
                helper.setText(R.id.tv, item.getContent());
                break;
            case MultipleItemModel.IMG:
                if (helper.getLayoutPosition() % 2 == 0)
                {
                    helper.setImageResource(R.id.iv, R.mipmap.animation_img1);
                }
                else
                {
                    helper.setImageResource(R.id.iv, R.mipmap.animation_img2);
                }
                break;
            case MultipleItemModel.IMG_TEXT:
                helper.setText(R.id.tv, item.getContent());
                if (helper.getLayoutPosition() % 2 == 0)
                {
                    helper.setImageResource(R.id.iv, R.mipmap.animation_img1);
                }
                else
                {
                    helper.setImageResource(R.id.iv, R.mipmap.animation_img2);
                }
                break;
            default:
                break;
        }
    }
}
