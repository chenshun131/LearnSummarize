package com.chenshun.learnsummarize.model;

/**
 * User: chenshun <p />
 * Time: 17/3/7 16:55  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class VideoModel
{
    private String img;
    private String name;

    public VideoModel(String img, String name)
    {
        this.img = img;
        this.name = name;
    }

    public String getImg()
    {
        return img;
    }

    public void setImg(String img)
    {
        this.img = img;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
