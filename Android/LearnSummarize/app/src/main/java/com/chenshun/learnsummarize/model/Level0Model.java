package com.chenshun.learnsummarize.model;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chenshun.learnsummarize.ui.adapter.recyclerview.ExpandableItemAdapter;

/**
 * User: chenshun <p />
 * Time: 17/3/8 15:41  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class Level0Model extends AbstractExpandableItem<Level1Model> implements MultiItemEntity
{
    public String title;
    public String subTitle;

    public Level0Model(String title, String subTitle)
    {
        this.subTitle = subTitle;
        this.title = title;
    }

    @Override
    public int getItemType()
    {
        return ExpandableItemAdapter.TYPE_LEVEL_0;
    }

    @Override
    public int getLevel()
    {
        return 0;
    }
}
