package com.chenshun.learnsummarize.io;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * User: chenshun <p />
 * Time: 16/11/17 16:12  <p />
 * Version: V1.0  <p />
 * Description: Overall File Download Manager, For download Internet File.<br>
 *              It is Singleton.<br>
 *              In order to maintain orderly download, <br>
 *              please use this library to download all remote files.<br>
 *              If you just want to show image on UI, please use ImageLoader instead.<br>
 *              NOTICE:fileLoadListener events will be called in different threads According to FileLoadType <p />
 */
public final class FileLoader
{
    private final int MAX_DAMEON_THREAD_COUNT = 2;
    private final int MAX_UI_THREAD_COUNT = 2;

    private final String THREAD_POOL_PREFIX = "fileloader";

    private ThreadPoolExecutor mDameonExecutor = DefaultThreadFactory.createExecutor(MAX_DAMEON_THREAD_COUNT, Thread.NORM_PRIORITY, QueueProcessingType.FIFO, THREAD_POOL_PREFIX);
    private ThreadPoolExecutor mUIExecutor = DefaultThreadFactory.createExecutor(MAX_UI_THREAD_COUNT, Thread.NORM_PRIORITY, QueueProcessingType.LIFO, THREAD_POOL_PREFIX);

    private static FileLoader mInstance;

    @SuppressLint("UseSparseArrays")
    private final Map<Integer, DownloadTask> mTaskHashMap = Collections.synchronizedMap(new HashMap<Integer, DownloadTask>());

    public static final int DEFAULT_TASK_ID = -1;
    // plus one every time
    private int currentTaskID = 0;

    private static final String TAG = "FileLoader";

    // Tag of thread pool shut down
    private boolean mHasShutDown = false;

    private static final String EXCEPTION_FILE_HAS_EXISTS = "File has been downloaded before: %s,you should use checkLocalFileExists first";
    private static final String ERROR_RENAME_FAILED = "Download Failed, because  Rename temp file from '%s' to '%s' failed";
    private static final String WARN_LOAD_IMAGE_FROM_UI = "Recommand: you should load Image by ImageLoader from ui, FIleLoader will still do this task this time..";
    private static final String Exception_CANCEL_DOWNLOAD_NOT_EXTIST_TASK = "The File exists on disc before, so you should check getLocalFileExists and shouldn't use downloadFile";
    private static final String ERROR_TRY_DOWLOAD_AFTER_SHUTDOWN = "You can't download after FileLoader has been shutDown, download abort";
    private static final String TIPS_HAS_SHUTDOWN = "File Loader has been shut down, don't reuse it  until restart the application";
    private static final String TIPS_DOWNLOAD_SAME_URL = "Another Download task is dowloading the same URL, I will receive the loading status only";

    /**
     * File Load Type, if you download from UI,you should use UI, otherwise DAMEON<BR />
     * <B>DAMEON</B> download order FIFO (First In, First Out),FileLoadListener Will be call back in background thread<BR />
     * <B>UI</B> download order LIFO (Last In,First Out)， FileLoadListener Will be call back in UI(main) thread<BR />
     *
     * @author laotian
     *
     */
    public enum FileLoadType
    {
        DAEMON, UI;
    }

    public interface FileLoadListener
    {
        public void onLoadStart(int taskID);

        public void onLoadFinished(int taskID, File file);

        public void onLoadProgress(int taskID, int hasLoad, int totalSize, int percentage);

        public void onLoadFailed(int taskID, IOException exception);
    }

    private static final int MESSAGE_START = 0x100;
    private static final int MESSAGE_UPDATE = 0x102;
    private static final int MESSAGE_DOWN_FINISHED = 0x103;
    private static final int MESSAGE_DOWN_FAILED = 0x104;

    private final Handler mDameonHandler;

    @SuppressLint("HandlerLeak")
    private final Handler mHandler = new Handler(Looper.getMainLooper())
    {

        @Override
        public void handleMessage(Message msg)
        {
            Bundle bundle = msg.getData();
            int taskID = bundle.getInt("taskID");
            DownloadTask task = mTaskHashMap.get(taskID);
            if (task == null)
                return;
            switch (msg.what)
            {
                case MESSAGE_START:
                    DownloadStart(task);
                    break;
                case MESSAGE_UPDATE:
                    int downloadSize = bundle.getInt("downloadSize");
                    int totalFileSize = bundle.getInt("totalFileSize");
                    DownloadUpdateProgress(task, downloadSize, totalFileSize);
                    break;
                case MESSAGE_DOWN_FINISHED:
                    DownloadFinished(task);
                    break;
                case MESSAGE_DOWN_FAILED:
                    IOException t = (IOException) msg.obj;
                    DownloadFailed(task, t);
                    break;
                default:
                    break;
            }
        };

    };

