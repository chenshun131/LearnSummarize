package com.chenshun.learnsummarize.ui.activity.recyclerview;

import android.content.res.Configuration;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chenshun.learnsummarize.R;
import com.chenshun.learnsummarize.model.Level0Model;
import com.chenshun.learnsummarize.model.Level1Model;
import com.chenshun.learnsummarize.model.PersonModel;
import com.chenshun.learnsummarize.ui.activity.base.BaseActivity;
import com.chenshun.learnsummarize.ui.adapter.recyclerview.ExpandableItemAdapter;

import java.util.ArrayList;
import java.util.Random;

/**
 * User: chenshun <p />
 * Time: 17/3/7 13:46  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class ExpandableUseActivity extends BaseActivity
{
    private RecyclerView mListRv;

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
        setTitle("ExpandableItem Activity");

        mListRv = $(R.id.base_list_rv);
        mListRv.setLayoutManager(new LinearLayoutManager(this));

        ExpandableItemAdapter adapter = new ExpandableItemAdapter(generateData());
        mListRv.setAdapter(adapter);
//        adapter.expandAll(3, true);
    }

    @Override
    protected void setUI(Configuration newConfig, DisplayMetrics dm)
    {
    }

    @Override
    protected String setFragmentTag()
    {
        return "ExpandableUseActivity";
    }

    private ArrayList<MultiItemEntity> generateData()
    {
        int lv0Count = 9;
        int lv1Count = 3;
        int personCount = 5;

        String[] nameList = {"Bob", "Andy", "Lily", "Brown", "Bruce"};
        Random random = new Random();

        ArrayList<MultiItemEntity> res = new ArrayList<>();
        for (int i = 0; i < lv0Count; i++)
        {
            Level0Model lv0 = new Level0Model("This is " + i + "th item in Level 0", "subtitle of " + i);
            for (int j = 0; j < lv1Count; j++)
            {
                Level1Model lv1 = new Level1Model("Level 1 item: " + j, "(no animation)");
                for (int k = 0; k < personCount; k++)
                {
                    lv1.addSubItem(new PersonModel(nameList[k], random.nextInt(40)));
                }
                lv0.addSubItem(lv1);
            }
            res.add(lv0);
        }
        return res;
    }
}
