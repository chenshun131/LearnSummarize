package com.chenshun.learnsummarize.ui.adapter.recyclerview.helper;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * User: chenshun <p />
 * Time: 17/1/15 21:51 <p />
 * Version V1.0  <p />
 * Description: <p />
 */
public class ViewAnimator
{
    private static final String SAVEDINSTANCESTATE_FIRSTANIMATEDPOSITION = "savedinstancestate_firstanimatedposition";
    private static final String SAVEDINSTANCESTATE_LASTANIMATEDPOSITION = "savedinstancestate_lastanimatedposition";
    private static final String SAVEDINSTANCESTATE_SHOULDANIMATE = "savedinstancestate_shouldanimate";
    private static final int INITIAL_DELAY_MILLIS = 150;
    private static final int DEFAULT_ANIMATION_DELAY_MILLIS = 100;
    private static final int DEFAULT_ANIMATION_DURATION_MILLIS = 300;
    private final RecyclerView mRecyclerView;
    private final SparseArray<Animator> mAnimators = new SparseArray<>();
    private int mInitialDelayMillis = INITIAL_DELAY_MILLIS;
    private int mAnimationDelayMillis = DEFAULT_ANIMATION_DELAY_MILLIS;
    private int mAnimationDurationMillis = DEFAULT_ANIMATION_DURATION_MILLIS;
    private long mAnimationStartMillis;
    private int mFirstAnimatedPosition;
    private int mLastAnimatedPosition;
    private boolean mShouldAnimate = true;

    public ViewAnimator(@NonNull final RecyclerView recyclerView)
    {
        mRecyclerView = recyclerView;
        mAnimationStartMillis = -1;
        mFirstAnimatedPosition = -1;
        mLastAnimatedPosition = -1;
    }

    public void reset()
    {
        for (int i = 0; i < mAnimators.size(); i++)
        {
            mAnimators.get(mAnimators.keyAt(i)).cancel();
        }
        mAnimators.clear();
        mFirstAnimatedPosition = -1;
        mLastAnimatedPosition = -1;
        mAnimationStartMillis = -1;
        mShouldAnimate = true;
    }

    public void setShouldAnimateFromPosition(final int position)
    {
        enableAnimations();
        mFirstAnimatedPosition = position - 1;
        mLastAnimatedPosition = position - 1;
    }

    public void setShouldAnimateNotVisible()
    {
        enableAnimations();
        mFirstAnimatedPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
        mLastAnimatedPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
    }

    void setLastAnimatedPosition(final int lastAnimatedPosition)
    {
        mLastAnimatedPosition = lastAnimatedPosition;
    }

    public void setInitialDelayMillis(final int delayMillis)
    {
        mInitialDelayMillis = delayMillis;
    }

    public void setAnimationDelayMillis(final int delayMillis)
    {
        mAnimationDelayMillis = delayMillis;
    }

    public void setAnimationDurationMillis(final int durationMillis)
    {
        mAnimationDurationMillis = durationMillis;
    }

    public void enableAnimations()
    {
        mShouldAnimate = true;
    }

    public void disableAnimations()
    {
        mShouldAnimate = false;
    }

    public void cancelExistingAnimation(@NonNull final View view)
    {
        int hashCode = view.hashCode();
        Animator animator = mAnimators.get(hashCode);
        if (animator != null)
        {
            animator.end();
            mAnimators.remove(hashCode);
        }
    }

    public void animateViewIfNecessary(final int position, @NonNull final View view, @NonNull final Animator[] animators)
    {
        if (mShouldAnimate && position > mLastAnimatedPosition)
        {
            if (mFirstAnimatedPosition == -1)
            {
                mFirstAnimatedPosition = position;
            }
            animateView(position, view, animators);
            mLastAnimatedPosition = position;
        }
    }

    private void animateView(final int position, @NonNull final View view, @NonNull final Animator[] animators)
    {
        if (mAnimationStartMillis == -1)
        {
            mAnimationStartMillis = SystemClock.uptimeMillis();
        }
        ViewCompat.setAlpha(view, 0);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(animators);
        set.setStartDelay(calculateAnimationDelay(position));
        set.setDuration(mAnimationDurationMillis);
        set.start();
        mAnimators.put(view.hashCode(), set);
    }

    private int calculateAnimationDelay(final int position)
    {
        int delay;
        int lastVisiblePosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager()).findLastCompletelyVisibleItemPosition();
        int firstVisiblePosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
        if (mLastAnimatedPosition > lastVisiblePosition)
        {
            lastVisiblePosition = mLastAnimatedPosition;
        }
        int numberOfItemsOnScreen = lastVisiblePosition - firstVisiblePosition;
        int numberOfAnimatedItems = position - 1 - mFirstAnimatedPosition;
        if (numberOfItemsOnScreen + 1 < numberOfAnimatedItems)
        {
            delay = mAnimationDelayMillis;

            if (mRecyclerView.getLayoutManager() instanceof GridLayoutManager)
            {
                int numColumns = ((GridLayoutManager) mRecyclerView.getLayoutManager()).getSpanCount();
                delay += mAnimationDelayMillis * (position % numColumns);
            }
        }
        else
        {
            int delaySinceStart = (position - mFirstAnimatedPosition) * mAnimationDelayMillis;
            delay = Math.max(0, (int) (-SystemClock.uptimeMillis() + mAnimationStartMillis + mInitialDelayMillis + delaySinceStart));
        }
        return delay;
    }

    public Parcelable onSaveInstanceState()
    {
        Bundle bundle = new Bundle();
        bundle.putInt(SAVEDINSTANCESTATE_FIRSTANIMATEDPOSITION, mFirstAnimatedPosition);
        bundle.putInt(SAVEDINSTANCESTATE_LASTANIMATEDPOSITION, mLastAnimatedPosition);
        bundle.putBoolean(SAVEDINSTANCESTATE_SHOULDANIMATE, mShouldAnimate);
        return bundle;
    }

    public void onRestoreInstanceState(@Nullable final Parcelable parcelable)
    {
        if (parcelable instanceof Bundle)
        {
            Bundle bundle = (Bundle) parcelable;
            mFirstAnimatedPosition = bundle.getInt(SAVEDINSTANCESTATE_FIRSTANIMATEDPOSITION);
            mLastAnimatedPosition = bundle.getInt(SAVEDINSTANCESTATE_LASTANIMATEDPOSITION);
            mShouldAnimate = bundle.getBoolean(SAVEDINSTANCESTATE_SHOULDANIMATE);
        }
    }
}
