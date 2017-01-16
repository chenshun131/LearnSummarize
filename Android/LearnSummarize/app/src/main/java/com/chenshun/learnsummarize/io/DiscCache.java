package com.chenshun.learnsummarize.io;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Environment;
import android.text.TextUtils;

import com.chenshun.learnsummarize.App;
import com.chenshun.learnsummarize.constant.Constants;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.utils.IoUtils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * User: chenshun <p />
 * Time: 16/10/13 15:13  <p />
 * Version: V1.0  <p />
 * Description: User Files Disc Cache ,include image,audio,video,VCard,etc.. <p />
 */
public class DiscCache implements DiskCache
{
    private static final String CACHE_PATH = Constants.CACHE_IMAGELOADER_PATH;
    private static final String TEMP_IMAGE_POSTFIX = ".tmp";
    private static final int DEFAULT_BUFFER_SIZE = 100 * 1024; // 100 Kb
    private static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.PNG;
    private static final int DEFAULT_COMPRESS_QUALITY = 100;

    @Override
    public File getDirectory()
    {
        File appCacheDir = null;
        Context context = App.getInstance().getApplicationContext();
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) && hasExternalStoragePermission(context))
        {
            appCacheDir = getExternalCacheDir(CACHE_PATH);
        }
        if (appCacheDir == null)
        {
            appCacheDir = context.getCacheDir();
        }
        if (appCacheDir == null)
        {
            String cacheDirPath = "/data/data/" + context.getPackageName() + "/cache/";
            appCacheDir = new File(cacheDirPath);
        }
        return appCacheDir;
    }

    @Override
    public File get(String imageUri)
    {
        return getCacheFile(FileType.Photo, imageUri);
    }

    @Override
    public boolean save(String imageUri, InputStream imageStream, IoUtils.CopyListener listener) throws IOException
    {
        File imageFile = get(imageUri);
        File tmpFile = new File(imageFile.getAbsolutePath() + TEMP_IMAGE_POSTFIX);
        boolean loaded = false;
        try
        {
            OutputStream os = new BufferedOutputStream(new FileOutputStream(tmpFile), DEFAULT_BUFFER_SIZE);
            try
            {
                loaded = IoUtils.copyStream(imageStream, os, listener, DEFAULT_BUFFER_SIZE);
            }
            finally
            {
                IoUtils.closeSilently(os);
            }
        }
        finally
        {
            IoUtils.closeSilently(imageStream);
            if (loaded && !tmpFile.renameTo(imageFile))
            {
                loaded = false;
            }
            if (!loaded)
            {
                tmpFile.delete();
            }
        }
        return loaded;
    }

    @Override
    public boolean save(String imageUri, Bitmap bitmap) throws IOException
    {
        File imageFile = get(imageUri);
        File tmpFile = new File(imageFile.getAbsolutePath() + TEMP_IMAGE_POSTFIX);
        OutputStream os = new BufferedOutputStream(new FileOutputStream(tmpFile), DEFAULT_BUFFER_SIZE);
        boolean savedSuccessfully = false;
        try
        {
            savedSuccessfully = bitmap.compress(DEFAULT_COMPRESS_FORMAT, DEFAULT_COMPRESS_QUALITY, os);//图片压缩
        }
        finally
        {
            IoUtils.closeSilently(os);
            if (savedSuccessfully && !tmpFile.renameTo(imageFile))
            {
                savedSuccessfully = false;
            }
            if (!savedSuccessfully)
            {
                tmpFile.delete();
            }
        }
        bitmap.recycle();
        return savedSuccessfully;
    }

    @Override
    public boolean remove(String imageUri)
    {
        return get(imageUri).delete();
    }

    @Override
    public void close()
    {
    }

    @Override
    public void clear()
    {
        File cacheDir = getCacheDirectory();
        deleteDir(cacheDir);
    }

    private void deleteDir(File dir)
    {
        if (!dir.exists())
        {
            return;
        }
        File[] files = dir.listFiles();
        if (files != null)
        {
            for (File f : files)
            {
                if (f.isFile())
                {
                    f.delete();
                }
                if (f.isDirectory())
                {
                    deleteDir(f);
                }
            }
        }
    }

    /**
     * creare the base cache Directory<br/>
     * if have external storage and have wrote external storage permission,create Directory in external storage.<br />
     * or return the absolute path to the application specific cache directory on the filesystem<br />
     * otherwise return the path of "/data/data/" + context.getPackageName() + "/cache/"
     *
     * @return
     */
    public static File getCacheDirectory()
    {
        File appCacheDir = null;
        Context context = App.getInstance().getApplicationContext();
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) && hasExternalStoragePermission(context))
        {
            appCacheDir = getExternalCacheDir(CACHE_PATH);
        }
        if (appCacheDir == null)
        {
            appCacheDir = context.getCacheDir();
        }
        if (appCacheDir == null)
        {
            String cacheDirPath = "/data/data/" + context.getPackageName() + "/cache/";
            appCacheDir = new File(cacheDirPath);
        }
        return appCacheDir;
    }

    /**
     * according to the path,create Directory base the Android external storage directory.<br/>
     * if fail,use mkdirs() method,is success,create <strong>.nomedia</strong> file,otherwise return null
     *
     * @param path
     * @return
     */
    private static File getExternalCacheDir(String path)
    {
        File appCacheDir = new File(Environment.getExternalStorageDirectory(), path);
        if (!appCacheDir.exists())
        {
            if (!appCacheDir.mkdirs())
            {
                return null;
            }
            try
            {
                new File(appCacheDir, ".nomedia").createNewFile();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return appCacheDir;
    }

    /**
     * create cache directory base on FileType
     *
     * @param fileType
     * @return
     */
    public static File getCacheDirectory(FileType fileType)
    {
        File file = new File(getCacheDirectory(), fileType.getSubDirectory());
        if (!file.exists())
        {
            file.mkdir();
        }
        return file;
    }

    /**
     * create File in the cache FileType directory and file name influenced by key
     *
     * @param fileType
     * @param key
     *         the file URI
     * @return
     */
    public static File getCacheFile(FileType fileType, String key)
    {
        if (fileType == null || key == null)
        {
            throw new IllegalArgumentException("FileType and key can't be null");
        }
        FileNameGenerator fileNameGenerator = new Md5FileNameGenerator();
        String fileName = fileNameGenerator.generate(key);
        if (fileType == FileType.ZIP && !TextUtils.isEmpty(fileName))
        {
            fileName += ".zip";
        }
        return new File(getCacheDirectory(fileType), fileName);
    }

    /**
     * check whether have wrote external storage permission
     *
     * @param context
     * @return
     */
    public static boolean hasExternalStoragePermission(Context context)
    {
        int perm = context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
        return perm == PackageManager.PERMISSION_GRANTED;
    }
}

