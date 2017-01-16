package com.chenshun.learnsummarize.util;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chenshun.learnsummarize.App;
import com.chenshun.learnsummarize.R;
import com.chenshun.learnsummarize.constant.Constants;

/**
 * User: chenshun <p />
 * Time: 16/12/8 07:00 <p />
 * Version V1.0  <p />
 * Description: <p />
 */
public class ToastUtil
{
    private static Toast mToast = null;
    private static String TAG = ToastUtil.class.getSimpleName();

    /**
     * show system default short Toast
     *
     * @param context
     * @param resId
     */
    public static void showShortToast(Context context, int resId)
    {
        showShortToast(context, context.getString(resId));
    }

    /**
     * show system default short Toast
     *
     * @param context
     * @param msg
     */
    public static void showShortToast(Context context, String msg)
    {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * show system default long Toast
     *
     * @param context
     * @param resId
     */
    public static void showLongToast(Context context, int resId)
    {
        showLongToast(context, context.getString(resId));
    }

    /**
     * show system default long Toast
     *
     * @param context
     * @param msg
     */
    public static void showLongToast(Context context, String msg)
    {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    /**
     * show long Debug Toast
     *
     * @param msg
     */
    public static void showDebugToast(String msg)
    {
        if (Constants.IS_DEBUG)
        {
            // check current thread in Main thread,in other words,in UI thread
            if (Looper.myLooper() == null || Looper.myLooper() != Looper.getMainLooper())
            {
                Logs.e(TAG, "can't toast not in UI thread => msg:" + msg);
                return;
            }
            createToast(App.getInstance().getApplicationContext(), msg, Toast.LENGTH_LONG, false);
        }
    }

    /**
     * show short Custom Toast
     *
     * @param context
     * @param msg
     */
    public static void showShortCustomToast(Context context, String msg)
    {
        createToast(context, msg, Toast.LENGTH_SHORT, false);
    }

    /**
     * show short Error Custom Toast
     *
     * @param context
     * @param msg
     */
    public static void showShortCustomErrorToast(Context context, String msg)
    {
        createToast(context, msg, Toast.LENGTH_SHORT, true);
    }

    /**
     * show long Custom Toast
     *
     * @param context
     * @param msg
     */
    public static void showLongCustomToast(Context context, String msg)
    {
        createToast(context, msg, Toast.LENGTH_LONG, false);
    }

    /**
     * show long Error Custom Toast
     *
     * @param context
     * @param msg
     */
    public static void showLongCustomErrorToast(Context context, String msg)
    {
        createToast(context, msg, Toast.LENGTH_LONG, true);
    }

    /**
     * show a toast in a thread
     *
     * @param context
     * @param msg
     */
    public static void showCustomToastFromThread(final Context context, final String msg)
    {
        if (Looper.myLooper() == Looper.getMainLooper() && Looper.getMainLooper() != null)
        {
            Logs.w(TAG, "you have been in main thread ,just call showToast()");
            showShortCustomToast(context, msg);
            return;
        }
        Looper looper = Looper.getMainLooper();
        if (looper == null)
        {
            Logs.e(TAG, "can't create Handler without MainLooper..");
            return;
        }
        new Handler(looper).post(new Runnable()
        {
            @Override
            public void run()
            {
                showShortCustomToast(context, msg);
            }
        });
    }

    /**
     * Close the view if it's showing, or don't show it if it isn't showing yet
     */
    public static void cancel()
    {
        if (mToast != null)
        {
            mToast.cancel();
        }
    }

    /**
     * create and show custom Toast
     *
     * @param context
     * @param msg
     * @param duration
     */
    private static void createToast(Context context, String msg, int duration, boolean isError)
    {
        // check current thread in Main thread,in other words,in UI thread
        if (Looper.myLooper() == null || Looper.myLooper() != Looper.getMainLooper())
        {
            Logs.e(TAG, "can't toast not in UI thread");
            return;
        }
        if (mToast == null)
        {
            mToast = new Toast(context.getApplicationContext());
            LayoutInflater mInflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = mInflater.inflate(R.layout.util_toast, null);
            TextView toastText = (TextView) v.findViewById(R.id.toast_text);
            if (isError)
            {
                v.setBackgroundResource(R.drawable.toast_corner_error);
                toastText.setTextColor(Color.BLACK);
            }
            else
            {
                v.setBackgroundResource(R.drawable.toast_corner);
                toastText.setTextColor(Color.WHITE);
            }
            toastText.setText(msg);
            mToast.setView(v);
        }
        else
        {
            View toastView = mToast.getView();
            if (null != toastView)
            {
                TextView tx = (TextView) toastView.findViewById(R.id.toast_text);
                tx.setText(msg);
                if (isError)
                {
                    toastView.setBackgroundResource(R.drawable.toast_corner_error);
                    tx.setTextColor(Color.BLACK);
                }
                else
                {
                    toastView.setBackgroundResource(R.drawable.toast_corner);
                    tx.setTextColor(Color.WHITE);
                }
            }
        }
        mToast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
        mToast.setDuration(duration);
        mToast.show();
    }
}
