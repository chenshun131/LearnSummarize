package com.chenshun.learnsummarize.ui.adapter.recyclerview.helper;

import android.animation.Animator;
import android.support.annotation.NonNull;

/**
 * User: chenshun <p />
 * Time: 17/1/15 21:51 <p />
 * Version V1.0  <p />
 * Description: <p />
 */
public class AnimatorUtil
{
    private AnimatorUtil()
    {
    }

    public static Animator[] concatAnimators(@NonNull final Animator[] animators, @NonNull final Animator alphaAnimator)
    {
        Animator[] allAnimators = new Animator[animators.length + 1];
        int i = 0;
        for (Animator animator : animators)
        {
            allAnimators[i] = animator;
            ++i;
        }
        allAnimators[allAnimators.length - 1] = alphaAnimator;
        return allAnimators;
    }
}

