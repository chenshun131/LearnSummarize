package com.chenshun.learnsummarize.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * User: chenshun <p />
 * Time: 17/3/10 9:43 <p />
 * Version V1.0  <p />
 * Description: <p />
 */
public class LayoutMultipleItemModel implements MultiItemEntity
{
    public static final int FadingTextView = 1;

    private int itemType;
    private String title;

    public LayoutMultipleItemModel(int itemType, String title)
    {
        this.itemType = itemType;
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }

    @Override
    public int getItemType()
    {
        return itemType;
    }
}
