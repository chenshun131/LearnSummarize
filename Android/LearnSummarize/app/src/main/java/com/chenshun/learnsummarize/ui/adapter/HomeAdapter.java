package com.chenshun.learnsummarize.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chenshun.learnsummarize.R;

import java.util.List;

/**
 * User: chenshun <p />
 * Time: 17/1/15 21:48 <p />
 * Version V1.0  <p />
 * Description: <p />
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>
{
    private Context mContext;
    private List<String> mDatas;
    private OnItemClickLitener mOnItemClickLitener;

    public HomeAdapter(Context context, List<String> datas, OnItemClickLitener onItemClickLitener)
    {
        mContext = context;
        mDatas = datas;
        mOnItemClickLitener = onItemClickLitener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_home_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position)
    {
        holder.mContentTv.setText(mDatas.get(position));

        if (mOnItemClickLitener != null)
        {
            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    mOnItemClickLitener.onItemClick(holder.itemView, holder.getLayoutPosition());
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener()
            {
                @Override
                public boolean onLongClick(View v)
                {
                    mOnItemClickLitener.onItemLongClick(holder.itemView, holder.getLayoutPosition());
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount()
    {
        return mDatas.size();
    }

    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView mContentTv;

        public ViewHolder(View itemView)
        {
            super(itemView);
            mContentTv = (TextView) itemView.findViewById(R.id.home_content_tv);
        }
    }
}
