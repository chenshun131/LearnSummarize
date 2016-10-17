package com.chenshun.learnsummarize.ui.util;

import android.os.Handler;
import android.os.Message;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * User: chenshun <p />
 * Time: 16/10/15 22:45 <p />
 * Version V1.0  <p />
 * Description: <p />
 */
public class HandlerCache implements Handler.Callback
{
    private final String TAG = this.getClass().getSimpleName();

    /** save all Handler */
    private static List<Handler> sUIHandlers = new ArrayList<Handler>();

    /**
     * create new HandlerCache and save this HandlerCache in Cache Callback
     */
    public HandlerCache()
    {
        Cache.getInstance().setCallBack(this);
    }

    /**
     * add Handler to List&lt;Handler&gt; sUIHandlers,always return true
     *
     * @param handler
     * @return
     */
    public boolean registerHandler(Handler handler)
    {
        boolean result;
        synchronized (sUIHandlers)
        {
            result = sUIHandlers.add(handler);
        }
        Cache.getInstance().setCallBack(this);
        return result;
    }

    /**
     * remove Handler to List&lt;Handler&gt; sUIHandlers,if success,return true,otherwise return false
     *
     * @param handler
     * @return
     */
    public boolean unRegisterHandler(Handler handler)
    {
        if (sUIHandlers == null || sUIHandlers.size() == 0)
        {
            return true;
        }
        boolean result;
        synchronized (sUIHandlers)
        {
            result = sUIHandlers.remove(handler);
        }
        Cache.getInstance().setCallBack(this);
        return result;
    }

    // this method will send Message to all Handler in the List<Handler> sUIHandlers
    @Override
    public boolean handleMessage(Message message)
    {
        if (null == message)
        {
            return false;
        }
        if (null == sUIHandlers)
        {
            return false;
        }
        synchronized (sUIHandlers)
        {
            Iterator<Handler> iterator = sUIHandlers.iterator();
            while (iterator.hasNext())
            {
                Handler handler = iterator.next();
                if (handler == null)
                {
                    continue;
                }
                handler.sendMessage(Message.obtain(message));
            }
        }
        return false;
    }
}

