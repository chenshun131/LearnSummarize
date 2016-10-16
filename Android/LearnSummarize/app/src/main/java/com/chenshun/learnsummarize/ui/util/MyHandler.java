package com.chenshun.learnsummarize.ui.util;

import android.os.Handler;
import android.os.Message;

import com.chenshun.learnsummarize.util.Logs;

/**
 * User: chenshun <p />
 * Time: 16/10/15 22:47 <p />
 * Version V1.0  <p />
 * Description: <p />
 */
public class MyHandler extends Handler
{
    private final String TAG = this.getClass().getSimpleName();

    private HandlerInterface callback;

    public MyHandler(HandlerInterface callback)
    {
        if (callback == null)
        {
            throw new IllegalArgumentException("HandlerInterface can not be null!");
        }
        this.callback = callback;
    }

    @Override
    public void handleMessage(Message msg)
    {
        if (msg == null)
        {
            Logs.e(TAG, "bad code msg is null");
            return;
        }
        Logs.d(TAG, "msg code = handleMessage " + Integer.toHexString(msg.what));
        switch (msg.what)
        {
            case CodeUtil.CmdCode.MSG_COMMON_HANDLE:
                callback.handleCommonMsg(msg);
                break;
            default:
                dispatchMsg(msg);
                break;
        }
    }

    /**
     * according to MsgTypeCode,use different handleMessage method
     *
     * @param msg
     * @return
     */
    public boolean dispatchMsg(Message msg)
    {
        if (msg == null)
        {
            Logs.e(TAG, "bad code msg is null");
            return false;
        }
        if (CodeUtil.CmdCode.isUICode(msg.what))
        {
            Logs.d(TAG, "ui code" + Integer.toHexString(msg.what));
            return callback.handleUIMessage(msg);
        }
        else if (CodeUtil.CmdCode.isNotifyCode(msg.what))
        {
            Logs.d(TAG, "notify code" + Integer.toHexString(msg.what));
            return callback.handleNotifyMessage(msg);
        }
        else
        {
            return callback.handleMessage(msg);
        }
    }
}
