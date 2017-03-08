package com.chenshun.learnsummarize.model;

/**
 * User: chenshun <p />
 * Time: 17/3/7 12:33 <p />
 * Version V1.0  <p />
 * Description: <p />
 */
public class RecycleViewModel
{
    private String title;
    private Class<?> activity;
    private int imageResource;

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Class<?> getActivity()
    {
        return activity;
    }

    public void setActivity(Class<?> activity)
    {
        this.activity = activity;
    }

    public int getImageResource()
    {
        return imageResource;
    }

    public void setImageResource(int imageResource)
    {
        this.imageResource = imageResource;
    }
}
