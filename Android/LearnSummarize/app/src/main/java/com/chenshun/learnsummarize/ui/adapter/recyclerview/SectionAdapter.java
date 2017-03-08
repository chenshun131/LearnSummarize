package com.chenshun.learnsummarize.ui.adapter.recyclerview;

import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chenshun.learnsummarize.R;
import com.chenshun.learnsummarize.model.SectionModel;

import java.util.List;

/**
 * User: chenshun <p />
 * Time: 17/3/8 13:32  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class SectionAdapter extends BaseSectionQuickAdapter<SectionModel, BaseViewHolder>
{
    public SectionAdapter(int layoutResId, int sectionHeadResId, List data)
    {
        super(layoutResId, sectionHeadResId, data);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, SectionModel item)
    {
        helper.setText(R.id.header, item.header);
        helper.setVisible(R.id.more, item.isMore());
        helper.addOnClickListener(R.id.more);
    }

    @Override
    protected void convert(BaseViewHolder helper, SectionModel item)
    {
        switch (helper.getLayoutPosition() % 2)
        {
            case 0:
                helper.setImageResource(R.id.iv, R.mipmap.m_img1);
                break;
            case 1:
                helper.setImageResource(R.id.iv, R.mipmap.m_img2);
                break;
        }
        helper.setText(R.id.tv, item.t.getName());
    }
}