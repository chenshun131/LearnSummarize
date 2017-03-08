package com.chenshun.learnsummarize.model;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * User: chenshun <p />
 * Time: 17/3/7 16:56  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class SectionModel extends SectionEntity<VideoModel>
{
    private boolean isMore;

    public SectionModel(VideoModel videoModel)
    {
        super(videoModel);
    }

    public SectionModel(boolean isHeader, String header, boolean isMore)
    {
        super(isHeader, header);
        this.isMore = isMore;
    }

    public boolean isMore()
    {
        return isMore;
    }

    public void setMore(boolean more)
    {
        isMore = more;
    }
}
