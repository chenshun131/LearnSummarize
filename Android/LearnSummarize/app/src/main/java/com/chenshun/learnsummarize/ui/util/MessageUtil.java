package com.chenshun.learnsummarize.ui.util;

import android.os.Handler;
import android.os.Message;

/**
 * User: chenshun <p />
 * Time: 16/10/15 22:47 <p />
 * Version V1.0  <p />
 * Description: <p />
 */
public class MessageUtil
{
    /**
     * Notify the ui that we receive a new message
     *
     * @param msg
     */
    public static void sendMessage(Message msg)
    {
        Handler.Callback callback = Cache.getInstance().getCallBack();
        if (callback != null)
        {
            callback.handleMessage(msg);
        }
    }

    /**
     * send Login Message
     *
     * @param msgCode
     */
    public static void sendMessage(int msgCode)
    {
        Message msg = Message.obtain();
        msg.what = msgCode;
        sendMessage(msg);
    }

    /**
     * send Login Failed Message
     *
     * @param msgCode
     * @param alertMessage
     *            what message
     */
    public static void sendMessage(int msgCode, Object alertMessage)
    {
        Message msg = Message.obtain();
        msg.what = msgCode;
        msg.obj = alertMessage;
        sendMessage(msg);
    }
}
