package com.chenshun.learnsummarize;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.multidex.MultiDex;

import com.antfortune.freeline.FreelineCore;
import com.chenshun.learnsummarize.constant.Constants;
import com.chenshun.learnsummarize.image.DisplayImageOption;
import com.chenshun.learnsummarize.io.DefaultThreadFactory;
import com.chenshun.learnsummarize.io.DiscCache;
import com.chenshun.learnsummarize.ui.activity.database.greendao.gen.DaoMaster;
import com.chenshun.learnsummarize.ui.activity.database.greendao.gen.DaoSession;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.cookie.store.MemoryCookieStore;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadPoolExecutor;

import cat.ereza.customactivityoncrash.CustomActivityOnCrash;
import io.realm.Realm;
import io.realm.log.LogLevel;
import io.realm.log.RealmLog;
import okhttp3.Cache;

/**
 * User: chenshun <p />
 * Time: 16/10/13 15:56  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class App extends Application
{
    private static App instance;
    private RefWatcher rw;

    // GreenDao
    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    @Override
    public void onCreate()
    {
        super.onCreate();
        instance = this;
        initLeakCanary();
        initFreeline();
        initRealm();
        initNetwork();
        initImageLoader(this);
        initCustomActivityOnCrash();
        initGreenDao();
    }

    @Override
    protected void attachBaseContext(Context base)
    {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    private void initNetwork()
    {
        OkGo.init(this);
        OkGo okGo = OkGo.getInstance();
        if (Constants.IS_DEBUG)
        {
            okGo.debug("OkGo");
        }
        okGo.setConnectTimeout(OkGo.DEFAULT_MILLISECONDS);
        okGo.setReadTimeOut(OkGo.DEFAULT_MILLISECONDS);// 读取超时
        okGo.setWriteTimeOut(OkGo.DEFAULT_MILLISECONDS);// 写入超时
        okGo.setCacheMode(CacheMode.DEFAULT);
        okGo.setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE);
        okGo.setCookieStore(new MemoryCookieStore());// cookie使用内存缓存（app退出后，cookie消失）
        okGo.getOkHttpClientBuilder().cache(new Cache(new File("xx/xxx/"), 20 * 1024));


        // init cer
        // okGo.setCertificates(new Buffer().writeUtf8(Constants.CER).inputStream()); // Buffer use okio packeg and okhttp denpend on okio
//        okGo.setCertificates(getAssets().open("kyfw.12306.cn.cer")); // 测试连接 12306网站
//        okGo.setCertificates(getAssets().open("mobile_client.cer")); //
        try
        {
            okGo.setCertificates(getAssets().open("client.bks"), "123456", getAssets().open("client.cer"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        // 可以设置https的证书,以下几种方案根据需要自己设置,不需要不用设置
        // .setCertificates()                                                                     //方法一：信任所有证书
        // .setCertificates(getAssets().open("srca.cer"))                                         //方法二：也可以自己设置https证书
        // .setCertificates(getAssets().open("aaaa.bks"), "123456", getAssets().open("srca.cer")) //方法三：传入bks证书,密码,和cer证书,支持双向加密
    }

    /**
     * get the instance of GiftApplication
     *
     * @return
     */
    public static App getInstance()
    {
        return instance;
    }

    public static RefWatcher getRefWatcher(Context context)
    {
        App application = (App) context.getApplicationContext();
        return application.rw;
    }

    private void initLeakCanary()
    {
        if (LeakCanary.isInAnalyzerProcess(this))
        {
            // This process is dedicated to LeakCanary for heap analysis.You should not init your app in this process.
            return;
        }
        rw = LeakCanary.install(this);
    }

    private void initFreeline()
    {
        FreelineCore.init(this);
    }

    private void initRealm()
    {
        Realm.init(this);
        RealmLog.setLevel(LogLevel.TRACE);
    }

    private void initImageLoader(Context context)
    {
        // This configuration tuning is custom. You can tune every option, you may tune some of them,or you can create default configuration by ImageLoaderConfiguration.createDefault(this);
        // method.

        // MAX size of Image to save to memory,Screen Size;
        // default download thread 3

        // FOR CACHED IMAGE THREAD POOL
        final int CACHED_IMAGE_THREAD_POOL_SIZE = 1;
        final String CACHED_IMAGE_THREAD_POOL_NAME = "uil-cached";
        ThreadPoolExecutor cachedeExecutors = DefaultThreadFactory.createExecutor(CACHED_IMAGE_THREAD_POOL_SIZE, Thread.NORM_PRIORITY, QueueProcessingType.LIFO, CACHED_IMAGE_THREAD_POOL_NAME);
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context).threadPriority(Thread.NORM_PRIORITY - 2)// the number of threads for loading the image
                .denyCacheImageMultipleSizesInMemory()// 解码图像的大尺寸将在内存中缓存先前解码图像的小尺寸
                .taskExecutorForCachedImages(cachedeExecutors).diskCache(new DiscCache()).memoryCacheSize(8 * 1024 * 1024)// set up cache size,the unit is kb 4M, remove this setting to use default : 1/8 APP Available Memory
                .defaultDisplayImageOptions(DisplayImageOption.getDisplayImageOptions()).tasksProcessingOrder(QueueProcessingType.LIFO)// 设置加载显示图片队列进程
                // .writeDebugLogs() // Remove for release app
                .memoryCache(new WeakMemoryCache()).diskCacheSize(50 * 1024 * 1024).imageDownloader(new BaseImageDownloader(context, 5 * 1000, 30 * 1000)) // connectTimeout (5 s), readTimeout (30s)超时时间
                .diskCacheFileNameGenerator(new Md5FileNameGenerator()) // 将保存的时候的URI名称用MD5 加密
                .build();
        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config);
    }

    private void initCustomActivityOnCrash()
    {
        // Install CustomActivityOnCrash
        CustomActivityOnCrash.install(this);
        CustomActivityOnCrash.setShowErrorDetails(true);
        // CustomActivityOnCrash.setDefaultErrorActivityDrawable(int);// default is R.drawable.customactivityoncrash_error_image
        CustomActivityOnCrash.setEnableAppRestart(true);
    }

    private void initGreenDao()
    {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级
        mHelper = new DaoMaster.DevOpenHelper(this, "notes-db", null);
        db = mHelper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getDaoSession()
    {
        return mDaoSession;
    }

    public SQLiteDatabase getDb()
    {
        return db;
    }
}
