package com.chenshun.learnsummarize.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chenshun.learnsummarize.ui.adapter.recyclerview.ExpandableItemAdapter;

/**
 * User: chenshun <p />
 * Time: 17/3/8 15:42  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class PersonModel implements MultiItemEntity
{
    public PersonModel(String name, int age)
    {
        this.age = age;
        this.name = name;
    }

    public String name;
    public int age;

    @Override
    public int getItemType()
    {
        return ExpandableItemAdapter.TYPE_PERSON;
    }
}