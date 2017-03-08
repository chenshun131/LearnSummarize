package com.chenshun.learnsummarize.ui.fragment.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

import com.chenshun.learnsummarize.App;
import com.chenshun.learnsummarize.R;
import com.chenshun.learnsummarize.constant.Constants;
import com.chenshun.learnsummarize.ui.util.HandlerCache;
import com.chenshun.learnsummarize.ui.util.HandlerInterface;
import com.chenshun.learnsummarize.ui.util.MyHandler;
import com.chenshun.learnsummarize.ui.view.MyProgressDialog;
import com.chenshun.learnsummarize.util.Logs;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.PauseOnScrollListener;
import com.squareup.leakcanary.RefWatcher;
import com.umeng.analytics.MobclickAgent;

/**
 * User: chenshun <p />
 * Time: 16/12/11 07:47 <p />
 * Version V1.0  <p />
 * Description: <p />
 */
public abstract class BaseFragment extends Fragment implements HandlerInterface
{
    private final String TAG = BaseFragment.class.getSimpleName();
    /** Activity which being attached by current fragment */
    protected Activity activity;
    /** Handler message and according to MsgTypeCode,use different handleMessage method */
    protected MyHandler mHandler;
    /** send Message to all Handler that in List&lt;Handler&gt; sUIHandlers */
    protected HandlerCache mHandlerCache;
    /** ImageLoader instance */
    protected ImageLoader mImageLoader = ImageLoader.getInstance();
    /** Whether pause ImageLoader during touch scrolling */
    protected boolean pauseOnScroll = true;
    /** Whether pause ImageLoader during fling */
    protected boolean pauseOnFling = false;
    /** save parameters when Fragment was instantiation */
    protected Bundle bundle;
    /** current Fragment View */
    private View rootView;

    /******************************** 【Fragment LifeCycle For Debug】 *******************************************/
    @Override
    public void onAttach(Context context)
    {
        Logs.d(setTag(), this.getClass().getSimpleName() + " onAttach() invoked!!");
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        Logs.d(setTag(), this.getClass().getSimpleName() + " onCreate() invoked!!");
        super.onCreate(savedInstanceState);
        this.activity = getActivity();
        if (null == savedInstanceState)
        {
            bundle = null == getArguments() ? new Bundle() : new Bundle(getArguments());
        }
        else
        {
            bundle = savedInstanceState;
        }
        initData(bundle);
        mHandler = new MyHandler(this);
        initHandlerCache();
    }