    private FileLoader()
    {
        HandlerThread handlerThread = new HandlerThread("fileloader-dameon-call-back-thread");
        handlerThread.start();
        mDameonHandler = new Handler(handlerThread.getLooper());
    }

    public static FileLoader getInstance()
    {

        if (mInstance == null)
        {
            mInstance = new FileLoader();
        }
        return mInstance;
    }

    /**
     * replace download task Listener<BR />
     * Designed for ListView, when you reuse list item view<BR />
     * from ConvertView, you can replace original Load Listener,<BR />
     * This method will increase the complexity of the procedure, <BR />
     * it is recommended that you use other ViewGroup, for example, ScrollView and LinenearLayout <BR />
     * rather than AbsListView to show Loading status;
     *
     * @param taskID
     * @param listener
     *            new Listener, when download status changes, this listener will receive callback
     */
	/*
	 * private void replaceLoadListener(int taskID, FileLoadListener listener) { synchronized (mTaskHashMap) { DownloadTask task=mTaskHashMap.get(taskID); if(task!=null) task.listener=listener; } }
	 */

    /**
     * Get the HTTP file local save address<BR />
     * it should be the directory by default /sdcard/Android/data/<packageName>/cache/<BR />
     * <B>NOTICE:</B>the file may have not been downloaded before,<BR />
     * and the return file may not exists in disc.<BR />
     * use File.exists() to check it.<BR />
     * fileType and url can't be null ,otherwise it will throw IllegalArgumentException.
     *
     * @exception IllegalArgumentException
     */
    public File getLocalFile(FileType fileType, String url)
    {
        return DiscCache.getCacheFile(fileType, url);
    }

    /**
     * Temp File Type
     *
     * @author laotian
     *
     */
    public enum TempFileType
    {
        // TODO Make sure the audio and video default type;
        Photo(".jpg"), Video(".mp4"), Audio(".amr"), Vcard(".vcf"), APK(".apk"), ZIP(".zip"), LOG(".log");
        private String ext = "";

        private TempFileType(String ext)
        {
            this.ext = ext;
        }

        public String getFileExt()
        {
            return this.ext;
        }
    }

    /**
     * Get A Temp Photo File for image capture<BR />
     * same as getTempFile(TempFileType.Photo);<BR />
     * Notice: It doesn't exists when returned;
     *
     * @return
     */
    public synchronized File getTempFile()
    {
        return getTempFile(TempFileType.Photo);
    }

