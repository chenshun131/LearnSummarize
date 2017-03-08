package com.chenshun.learnsummarize.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

import com.chad.library.adapter.base.animation.BaseAnimation;

/**
 * User: chenshun <p />
 * Time: 17/3/8 8:55  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class CustomAnimation implements BaseAnimation
{
    @Override
    public Animator[] getAnimators(View view)
    {
        return new Animator[]{
                ObjectAnimator.ofFloat(view, "scaleY", 1, 1.1f, 1),
                ObjectAnimator.ofFloat(view, "scaleX", 1, 1.1f, 1)
        };
    }
}
