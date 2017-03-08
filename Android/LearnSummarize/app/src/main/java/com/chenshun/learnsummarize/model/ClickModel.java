package com.chenshun.learnsummarize.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * User: chenshun <p />
 * Time: 17/3/8 15:6  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class ClickModel implements MultiItemEntity
{
    public static final int CLICK_ITEM_VIEW = 1;
    public static final int CLICK_ITEM_CHILD_VIEW = 2;
    public static final int LONG_CLICK_ITEM_VIEW = 3;
    public static final int LONG_CLICK_ITEM_CHILD_VIEW = 4;
    public static final int NEST_CLICK_ITEM_CHILD_VIEW = 5;
    public int Type;

    public ClickModel(final int type)
    {
        Type = type;
    }

    @Override
    public int getItemType()
    {
        return Type;
    }
}
