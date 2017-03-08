package com.chenshun.learnsummarize.model;

import android.view.View;

import com.chenshun.learnsummarize.App;
import com.chenshun.learnsummarize.util.ToastUtil;

/**
 * User: chenshun <p />
 * Time: 17/3/8 16:50  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class MoviePresenter
{
    public void buyTicket(View view, MovieModel movie)
    {
        ToastUtil.showShortToast(App.getInstance(), "buy ticket: " + movie.name);
    }
}
