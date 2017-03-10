package com.chenshun.learnsummarize.ui.activity.database.greendao;

import android.content.res.Configuration;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

import com.chenshun.learnsummarize.App;
import com.chenshun.learnsummarize.R;
import com.chenshun.learnsummarize.ui.activity.base.BaseActivity;
import com.chenshun.learnsummarize.ui.activity.database.greendao.entity.User;
import com.chenshun.learnsummarize.ui.activity.database.greendao.gen.UserDao;

import java.util.List;

/**
 * User: chenshun <p />
 * Time: 17/3/10 14:27 <p />
 * Version V1.0  <p />
 * Description: <p />
 */
public class GreenDaoActivity extends BaseActivity implements View.OnClickListener
{
    private TextView mText;

    private User mUser;
    private UserDao mUserDao;

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
        mUserDao = App.getInstance().getDaoSession().getUserDao();
    }

    @Override
    protected void initView()
    {
        setContentView(R.layout.activity_greendao);
        setTitle("GreenDao");

        mText = $(R.id.text);

        bindOnClickLister(this, $(R.id.add), $(R.id.delete), $(R.id.update), $(R.id.find));
    }

    @Override
    protected void setUI(Configuration newConfig, DisplayMetrics dm)
    {
    }

    @Override
    protected String setFragmentTag()
    {
        return "GreenDaoActivity";
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.add:
                mUser = new User((long) 3, "添加一条数据");
                mUserDao.insert(mUser);
                mText.setText(mUser.getName());
                break;
            case R.id.delete:// 根据主键删除User
                mUserDao.deleteByKey((long) 3);
                break;
            case R.id.update:
                mUser = new User((long) 3, "修改一条数据");
                mUserDao.update(mUser);
                break;
            case R.id.find:
                List<User> users = mUserDao.loadAll();
                String userName = "";
                for (int i = 0; i < users.size(); i++)
                {
                    userName += users.get(i).getName() + ",";
                }
                mText.setText("查询全部数据==>" + userName);
                break;
        }
    }
}