    /**
     * Get Temp File,for take photo,video,audio etc..
     *
     * @param tempFileType
     * @return
     */
    public synchronized File getTempFile(TempFileType tempFileType)
    {
        // sleep 1 milliSeconds to get a different random seed from Random()
        try
        {
            Thread.sleep(1);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        Random random = new Random(System.nanoTime());
        String tempFile = String.format("file:///random/file-%s", random.nextInt());
        File file = DiscCache.getCacheFile(FileType.TEMP, tempFile);
        file = new File(file.getAbsolutePath() + tempFileType.getFileExt());
        if (file.exists())
        {
            file.delete();
        }
        return file;
    }

    /**
     * Get Image File,for take photo,video,audio etc..
     *
     * @param tempFileType
     * @param name
     * @return File
     * @author n004796
     */
    public synchronized File getTempFile(TempFileType tempFileType, String name)
    {
        File file = DiscCache.getCacheFile(FileType.TEMP, name);
        file = new File(file.getAbsolutePath() + tempFileType.getFileExt());
        return file;
    }

    /**
     * Get logfile path
     *
     * @param tempFileType
     * @param name
     * @return File
     * @author n001131
     */
    public synchronized File getLogFile(TempFileType tempFileType, String name)
    {
        File file = DiscCache.getCacheFile(FileType.LOG, name);
        file = new File(file.getAbsolutePath() + tempFileType.getFileExt());
        return file;
    }

    /**
     * Check the HTTP file whether has been downloaded before<BR />
     * if return false, then call downloadFile
     *
     * @param fileType
     * @param url
     * @return true, if has been downloaded before
     */
    private boolean checkLocalFileExists(FileType fileType, String url)
    {
        return getLocalFile(fileType, url).exists();
    }

    /**
     * Download HTTP File from Internet<BR />
     * You should call <B>checkLocalFileExists</B> before you download<BR />
     * If the localFileExists, it will return LOCAL_FILE_EXISTS_TAG (-1) immediately<BR />
     * If you want to show image on UI, please use ImageLoad instead..
     *
     * @param fileLoadType
     *            UI or DAMEON (from Service,Manager, etc..)
     * @param fileType
     * @param url
     *            http://www.domain.com/xxxx/123.mp3 etc.
     * @return taskID, you can use it to cancel the downloadTask with cancelDownload(taskID)<BR />
     *         -1 If the file has been downloaded before;
     * @author laotian
     */
    public int downloadFile(FileLoadType fileLoadType, FileType fileType, String url)
    {
        return downloadFile(fileLoadType, fileType, url, 0, null);
    }

    /**
     * Download HTTP File from Internet<BR />
     * You should call <B>checkLocalFileExists</B> before you download<BR />
     * If the localFileExists, it will return LOCAL_FILE_EXISTS_TAG (-1) immediately<BR />
     * If you want to show image on UI, please use ImageLoad instead..<BR/>
     * You'd better cancel Unfinished UI download task at activity ondestroy() to avoid exception.
     *
     * @param fileLoadType
     *            UI or DAMEON (from Service,Manager, etc..)
     * @param fileType
     * @param url
     *            http://www.domain.com/xxxx/123.mp3 etc
     * @param fileLoadListener
     * @return taskID, you can use it to cancel the downloadTask with cancelDownload(taskID)<BR />
     *         -1 If the file has been downloaded before;
     * @author laotian
     */
    public int downloadFile(FileLoadType fileLoadType, FileType fileType, String url, FileLoadListener fileLoadListener)
    {
        return downloadFile(fileLoadType, fileType, url, 0, fileLoadListener);
    }

    /**
     * Download HTTP File from Internet<BR />
     * You should call <B>checkLocalFileExists</B> before you download<BR />
     * If the localFileExists, it will return LOCAL_FILE_EXISTS_TAG (-1) immediately<BR />
     * If you want to show image on UI, please use ImageLoad instead..<BR />
     * You'd better cancel Unfinished UI download task at activity ondestroy() to avoid exception.
     *
     * @param fileLoadType
     *            UI or DAMEON (from Service,Manager, etc..)<BR />
     * @param fileType
     * @param url
     *            http://www.domain.com/xxxx/123.mp3 etc.
     * @param timeoutSeconds
     *            default 0, Connection Timeout Seconds.<BR />
     * @param fileLoadListener
     * @return taskID, you can use it to cancel the downloadTask with cancelDownload(taskID)<BR />
     *         -1 If the file has been downloaded before;
     * @author laotian
     */
    public int downloadFile(FileLoadType fileLoadType, FileType fileType, String url, int timeoutSeconds, FileLoadListener fileLoadListener)
    {
        if (mHasShutDown)
        {
            Log.e(TAG, ERROR_TRY_DOWLOAD_AFTER_SHUTDOWN);
            return DEFAULT_TASK_ID;
        }

        // IF file exists on local disc, onLoadFinish call back and return -1;
        if (checkLocalFileExists(fileType, url))
        {
            Log.w(TAG, String.format(EXCEPTION_FILE_HAS_EXISTS, url));

            if (fileLoadListener != null)
            {
                fileLoadListener.onLoadFinished(DEFAULT_TASK_ID, getLocalFile(fileType, url));
            }
            return DEFAULT_TASK_ID;
        }

        if (fileLoadType == FileLoadType.UI && fileType == FileType.Photo)
        {
            Log.w(TAG, WARN_LOAD_IMAGE_FROM_UI);
        }

        DownloadTask downloadTask;
        synchronized (mTaskHashMap)
        {
            currentTaskID++;
            downloadTask = new DownloadTask(currentTaskID, fileLoadType, fileType, url, timeoutSeconds, fileLoadListener);
            mTaskHashMap.put(currentTaskID, downloadTask);
        }

        switch (fileLoadType)
        {
            case DAEMON:
                mDameonExecutor.execute(downloadTask);
                break;
            case UI:
                mUIExecutor.execute(downloadTask);
            default:
                break;
        }

        return currentTaskID;
    }

    /**
     * shutDown all thread Pool.<BR />
     * use it when you close the application to release resource. <BR />
     * and reset taskID to zero.<BR />
     * <B>don't </B>use it when your just close an activity because FileLoader is Singleton.<BR />
     */
    public void shutDownNow()
    {
        mHasShutDown = true;
        mInstance = null;
        mTaskHashMap.clear();
        mDameonExecutor.shutdownNow();
        mUIExecutor.shutdownNow();
        Log.w(TAG, TIPS_HAS_SHUTDOWN);
    }

    /**
     * Cancel the Download task with taskID<br />
     * You can get the taskID when you call downloadFile.
     *
     * @param taskID
     *            task ID, you can get it when you call downloadFile.
     */
    public void cancelDownload(int taskID)
    {
        if (taskID == DEFAULT_TASK_ID)
        {
            Log.w(TAG, Exception_CANCEL_DOWNLOAD_NOT_EXTIST_TASK);
            return;
        }

        cancelDownloadTask(taskID);
    }

    /**
     * Cancel Download all tasks in taskList;
     *
     * @param taskList
     *            you can get the taskID when you call downloadFile.
     */
    public void cancelDownload(ArrayList<Integer> taskList)
    {
        for (int i = 0; i < taskList.size(); i++)
        {
            cancelDownload(taskList.get(i));
        }
    }

    private void cancelDownloadTask(int taskID)
    {

        synchronized (mTaskHashMap)
        {
            DownloadTask task = mTaskHashMap.get(taskID);
            if (task == null)
                return;
            task.cancelDownload();
            // If task B is downloading the same URL, task B will go on downloading...
            if (task.isShadow)
            {
                // Remove Notify from Another SAME URL Downloading task
                for (int i = 0; i < mTaskHashMap.size(); i++)
                {
                    DownloadTask downloadTask = mTaskHashMap.get(i);
                    if (downloadTask != null && downloadTask.taskID != taskID && downloadTask.haveShadow)
                    {
                        Iterator<Integer> iterator = downloadTask.shadowList.iterator();
                        while (iterator.hasNext())
                        {
                            int shadowID = iterator.next();
                            if (shadowID == taskID)
                            {
                                iterator.remove();
                            }
                        }

                        downloadTask.haveShadow = (downloadTask.shadowList.size() > 0);
                    }
                }
                task.UnLock();
            }

            if (task.haveShadow)
            {
                for (int i = 0; i < task.shadowList.size(); i++)
                {
                    int shadowTaskID = task.shadowList.get(i);
                    DownloadTask shadowTask = mTaskHashMap.get(shadowTaskID);
                    if (shadowTask != null)
                        shadowTask.UnLock();
                }
            }

            removeTask(taskID);
            Log.v(TAG, " task have been stoped  with taskID:" + taskID);
        }

    }

    private void removeTask(int taskID)
    {
        synchronized (mTaskHashMap)
        {

            DownloadTask task = mTaskHashMap.get(taskID);
            if (task == null)
                return;
            FileLoadType fileLoadType = task.fileLoadType;
            if (fileLoadType == FileLoadType.DAEMON)
            {
                mDameonExecutor.remove(task);
            }
            else
            {
                mUIExecutor.remove(task);
            }

            mTaskHashMap.remove(taskID);
        }
    }

    private void DownloadFailed(final DownloadTask task, final IOException t)
    {
        if (task == null)
            return;
        Log.e(TAG, "Dowload Failed , url:" + task.url);
        // t.printStackTrace();
        task.isLoading = false;
        task.removeTempFile();
        removeTask(task.taskID);
        if (task.listener != null)
        {
            if (task.fileLoadType == FileLoadType.UI)
            {
                task.listener.onLoadFailed(task.taskID, t);
            }
            else
            {
                // Call in damon thread;
                mDameonHandler.post(new Runnable()
                {

                    @Override
                    public void run()
                    {
                        task.listener.onLoadFailed(task.taskID, t);
                    }
                });
            }

        }

        // IF another task is downloading the same URL,synchronize the loading status
        synchronized (mTaskHashMap)
        {
            if (task.haveShadow)
            {
                for (int i = 0; i < task.shadowList.size(); i++)
                {
                    int taskID = task.shadowList.get(i);
                    DownloadTask shadowTask = mTaskHashMap.get(taskID);
                    if (shadowTask != null)
                    {
                        shadowTask.cancelDownload();
                        shadowTask.UnLock();
                        DownloadFailed(shadowTask, t);
                    }
                }
            }
        }
    }

    private void DownloadFinished(final DownloadTask task)
    {
        if (task == null)
            return;
        Log.v(TAG, "file download successfully, taskID:" + task.taskID + ";  url:" + task.url);
        task.isLoading = false;
        removeTask(task.taskID);

        if (task.listener != null)
        {
            if (task.fileLoadType == FileLoadType.UI)
                task.listener.onLoadFinished(task.taskID, getLocalFile(task.fileType, task.url));
            else
            {
                mDameonHandler.post(new Runnable()
                {

                    @Override
                    public void run()
                    {
                        task.listener.onLoadFinished(task.taskID, getLocalFile(task.fileType, task.url));
                    }
                });
            }
        }

        // IF another task is downloading the same URL,synchronize the loading status
        synchronized (mTaskHashMap)
        {
            if (task.haveShadow)
            {
                for (int i = 0; i < task.shadowList.size(); i++)
                {
                    int taskID = task.shadowList.get(i);
                    DownloadTask shadowTask = mTaskHashMap.get(taskID);
                    if (shadowTask != null)
                    {
                        shadowTask.cancelDownload();
                        shadowTask.UnLock();
                        DownloadFinished(shadowTask);
                    }
                }
            }
        }

    }

    private void DownloadStart(final DownloadTask task)
    {
        if (task == null)
            return;
        if (task.listener != null)
        {
            if (task.fileLoadType == FileLoadType.UI)
            {
                task.listener.onLoadStart(task.taskID);
            }
            else
            {
                mDameonHandler.post(new Runnable()
                {

                    @Override
                    public void run()
                    {
                        task.listener.onLoadStart(task.taskID);
                    }
                });
            }
        }

        // IF another task is downloading the same URL,synchronize the loading status
        synchronized (mTaskHashMap)
        {
            if (task.haveShadow)
            {
                for (int i = 0; i < task.shadowList.size(); i++)
                {
                    int taskID = task.shadowList.get(i);
                    DownloadTask shadowTask = mTaskHashMap.get(taskID);
                    DownloadStart(shadowTask);
                }
            }
        }
    }

    private void DownloadUpdateProgress(final DownloadTask task, final int downloadSize, final int totalFileSize)
    {
        if (task == null)
            return;
        if (task.listener != null)
        {
            int mProgress = (int) (((float) downloadSize / (float) totalFileSize) * 100F);
            if (mProgress > 100)
                mProgress = 100;
            if (mProgress < 0)
                mProgress = 0;
            if (task.fileLoadType == FileLoadType.UI)
            {
                task.listener.onLoadProgress(task.taskID, downloadSize, totalFileSize, mProgress);
            }
            else
            {
                final int progress = mProgress;
                mDameonHandler.post(new Runnable()
                {

                    @Override
                    public void run()
                    {
                        task.listener.onLoadProgress(task.taskID, downloadSize, totalFileSize, progress);
                    }
                });
            }
        }

        // IF another task is downloading the same URL,synchronize the loading status
        synchronized (mTaskHashMap)
        {
            if (task.haveShadow)
            {
                for (int i = 0; i < task.shadowList.size(); i++)
                {
                    int taskID = task.shadowList.get(i);
                    DownloadTask shadowTask = mTaskHashMap.get(taskID);
                    DownloadUpdateProgress(shadowTask, downloadSize, totalFileSize);
                }
            }
        }

    }

    private boolean checkSameUrlLoading(FileType fileType, String url, int myTaskID)
    {
        synchronized (mTaskHashMap)
        {

            Iterator<Integer> iterator = mTaskHashMap.keySet().iterator();

            while (iterator.hasNext())
            {
                int taskID = iterator.next();
                DownloadTask task = mTaskHashMap.get(taskID);
                if (task.taskID != myTaskID && task.isLoading && task.fileType == fileType && task.url.equals(url))
                {
                    task.haveShadow = true;
                    task.shadowList.add(myTaskID);
                    return true;
                }
            }

            return false;
        }

    }

    /**
     * DownLoad Task Thread
     *
     * @author laotian
     *
     */
    protected class DownloadTask implements Runnable
    {
        public int taskID;
        public String url;
        public FileType fileType;
        public FileLoadType fileLoadType;
        public FileLoadListener listener;
        public boolean taskCancelled = false;
        public boolean isLoading = false;
        /** TAG: If task B is downloading the same URL as task A ,then task A haveShadow tag equals true */
        public boolean haveShadow = false;
        public boolean isShadow = false;
        public ArrayList<Integer> shadowList = new ArrayList<Integer>();

        private String tempFile;
        private Object lockObject = new Object();

        // default 0,no timeout.
        private int timeoutSeconds = 0;

        public DownloadTask(int taskID, FileLoadType fileLoadType, FileType fileType, String url, int timeoutSeconds, FileLoadListener listener)
        {
            this.taskID = taskID;
            this.fileLoadType = fileLoadType;
            this.fileType = fileType;
            this.url = url;
            this.listener = listener;
            this.timeoutSeconds = timeoutSeconds;
            this.tempFile = DiscCache.getCacheFile(fileType, url).getAbsoluteFile() + "_" + String.valueOf(new Random().nextInt()) + ".tmp";
        }

        public void cancelDownload()
        {
            taskCancelled = true;
            // this.listener=null;
        }

        public void removeTempFile()
        {
            new File(tempFile).delete();
        }

        public void UnLock()
        {
            synchronized (lockObject)
            {
                lockObject.notifyAll();
            }
        }

        private void Lock()
        {
            synchronized (lockObject)
            {
                try
                {
                    lockObject.wait();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }

        private void sendMessage(int messageCode, int downloadSize, int totalFileSize, Throwable throwable)
        {
            Message message = mHandler.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putInt("taskID", taskID);
            message.what = messageCode;

            if (messageCode == MESSAGE_UPDATE)
            {
                bundle.putInt("downloadSize", downloadSize);
                bundle.putInt("totalFileSize", totalFileSize);
            }
            else if (messageCode == MESSAGE_DOWN_FAILED)
            {
                message.obj = throwable;
            }

            message.setData(bundle);
            message.sendToTarget();
        }

        @Override
        public void run()
        {

            if (checkLocalFileExists(fileType, url))
            {
                sendMessage(MESSAGE_DOWN_FINISHED, 0, 0, null);
                return;
            }
            // check if a twin FileDownload Task is running with the same Type and URL
            // if so, make this as shadow,just receive download status message,don't download.
            while (!taskCancelled && checkSameUrlLoading(fileType, url, taskID))
            {
                // when twin FileDownload Task has done successfully,the taskCancelled will be set true;
                Log.v(TAG, TIPS_DOWNLOAD_SAME_URL);
                isShadow = true;
                Lock();
            }

            if (taskCancelled)
                return;

            isLoading = true;
            sendMessage(MESSAGE_START, 0, 0, null);

            try
            {
                URL downloadURL = new URL(url);
                HttpURLConnection conn = (HttpURLConnection) downloadURL.openConnection();
                if (timeoutSeconds > 0)
                    conn.setReadTimeout(timeoutSeconds * 1000);
                // Dont's use Accept gzip Encoding,because the getContentLength() may be -1;
                conn.setRequestProperty("Accept-Encoding", "identity");
                conn.connect();
                int length = conn.getContentLength();
                InputStream is = conn.getInputStream();

                FileOutputStream fos = new FileOutputStream(tempFile);

                int count = 0;
                // 10K
                byte buf[] = new byte[1024 * 10];
                int numread = -1;
                while ((numread = is.read(buf)) > 0 && !taskCancelled)
                {
                    fos.write(buf, 0, numread);
                    count += numread;
                    if (!taskCancelled)
                        sendMessage(MESSAGE_UPDATE, count, length, null);
                }
                fos.flush();
                fos.close();
                is.close();

                if (taskCancelled)
                {
                    removeTempFile();
                    return;
                }

                File saveTo = getLocalFile(fileType, url);
                // check agin file exists will better; sign;
                File tFile = new File(tempFile);

                if (tFile.renameTo(saveTo))
                {
                    sendMessage(MESSAGE_DOWN_FINISHED, 0, 0, null);
                }
                else
                {
                    sendMessage(MESSAGE_DOWN_FAILED, 0, 0, new IOException(String.format(ERROR_RENAME_FAILED, url, saveTo)));
                }
            }
            catch (IOException e)
            {
                sendMessage(MESSAGE_DOWN_FAILED, 0, 0, e);
            }
        }
    }
}

