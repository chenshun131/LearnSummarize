package com.chenshun.learnsummarize.ui.activity.recyclerview;

import android.content.res.Configuration;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;

import com.chenshun.learnsummarize.R;
import com.chenshun.learnsummarize.model.MovieModel;
import com.chenshun.learnsummarize.ui.activity.base.BaseActivity;
import com.chenshun.learnsummarize.ui.adapter.recyclerview.DataBindingUseAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * User: chenshun <p />
 * Time: 17/3/7 13:47  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class DataBindingUseActivity extends BaseActivity
{
    @Override
    public boolean handleNotifyMessage(Message msg)
    {
        return false;
    }

    @Override
    public boolean handleUIMessage(Message msg)
    {
        return false;
    }

    @Override
    public boolean handleMessage(Message msg)
    {
        return false;
    }

    @Override
    protected void initData()
    {
    }

    @Override
    protected void initView()
    {
        setContentView(R.layout.base_recycleview);
        setTitle("DataBinding Use");

        RecyclerView listRv = $(R.id.base_list_rv);

        DataBindingUseAdapter dataBindingUseAdapter = new DataBindingUseAdapter(R.layout.item_movie_list, genData());
        listRv.setLayoutManager(new LinearLayoutManager(this));
        listRv.setAdapter(dataBindingUseAdapter);
    }

    @Override
    protected void setUI(Configuration newConfig, DisplayMetrics dm)
    {
    }

    @Override
    protected String setFragmentTag()
    {
        return "DataBindingUseActivity";
    }

    private List<MovieModel> genData()
    {
        ArrayList<MovieModel> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++)
        {
            String name = "Chad";
            int price = random.nextInt(10) + 10;
            int len = random.nextInt(80) + 60;
            list.add(new MovieModel(name, len, price, "He was one of Australia's most distinguished artistes"));
        }
        return list;
    }
}
