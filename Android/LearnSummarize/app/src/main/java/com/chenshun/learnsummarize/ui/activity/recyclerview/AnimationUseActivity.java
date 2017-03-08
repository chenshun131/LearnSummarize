package com.chenshun.learnsummarize.ui.activity.recyclerview;

import android.content.res.Configuration;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chenshun.learnsummarize.R;
import com.chenshun.learnsummarize.animation.CustomAnimation;
import com.chenshun.learnsummarize.model.StatusModel;
import com.chenshun.learnsummarize.ui.activity.base.BaseActivity;
import com.chenshun.learnsummarize.ui.adapter.recyclerview.AnimationAdapter;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.kyleduo.switchbutton.SwitchButton;

/**
 * User: chenshun <p />
 * Time: 17/3/7 13:37  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class AnimationUseActivity extends BaseActivity implements View.OnClickListener
{
    private RecyclerView mListRv;

    private AnimationAdapter mAnimationAdapter;

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
        setContentView(R.layout.activity_animation_use);
        setTitle("Animation Use");

        ImageView backIv = $(R.id.animationuse_back_iv);
        MaterialSpinner spinner = $(R.id.spinner);
        SwitchButton switchButton = $(R.id.switch_button);
        mListRv = $(R.id.animationuse_list_rv);

        // RecyclerView
        mListRv.setHasFixedSize(true);
        mListRv.setLayoutManager(new LinearLayoutManager(this));
        mAnimationAdapter = new AnimationAdapter();
        mAnimationAdapter.openLoadAnimation();
        mAnimationAdapter.setNotDoAnimationCount(3);// 不显示动画效果
        mListRv.addOnItemTouchListener(new OnItemChildClickListener()
        {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position)
            {
                String content = null;
                StatusModel status = (StatusModel) adapter.getItem(position);
                switch (view.getId())
                {
                    case R.id.img:
                        content = "img:" + status.getUserAvatar();
                        Toast.makeText(AnimationUseActivity.this, content, Toast.LENGTH_LONG).show();
                        break;
                    case R.id.tweetName:
                        content = "name:" + status.getUserName();
                        Toast.makeText(AnimationUseActivity.this, content, Toast.LENGTH_LONG).show();
                        break;
                    case R.id.tweetText:
                        // you have set clickspan .so there should not solve any click event ,just empty
                        break;
                }

            }
        });
        mListRv.setAdapter(mAnimationAdapter);

        // MaterialSpinner
        spinner.setItems("AlphaIn", "ScaleIn", "SlideInBottom", "SlideInLeft", "SlideInRight", "Custom");
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>()
        {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item)
            {
                switch (position)
                {
                    case 0:
                        mAnimationAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
                        break;
                    case 1:
                        mAnimationAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
                        break;
                    case 2:
                        mAnimationAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
                        break;
                    case 3:
                        mAnimationAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
                        break;
                    case 4:
                        mAnimationAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_RIGHT);
                        break;
                    case 5:
                        mAnimationAdapter.openLoadAnimation(new CustomAnimation());
                        break;
                    default:
                        break;
                }
                mListRv.setAdapter(mAnimationAdapter);
            }
        });

        // SwitchButton
        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(final CompoundButton buttonView, final boolean isChecked)
            {
                if (isChecked)
                {
                    mAnimationAdapter.isFirstOnly(true);
                }
                else
                {
                    mAnimationAdapter.isFirstOnly(false);
                }
                mAnimationAdapter.notifyDataSetChanged();
            }
        });

        bindOnClickLister(this, backIv);
    }

    @Override
    protected void setUI(Configuration newConfig, DisplayMetrics dm)
    {
    }

    @Override
    protected String setFragmentTag()
    {
        return "AnimationUseActivity";
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.animationuse_back_iv:
                finish();
                break;
        }
    }
}
