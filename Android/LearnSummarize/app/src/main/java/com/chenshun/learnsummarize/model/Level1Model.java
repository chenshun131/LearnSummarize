package com.chenshun.learnsummarize.model;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chenshun.learnsummarize.ui.adapter.recyclerview.ExpandableItemAdapter;

/**
 * User: chenshun <p />
 * Time: 17/3/8 15:42  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class Level1Model extends AbstractExpandableItem<PersonModel> implements MultiItemEntity
{
    public String title;
    public String subTitle;

    public Level1Model(String title, String subTitle)
    {
        this.subTitle = subTitle;
        this.title = title;
    }

    @Override
    public int getItemType()
    {
        return ExpandableItemAdapter.TYPE_LEVEL_1;
    }

    @Override
    public int getLevel()
    {
        return 1;
    }
}
