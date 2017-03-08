package com.chenshun.learnsummarize.ui.adapter.recyclerview;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chenshun.learnsummarize.BR;
import com.chenshun.learnsummarize.R;
import com.chenshun.learnsummarize.model.MovieModel;
import com.chenshun.learnsummarize.model.MoviePresenter;

import java.util.List;

/**
 * User: chenshun <p />
 * Time: 17/3/8 16:14  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class DataBindingUseAdapter extends BaseQuickAdapter<MovieModel, DataBindingUseAdapter.MovieViewHolder>
{
    private MoviePresenter mPresenter;

    public DataBindingUseAdapter(int layoutResId, List<MovieModel> data)
    {
        super(layoutResId, data);
        mPresenter = new MoviePresenter();
    }

    @Override
    protected void convert(MovieViewHolder helper, MovieModel item)
    {
        ViewDataBinding binding = helper.getBinding();
        binding.setVariable(BR.movie, item);
        binding.setVariable(BR.presenter, mPresenter);
        binding.executePendingBindings();
        switch (helper.getLayoutPosition() % 2)
        {
            case 0:
                helper.setImageResource(R.id.iv, R.mipmap.m_img1);
                break;
            case 1:
                helper.setImageResource(R.id.iv, R.mipmap.m_img2);
                break;
        }
    }

    /*  @Override
      protected MovieViewHolder createBaseViewHolder(View view) {
          return new MovieViewHolder(view);
      }
  */
    @Override
    protected View getItemView(int layoutResId, ViewGroup parent)
    {
        ViewDataBinding binding = DataBindingUtil.inflate(mLayoutInflater, layoutResId, parent, false);
        if (binding == null)
        {
            return super.getItemView(layoutResId, parent);
        }
        View view = binding.getRoot();
        view.setTag(R.id.BaseQuickAdapter_databinding_support, binding);
        return view;
    }

    public class MovieViewHolder extends BaseViewHolder
    {
        public MovieViewHolder(View view)
        {
            super(view);
        }

        public ViewDataBinding getBinding()
        {
            return (ViewDataBinding) getConvertView().getTag(R.id.BaseQuickAdapter_databinding_support);
        }
    }
}
