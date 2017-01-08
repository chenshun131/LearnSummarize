package com.chenshun.learnsummarize.ui.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.chenshun.learnsummarize.R;
import com.chenshun.learnsummarize.constant.SPConst;
import com.chenshun.learnsummarize.logic.LoginManager;
import com.chenshun.learnsummarize.model.BaseModel;
import com.chenshun.learnsummarize.service.CoreService;
import com.chenshun.learnsummarize.ui.activity.base.BaseActivity;
import com.chenshun.learnsummarize.ui.view.MyProgressDialog;
import com.chenshun.learnsummarize.util.AppUtils;
import com.chenshun.learnsummarize.util.Logs;
import com.chenshun.learnsummarize.util.PreferensesUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.request.BaseRequest;

import okhttp3.Call;
import okhttp3.Response;

/**
 * User: chenshun <p />
 * Time: 16/10/18 16:07  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class InitActivity extends BaseActivity
{
    private final String TAG = this.getClass().getSimpleName();

    private PreferensesUtil mPreferensesUtil;
    private String mVersionName;
    private int mLocalAppVersionCode;
    private MyProgressDialog mDialog;

    @Override
    public boolean handleNotifyMessage(Message msg)
    {
        return false;
    }

    @Override
    public boolean handleUIMessage(Message msg)
    {
        return false;
    }

    @Override
    public boolean handleMessage(Message msg)
    {
        return false;
    }

    @Override
    protected void initData()
    {
        mPreferensesUtil = new PreferensesUtil(InitActivity.this, SPConst.SP_USER);
        mVersionName = AppUtils.getVerName(InitActivity.this);
        mLocalAppVersionCode = AppUtils.getVerCode(InitActivity.this);// 本地版本序号

        // 初始化 CoreService
        Intent intent = new Intent(InitActivity.this, CoreService.class);
        startService(intent);
    }

    @Override
    protected void initView()
    {
        setContentView(R.layout.activity_init);

        LoginManager.getVersionInfo(this, new StringCallback()
        {
            @Override
            public void onBefore(BaseRequest request)
            {
                super.onBefore(request);
                mDialog = new MyProgressDialog(InitActivity.this);
                mDialog.show();
            }

            @Override
            public void onSuccess(String s, Call call, Response response)
            {
                Logs.d(TAG, s);
                BaseModel model = JSON.parseObject(s, BaseModel.class);
                if (model.getCode() == 0)
                {
                    // 成功
                }
                else
                {
                    // 失败
                }
            }

            @Override
            public void onAfter(@Nullable String s, @Nullable Exception e)
            {
                super.onAfter(s, e);
                mDialog.dismiss();
            }
        });
    }

    @Override
    protected void setUI(Configuration newConfig, DisplayMetrics dm)
    {
    }

    @Override
    protected String setFragmentTag()
    {
        return "InitActivity";
    }

    public void http(View v)
    {
        OkGo.get("http://chenshun131.com:8080/LearnSummarize/getVersionInfo").execute(new StringCallback()
        {
            @Override
            public void onSuccess(String s, Call call, Response response)
            {
                Log.e("http", "http");
                System.out.print(s);
            }
        });
    }

    public void https(View v)
    {
        OkGo.get("https://chenshun131.com:8443/LearnSummarize/getVersionInfo").execute(new StringCallback()
        {
            @Override
            public void onSuccess(String s, Call call, Response response)
            {
                Log.e("https", "https : " + s);
            }
        });
    }

    public void ip(View v)
    {
        OkGo.get("https://192.168.0.3:8443/LearnSummarize/getVersionInfo").execute(new StringCallback()
        {
            @Override
            public void onSuccess(String s, Call call, Response response)
            {
                Log.e("ip", "ip");
                System.out.print(s);
            }
        });
    }

    public void ipHttps(View v)
    {
        OkGo.get("https://192.168.0.3:8443/LearnSummarize/getVersionInfo").execute(new StringCallback()
        {
            @Override
            public void onSuccess(String s, Call call, Response response)
            {
                Log.e("ipHttps", "ipHttps : " + s);
            }
        });
    }

    public void baidu(View v)
    {
        OkGo.get("http://www.baidu.com").execute(new StringCallback()
        {
            @Override
            public void onSuccess(String s, Call call, Response response)
            {
                Log.e("ip", "ip");
                System.out.print(s);
            }
        });
    }

    public void train12306(View v)
    {
        OkGo.get("https://kyfw.12306.cn/otn/").execute(new StringCallback()
        {
            @Override
            public void onSuccess(String s, Call call, Response response)
            {
                Log.e("train12306", "train12306");
                System.out.print(s);
            }
        });
    }
}
