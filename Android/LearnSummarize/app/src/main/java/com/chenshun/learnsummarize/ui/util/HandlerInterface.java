package com.chenshun.learnsummarize.ui.util;

import android.os.Message;

/**
 * User: chenshun <p />
 * Time: 16/10/15 22:46 <p />
 * Version V1.0  <p />
 * Description: <p />
 */
public interface HandlerInterface
{
    /**
     * handler common message
     *
     * @param msg
     */
    void handleCommonMsg(Message msg);

    /**
     * handler notify message
     *
     * @param msg
     * @return
     */
    boolean handleNotifyMessage(Message msg);

    /**
     * handler UI message
     *
     * @param msg
     * @return
     */
    boolean handleUIMessage(Message msg);

    /**
     * handler message
     *
     * @param msg
     * @return
     */
    boolean handleMessage(Message msg);
}
