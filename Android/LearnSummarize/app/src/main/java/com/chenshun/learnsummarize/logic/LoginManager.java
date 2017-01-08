package com.chenshun.learnsummarize.logic;

import android.app.Activity;
import android.content.ContentValues;

import com.chenshun.learnsummarize.service.CoreService;
import com.chenshun.learnsummarize.service.CoreService.Transaction;
import com.lzy.okgo.callback.BitmapCallback;
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
     * 获取 App 信息
     *
     * @param activity
     * @param callback
     */
    public static void getVersionInfo(Activity activity, StringCallback callback)
    {
        Transaction transaction = new Transaction();
        ContentValues values = new ContentValues(3);
        values.put("platform", "1");// 0:浏览器 1:安卓 2:iOS
        transaction.what = Transaction.EVENT_REQUEST_VERSIONINFO;
        transaction.values = values;
        transaction.activity = activity;
        transaction.callback = callback;
        CoreService.requestTransaction(transaction);
    }

    /**
     * @param activity
     * @param callback
     */
    public static void captcha(Activity activity, BitmapCallback callback)
    {
        Transaction transaction = new Transaction();
        transaction.what = Transaction.EVENT_REQUEST_CAPTCHA;
        transaction.activity = activity;
        transaction.callback = callback;
        CoreService.requestTransaction(transaction);
    }

    /**
     * 登录
     *
     * @param activity
     * @param account
     * @param password
     * @param imgCode
     *         验证码
     * @param callback
     */
    public static void login(Activity activity, String account, String password, String imgCode, StringCallback callback)
    {
        Transaction transaction = new Transaction();
        ContentValues values = new ContentValues(3);
        values.put("account", account);
        values.put("password", password);
        values.put("imgCode", imgCode);
        values.put("platform", "1");// 0:浏览器 1:安卓 2:iOS
        transaction.what = Transaction.EVENT_REQUEST_LOGIN;
        transaction.values = values;
        transaction.activity = activity;
        transaction.callback = callback;
        CoreService.requestTransaction(transaction);
    }
}
