package com.chenshun.learnsummarize.util;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;

import com.chenshun.learnsummarize.constant.Constants;

/**
 * User: chenshun <p />
 * Time: 16/10/13 17:19  <p />
 * Version: V1.0  <p />
 * Description: 应用数据库导出工具类 <p />
 */
public final class DatabaseExportUtils
{
    private static final boolean DEBUG = Constants.IS_DEBUG;
    private static final String TAG = "DatabaseExportUtils";

    /**
     * Don't let anyone instantiate this class.
     */
    private DatabaseExportUtils()
    {
        throw new Error("Do not need instantiate!");
    }

    /**
     * 开始导出数据 此操作比较耗时,建议在线程中进行
     *
     * @param context
     *         上下文
     * @param targetFile
     *         目标文件
     * @param databaseName
     *         要拷贝的数据库文件名
     * @return 是否倒出成功
     */
    public boolean startExportDatabase(Context context, String targetFile, String databaseName)
    {
        if (DEBUG)
        {
            Logs.d(TAG, "start export ...");
        }
        if (!Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()))
        {
            if (DEBUG)
            {
                Logs.w(TAG, "cannot find SDCard");
            }
            return false;
        }
        String sourceFilePath = Environment.getDataDirectory() + "/data/" + context.getPackageName() + "/databases/" + databaseName;
        String destFilePath = Environment.getExternalStorageDirectory() + (TextUtils.isEmpty(targetFile) ? (context.getPackageName() + ".db") : targetFile);
        boolean isCopySuccess = FileUtils.copyFile(sourceFilePath, destFilePath);
        if (DEBUG)
        {
            if (isCopySuccess)
            {
                Logs.d(TAG, "copy database file success. target file : " + destFilePath);
            }
            else
            {
                Logs.w(TAG, "copy database file failure");
            }
        }
        return isCopySuccess;
    }
}
