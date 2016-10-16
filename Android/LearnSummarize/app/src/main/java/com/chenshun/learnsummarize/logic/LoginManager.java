package com.chenshun.learnsummarize.logic;

import android.content.ContentValues;
import android.content.Context;

import com.chenshun.learnsummarize.constant.Constants;
import com.chenshun.learnsummarize.service.CoreService;
import com.chenshun.learnsummarize.service.CoreService.Transaction;
import com.lzy.okgo.callback.StringCallback;

/**
 * User: chenshun <p />
 * Time: 16/10/14 16:37  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class LoginManager
{
    /**
     *
     * @param context
     * @param callback
     */
    public static void captcha(Context context, StringCallback callback)
    {
        Transaction transaction = new Transaction();
        transaction.what = Transaction.EVENT_REQUEST_CAPTCHA;
        transaction.callback = callback;
        CoreService.requestTransaction(context, transaction);
    }

    /**
     * 登录
     *
     * @param context
     * @param account
     * @param password
     * @param imgCode
     *         验证码
     * @param callback
     */
    public static void login(Context context, String account, String password, String imgCode, StringCallback callback)
    {
        Transaction transaction = new Transaction();
        transaction.what = Transaction.EVENT_REQUEST_LOGIN;
        ContentValues values = new ContentValues(3);
        values.put(Constants.ACCOUNT, account);
        values.put(Constants.PASSWORD, password);
        values.put(Constants.IMGCODE, imgCode);
        values.put(Constants.PLATFORM, "1");// 0:浏览器 1:安卓 2:iOS
        transaction.values = values;
        transaction.callback = callback;
        CoreService.requestTransaction(context, transaction);
    }
}
