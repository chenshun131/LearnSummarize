package com.chenshun.learnsummarize.ui.adapter.recyclerview;

import android.animation.Animator;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * User: chenshun <p />
 * Time: 17/1/15 21:49 <p />
 * Version V1.0  <p />
 * Description: <p />
 */
public class AlphaAnimatorAdapter<T extends RecyclerView.ViewHolder> extends AnimatorAdapter<T>
{
    public AlphaAnimatorAdapter(RecyclerView.Adapter<T> adapter, RecyclerView recyclerView)
    {
        super(adapter, recyclerView);
    }

    @NonNull
    @Override
    public Animator[] getAnimators(@NonNull View view)
    {
        return new Animator[0];
    }
}
