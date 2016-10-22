package com.chenshun.learnsummarize.ui.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.chenshun.learnsummarize.R;

/**
 * User: chenshun <p />
 * Time: 16/10/22 23:06 <p />
 * Version V1.0  <p />
 * Description: <p />
 */
public class MyProgressDialog extends Dialog
{
    private ProgressWheel mProgress;
    private TextView mMessageView;
    private CharSequence mMessage;

    public MyProgressDialog(Context context)
    {
        this(context, R.style.Theme_Dialog_Progress);
    }

    private MyProgressDialog(Context context, int theme)
    {
        super(context, theme);
    }

    public static MyProgressDialog show(Context context, boolean cancelable)
    {
        return show(context, cancelable, null, null);
    }

    /**
     * @param context
     * @param cancelable
     *         Sets whether this dialog is cancelable with the BACK key.
     * @param msg
     *         set the TextView Message
     * @param cancelListener
     *         Set a listener to be invoked when the dialog is canceled.
     * @return
     */
    public static MyProgressDialog show(Context context, boolean cancelable, CharSequence msg, OnCancelListener cancelListener)
    {
        MyProgressDialog dialog = new MyProgressDialog(context);
        dialog.setCancelable(cancelable);
        dialog.setMessage(msg);
        dialog.setOnCancelListener(cancelListener);
        dialog.show();
        return dialog;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Context mContext = getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawableResource(R.drawable.toast_corner);
        View view = inflater.inflate(R.layout.progress_dialog, null, false);
        mProgress = (ProgressWheel) view.findViewById(R.id.progress);
        mMessageView = (TextView) view.findViewById(R.id.p_message);
        getWindow().setContentView(view);
        if (mMessage != null)
        {
            setMessage(mMessage);
        }
        super.onCreate(savedInstanceState);
    }

    /**
     * set the TextView Message
     *
     * @param message
     */
    public void setMessage(CharSequence message)
    {
        if (mProgress != null)
        {
            if (mMessageView.getVisibility() == View.GONE)
            {
                mMessageView.setVisibility(View.VISIBLE);
            }
            mMessageView.setText(message);
        }
        else
        {
            mMessage = message;
        }
    }

    /**
     * set the TextView Message
     *
     * @param message
     */
    public void resetMessage(CharSequence message)
    {
        if (mProgress != null)
        {
            mProgress.setVisibility(View.GONE);
            if (mMessageView.getVisibility() == View.GONE)
            {
                mMessageView.setVisibility(View.VISIBLE);
            }
            mMessageView.setText(message);
        }
        else
        {
            mMessage = message;
        }
    }

    /**
     * Sets the Drawables to appear at the TextView and close ProgressBar
     *
     * @param drawable
     */
    public void setMessageDrawable(Drawable drawable)
    {
        if (mProgress != null)
        {
            mProgress.setVisibility(View.GONE);
            mMessageView.setCompoundDrawablePadding(12);
            mMessageView.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
        }
    }
}
