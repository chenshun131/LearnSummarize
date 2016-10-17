package com.chenshun.learnsummarize.ui.activity.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.chenshun.learnsummarize.R;
import com.chenshun.learnsummarize.ui.util.HandlerCache;
import com.chenshun.learnsummarize.ui.util.HandlerInterface;
import com.chenshun.learnsummarize.ui.util.MyHandler;
import com.chenshun.learnsummarize.util.Logs;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.PauseOnScrollListener;
import com.umeng.analytics.MobclickAgent;

/**
 * User: chenshun <p />
 * Time: 16/10/15 22:38 <p />
 * Version V1.0  <p />
 * Description: <p />
 */
public abstract class BaseActivity extends AppCompatActivity implements HandlerInterface
{
    protected final String TAG = this.getClass().getSimpleName();
    protected static final String PID_FLAG = "pid";
    /** the identifier of current process, which can be used with killProcess and sendSignal */
    protected static final int MY_PID = android.os.Process.myPid();
    protected int mCode;
    /** common intent */
    protected Intent mLastIntent;
    protected MyHandler mHandler;
    // protected ActionBar mActionBar;
    private HandlerCache mHandlerCache;
    protected ImageLoader mImageLoader = ImageLoader.getInstance();
    /** Whether pause ImageLoader during touch scrolling */
    protected boolean pauseOnScroll = true;
    /** Whether pause ImageLoader during fling */
    protected boolean pauseOnFling = false;
    protected Bundle mSavedInstanceState;

    /******************************** 【Activity LifeCycle For Debug】 *******************************************/
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Logs.d(setTag(), this.getClass().getSimpleName() + " onCreate() invoked!!");
        mSavedInstanceState = savedInstanceState;
        super.onCreate(savedInstanceState);
        if (!handlerBundle(savedInstanceState))
        {
            return;
        }
        initBaseData();
        initHandlerCache();
        initData();
        initView();
        initBack();
        // initActionBar(); TODO 需要重写先关头信息
    }

    @Override
    protected void onStart()
    {
        Logs.d(setTag(), this.getClass().getSimpleName() + " onStart() invoked!!");
        super.onStart();
    }

    @Override
    protected void onRestart()
    {
        Logs.d(setTag(), this.getClass().getSimpleName() + " onRestart() invoked!!");
        super.onRestart();
    }

    @Override
    protected void onResume()
    {
        MobclickAgent.onResume(this);
        Logs.d(setTag(), this.getClass().getSimpleName() + " onResume() invoked!!");
        super.onResume();
    }

    @Override
    protected void onPause()
    {
        MobclickAgent.onPause(this);
        Logs.d(setTag(), this.getClass().getSimpleName() + " onPause() invoked!!");
        super.onPause();
    }

    @Override
    protected void onStop()
    {
        Logs.d(setTag(), this.getClass().getSimpleName() + " onStop() invoked!!");
        super.onStop();
    }

    @Override
    protected void onDestroy()
    {
        Logs.d(setTag(), this.getClass().getSimpleName() + " onDestroy() invoked!!");
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        // onSaveInstanceState是用来保存UI状态的，你可以使用它保存你所想保存的东西，在Activity杀死之前，它一般在onStop或者onPause之前触发
        outState.putInt(PID_FLAG, MY_PID);
    }

    /**
     * initialized Base data:<br/>
     * Intent mLastIntent<br/>
     * QixinHandler mHandler<br/>
     */
    private void initBaseData()
    {
        mLastIntent = getIntent();
        mHandler = new MyHandler(this);
    }

    private void initHandlerCache()
    {
        mHandlerCache = new HandlerCache();
        mHandlerCache.registerHandler(mHandler);
    }

    protected abstract void initData();

    protected abstract void initView();

    protected void initBack()
    {
        ImageView backIv = (ImageView) findViewById(R.id.actionbar_back_iv);
        if (backIv != null)
        {
            backIv.setOnClickListener(new OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    finish();
                }
            });
        }
    }

    /******************************** 【 Top Operator】 *******************************************/
    @Override
    public void setTitle(CharSequence title)
    {
        TextView titleTv = (TextView) findViewById(R.id.actionbar_title_tv);
        if (titleTv == null)
        {
            super.setTitle(title);
        }
        else
        {
            titleTv.setText(title);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBack();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void onBack()
    {
        finish();
    }

    protected boolean handlerBundle(Bundle bundle)
    {
        if (null == bundle)
        {
            return true;
        }
        // Bundle 不包含 "pid"的 key-value值
        if (!bundle.containsKey(PID_FLAG))
        {
            return true;
        }
        // 获取 Bundle 中 "pid" 值判断是否等于 android.os.Process.myPid()
        if (MY_PID == bundle.getInt(PID_FLAG))
        {
            return true;
        }
        this.finish();
        return false;
    }

    /******************************** 【 Dialog Operation 】 *******************************************/
    /**
     * set the Dialog auto dismiss after delay milliseconds
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
     * Allow ImageLoader to stop load when ListView onScroll and onFling
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
        if (onClick == null)
        {
            return;
        }
        if (views == null)
        {
            return;
        }
        for (View view : views)
        {
            if (view != null)
            {
                view.setOnClickListener(onClick);
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
        if (onTouch == null)
        {
            return;
        }
        if (views == null)
        {
            return;
        }
        for (View view : views)
        {
            if (view != null)
            {
                view.setOnTouchListener(onTouch);
            }
        }
    }

    /******************************** 【 System Operator 】 *******************************************/
    /**
     * get DisplayMetrics
     *
     * @return
     */
    protected DisplayMetrics getDisplayMetrics()
    {
        DisplayMetrics dm = this.getApplicationContext().getResources().getDisplayMetrics();
        return dm;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        setUI(newConfig, getDisplayMetrics());
    }

    protected abstract void setUI(Configuration newConfig, DisplayMetrics dm);

    public final void handleCommonMsg(Message msg)
    {
    }

    /******************************** 【 Activity start or finish 】 *******************************************/
    /**
     * 调用此方法向左滑动
     */
    public void startActivityWithSlide(Intent intent)
    {
        startActivity(intent);
        // 调用此 finish ，页面会向左滑动
        overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
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
        overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    @Override
    public void finish()
    {
        defaultFinish();
        // 调用此 finish ，页面会向右滑动
        overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
    }

    /**
     * 调用此 finish ，页面不会滑动，特别注意：要是关闭以后不再使用的界面就调用该方法
     */
    public void defaultFinish()
    {
        releaseAllResource();
        // Cancel all Unfinished UI download task
        super.finish();
    }

    public void releaseAllResource()
    {
        if (null != mHandler)
        {
            // Remove any pending posts of callbacks and sent messages whose obj is token. If token is null, all callbacks and messages will be
            // removed
            mHandler.removeCallbacksAndMessages(null);
        }
        if (mHandlerCache != null)
        {
            mHandlerCache.unRegisterHandler(mHandler);
        }
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
