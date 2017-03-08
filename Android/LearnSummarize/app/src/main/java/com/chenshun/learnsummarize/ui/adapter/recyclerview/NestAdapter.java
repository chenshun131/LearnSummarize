package com.chenshun.learnsummarize.ui.adapter.recyclerview;

import android.support.v4.content.ContextCompat;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chenshun.learnsummarize.App;
import com.chenshun.learnsummarize.R;
import com.chenshun.learnsummarize.data.RecyclerviewData;
import com.chenshun.learnsummarize.model.StatusModel;
import com.chenshun.learnsummarize.util.SpannableStringUtils;
import com.chenshun.learnsummarize.util.ToastUtil;

/**
 * User: chenshun <p />
 * Time: 17/3/8 15:20  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class NestAdapter extends BaseQuickAdapter<StatusModel, BaseViewHolder>
{
    public NestAdapter()
    {
        super(R.layout.layout_nest_item, RecyclerviewData.getSampleData(20));
    }

    @Override
    protected void convert(BaseViewHolder helper, StatusModel item)
    {
        helper.addOnClickListener(R.id.tweetText);
        switch (helper.getLayoutPosition() % 3)
        {
            case 0:
                helper.setImageResource(R.id.img, R.mipmap.animation_img1);
                break;
            case 1:
                helper.setImageResource(R.id.img, R.mipmap.animation_img2);
                break;
            case 2:
                helper.setImageResource(R.id.img, R.mipmap.animation_img3);
                break;
        }
        helper.setText(R.id.tweetName, "Hoteis in Rio de Janeiro");
        String msg = "\"He was one of Australia's most of distinguished artistes, renowned for his portraits\"";
        helper.setText(R.id.tweetText, SpannableStringUtils.getBuilder(msg).append("landscapes and nedes").setClickSpan(clickableSpan).create());
        ((TextView) helper.getView(R.id.tweetText)).setMovementMethod(LinkMovementMethod.getInstance());
    }

    private ClickableSpan clickableSpan = new ClickableSpan()
    {
        @Override
        public void onClick(View widget)
        {
            ToastUtil.showShortToast(App.getInstance(), "事件触发了 landscapes and nedes");
        }

        @Override
        public void updateDrawState(TextPaint ds)
        {
            ds.setColor(ContextCompat.getColor(App.getInstance(), R.color.clickspan_color));
            ds.setUnderlineText(true);
        }
    };
}
