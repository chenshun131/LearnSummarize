package com.chenshun.learnsummarize.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.chenshun.learnsummarize.ui.util.Cache;
import com.chenshun.learnsummarize.util.NetUtil;

/**
 * User: chenshun <p />
 * Time: 16/10/14 08:56  <p />
 * Version: V1.0  <p />
 * Description: network changed <p />
 */
public class ConnectionChangeReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        if (NetUtil.hasNoNetwork(context))
        {
            Cache.getInstance().setNetWorkIsOk(false);
        }
        else
        {
            Cache.getInstance().setNetWorkIsOk(true);
        }
    }
}
