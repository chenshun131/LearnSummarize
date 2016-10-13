package com.chenshun.learnsummarize.util;

import android.os.Environment;

/**
 * User: chenshun <p />
 * Time: 16/10/13 17:18  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public final class CommonUtil
{
    /**
     * 是否有SDCard
     *
     * @return 是否有SDCard
     */
    public static boolean hasSDCard()
    {
        String status = Environment.getExternalStorageState();
        return status.equals(Environment.MEDIA_MOUNTED);
    }

    /**
     * 获取应用运行的最大内存
     *
     * @return 最大内存
     */
    public static long getMaxMemory()
    {
        return Runtime.getRuntime().maxMemory() / 1024;
    }
}
