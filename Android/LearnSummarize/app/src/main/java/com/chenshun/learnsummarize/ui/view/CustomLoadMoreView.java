package com.chenshun.learnsummarize.ui.view;

import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.chenshun.learnsummarize.R;

/**
 * User: chenshun <p />
 * Time: 17/3/8 12:51  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public final class CustomLoadMoreView extends LoadMoreView
{
    @Override
    public int getLayoutId()
    {
        return R.layout.view_load_more;
    }

    @Override
    protected int getLoadingViewId()
    {
        return R.id.load_more_loading_view;
    }

    @Override
    protected int getLoadFailViewId()
    {
        return R.id.load_more_load_fail_view;
    }

    @Override
    protected int getLoadEndViewId()
    {
        return R.id.load_more_load_end_view;
    }
}