    // The fragment returns to the layout from the back stack
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        Logs.d(setTag(), this.getClass().getSimpleName() + " onCreateView() invoked!!");
        if (rootView == null)
        {
            rootView = initView(inflater, container, bundle);
        }
        if (null != rootView)
        {
            // 刚刚创建的 View 此时还没有加入到任何布局中，则 ViewGroup 不存在
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null)
            {
                parent.removeView(rootView);
            }
        }
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        Logs.d(setTag(), this.getClass().getSimpleName() + " onActivityCreated() invoked!!");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume()
    {
        MobclickAgent.onPageStart(setFragmentTag());
        Logs.d(setTag(), this.getClass().getSimpleName() + " onResume() invoked!!");
        super.onResume();
    }

    @Override
    public void onPause()
    {
        MobclickAgent.onPageEnd(setFragmentTag());
        Logs.d(setTag(), this.getClass().getSimpleName() + " onPause() invoked!!");
        super.onPause();
    }

    // The fragment returns to the layout from the back stack
    @Override
    public void onDestroyView()
    {
        Logs.d(setTag(), this.getClass().getSimpleName() + " onDestroyView() invoked!!");
        super.onDestroyView();
    }

    @Override
    public void onDestroy()
    {
        Logs.d(setTag(), this.getClass().getSimpleName() + " onDestroy() invoked!!");
        if (mHandlerCache != null)
        {
            mHandlerCache.unRegisterHandler(mHandler);
        }
        super.onDestroy();
        // leakcanary
        if (Constants.IS_DEBUG)
        {
            RefWatcher refWatcher = App.getRefWatcher(getActivity());
            refWatcher.watch(this);
        }
    }

    @Override
    public void onDetach()
    {
        Logs.d(setTag(), this.getClass().getSimpleName() + " onDetach() invoked!!");
        super.onDetach();
    }

    private void initHandlerCache()
    {
        mHandlerCache = new HandlerCache();
        mHandlerCache.registerHandler(mHandler);
    }

    /**
     * initData before initView(LayoutInflater inflater, ViewGroup container, Bundle bundle)
     *
     * @param bundle
     */
    protected abstract void initData(Bundle bundle);

    /**
     * initView after initData(Bundle bundle)
     *
     * @param inflater
     * @param container
     * @param bundle
     * @return
     */
    protected abstract View initView(LayoutInflater inflater, ViewGroup container, Bundle bundle);

    /******************************** 【 Dialog Operation 】 *******************************************/
    /**
     * set the Dialog auto dismiss and finish the Activity for the Context after delay milliseconds
     *
     * @param context
     * @param dialog
     * @param delay
     *         if delay < 1000,the Dialog auto dismiss after 1000 milliseconds,otherwise delay
     */
    public void setAutoDismiss(final Context context, final Dialog dialog, int delay)
    {
        mHandler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                if (context != null && dialog != null && dialog.isShowing())
                {
                    if (context instanceof Activity)
                    {
                        if (!((Activity) context).isFinishing())
                        {
                            dialog.dismiss();
                        }
                    }
                }
            }
        }, delay <= 0 ? 1000 : delay);
    }

    /**
     * set the Dialog auto dismiss and finish the Activity for the Context after delay milliseconds
     *
     * @param context
     * @param dialog
     * @param delay
     *         if delay < 1000,the Dialog auto dismiss after 1000 milliseconds,otherwise delay
     */
    public void setAutoDismissAndFinish(final Context context, final Dialog dialog, int delay)
    {
        mHandler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                if (context != null && dialog != null && dialog.isShowing())
                {
                    if (context instanceof Activity)
                    {
                        if (!((Activity) context).isFinishing())
                        {
                            dialog.dismiss();
                            ((Activity) context).finish();
                        }
                    }
                }
            }
        }, delay <= 0 ? 1000 : delay);
    }

    /**
     * @param context
     * @param dialog
     *         QixinProgressDialog instance
     * @param message
     *         the TextView of QixinProgressDialog Message
     * @param d
     *         the Drawables to appear at the TextView of QixinProgressDialog
     */
    public void resetProgressMessage(Context context, MyProgressDialog dialog, String message, Drawable d)
    {
        if (context != null && dialog != null && dialog.isShowing())
        {
            if (context instanceof Activity)
            {
                if (!((Activity) context).isFinishing())
                {
                    dialog.resetMessage(message);
                    dialog.setMessageDrawable(d);
                }
            }
        }
    }

    /**
     * safity close Dialog
     *
     * @param context
     * @param dialog
     */
    public void dismissDialogSafety(Context context, Dialog dialog)
    {
        if (context != null && dialog != null && dialog.isShowing())
        {
            if (context instanceof Activity)
            {
                if (!((Activity) context).isFinishing())
                {
                    dialog.dismiss();
                }
            }
        }
    }

    /******************************** 【 Bind Listener 】 *******************************************/
    /**
     * Allow ImageLoader to stop load when ListView onScroll and onFling.<br />
     * It prevents redundant loadings.
     */
    protected void applyScrollListener(AbsListView view)
    {
        if (view != null)
        {
            view.setOnScrollListener(new PauseOnScrollListener(mImageLoader, pauseOnScroll, pauseOnFling));
        }
    }

    /**
     * bind OnClickListener to the views
     *
     * @param onClick
     * @param views
     */
    protected void bindOnClickLister(View.OnClickListener onClick, View... views)
    {
        if (onClick != null && views != null)
        {
            for (View view : views)
            {
                if (view != null)
                {
                    view.setOnClickListener(onClick);
                }
            }
        }
    }

    /**
     * 绑定点击监听器
     *
     * @param onTouch
     * @param views
     *         要绑定OnTouchListener监听器的views数组
     */
    protected void bindOnTouchLister(View.OnTouchListener onTouch, View... views)
    {
        if (onTouch != null && views != null)
        {
            for (View view : views)
            {
                if (view != null)
                {
                    view.setOnTouchListener(onTouch);
                }
            }
        }
    }

    /******************************** 【 System Operator 】 *******************************************/
    @Override
    public final void handleCommonMsg(Message msg)
    {
    }

    // setUserVisibleHint 每次 fragment 显示与隐藏都会调用,优于 onCreate 调用，所以当 onCreate 调用完毕
    // setUserVisibleHint 就不会触发，这时需要在首个显示的fragment调用setUserVisibleHint方法
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser)
    {
        Logs.d(setTag(), "setUserVisibleHint => " + isVisibleToUser);
        super.setUserVisibleHint(isVisibleToUser);
    }

    /******************************** 【 Activity start 】 *******************************************/
    /**
     * 调用此方法向左滑动
     *
     * @param intent
     */
    public void startActivityWithSlide(Intent intent)
    {
        startActivity(intent);
        // 调用此 finish ，页面会向左滑动
        activity.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    /**
     * 调用此方法向左滑动 并 设置请求码
     *
     * @param intent
     * @param requestCode
     */
    public void startActivityWithSlideForResult(Intent intent, int requestCode)
    {
        startActivityForResult(intent, requestCode);
        // 调用此 finish ，页面会向左滑动
        activity.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    /******************************** 【 Tag Operator 】 *******************************************/
    /**
     * set the LogCat Tag,this will set the Tag of current flag
     *
     * @return
     */
    protected abstract String setFragmentTag();

    private String setTag()
    {
        return TextUtils.isEmpty(setFragmentTag()) ? TAG : setFragmentTag();
    }
}
