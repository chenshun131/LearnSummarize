package com.chenshun.learnsummarize.ui.adapter.recyclerview;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chenshun.learnsummarize.R;

import java.util.List;

/**
 * User: chenshun <p />
 * Time: 17/3/8 14:55  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class ItemDragAdapter extends BaseItemDraggableAdapter<String, BaseViewHolder>
{
    public ItemDragAdapter(List data)
    {
        super(R.layout.item_draggable_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item)
    {
        switch (helper.getLayoutPosition() % 3)
        {
            case 0:
                helper.setImageResource(R.id.iv_head, R.mipmap.head_img0);
                break;
            case 1:
                helper.setImageResource(R.id.iv_head, R.mipmap.head_img1);
                break;
            case 2:
                helper.setImageResource(R.id.iv_head, R.mipmap.head_img2);
                break;
        }
        helper.setText(R.id.tv, item);
    }
}

