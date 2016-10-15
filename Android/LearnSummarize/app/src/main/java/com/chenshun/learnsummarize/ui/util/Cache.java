package com.chenshun.learnsummarize.ui.util;

import android.os.Handler.Callback;
import android.text.TextUtils;

import com.chenshun.learnsummarize.constant.SPConst;
import com.chenshun.learnsummarize.util.PreferensesUtil;

/**
 * User: chenshun <p />
 * Time: 16/10/14 09:01  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public final class Cache
{
    /** this Attribute must be <strong>private static</strong> and use for save the instance */
    private static Cache mCache = new Cache();
    /** Callback interface you can use when instantiating a Handler to avoid having to implement your own subclass of Handler. */
    private Callback callBack;

    // common message
    private String UserName;// 当前用户名称
    private String phoneNumber;// 电话号码
    private boolean netWorkIsOk = true;// 网络连接状态是否正常

    private Cache()
    {
    }

    /**
     * get instance of Cache
     *
     * @return
     */
    public static Cache getInstance()
    {
        return mCache;
    }

    /**
     * get callBack Attribute
     *
     * @return
     */
    public Callback getCallBack()
    {
        return callBack;
    }

    /**
     * set callBack Attribute
     *
     * @param callBack
     */
    public void setCallBack(Callback callBack)
    {
        this.callBack = callBack;
    }

    public void clearAllLoginData()
    {
        UserName = "";
        phoneNumber = "";
    }

    public String getUserName()
    {
        if (TextUtils.isEmpty(UserName))
        {
            UserName = new PreferensesUtil(null, SPConst.SP_USER).getString(SPConst.SP_USER_USERNAME);
        }
        return UserName;
    }

    public void setUserName(String mUserName)
    {
        this.UserName = mUserName;
    }

    public String getPhoneNumber()
    {
        if (TextUtils.isEmpty(phoneNumber))
        {
            phoneNumber = new PreferensesUtil(null, SPConst.SP_USER).getString(SPConst.SP_USER_PHONENUMBER);
        }
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public boolean isNetWorkIsOk()
    {
        return netWorkIsOk;
    }

    public void setNetWorkIsOk(boolean netWorkIsOk)
    {
        this.netWorkIsOk = netWorkIsOk;
    }
}
