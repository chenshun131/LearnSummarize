package com.chenshun.learnsummarize;

import android.app.Application;

import com.chenshun.learnsummarize.constant.Constants;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.cookie.store.MemoryCookieStore;

/**
 * User: chenshun <p />
 * Time: 16/10/13 15:56  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class App extends Application
{
    private static App instance;

    @Override
    public void onCreate()
    {
        super.onCreate();
        instance = this;
        initNetwork();
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
        okGo.setReadTimeOut(OkGo.DEFAULT_MILLISECONDS);
        okGo.setWriteTimeOut(OkGo.DEFAULT_MILLISECONDS);
        okGo.setCacheMode(CacheMode.NO_CACHE);
        okGo.setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE);
        okGo.setCookieStore(new MemoryCookieStore());// cookie使用内存缓存（app退出后，cookie消失）

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

}
