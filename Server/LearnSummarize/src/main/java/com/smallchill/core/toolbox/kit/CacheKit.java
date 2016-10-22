/**
 * Copyright (c) 2011-2016, James Zhan 詹波 (jfinal@126.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.smallchill.core.toolbox.kit;

import com.smallchill.core.interfaces.ILoader;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * CacheKit. Useful tool box for EhCache.
 */
public class CacheKit
{
    private static CacheManager cacheManager;
    private static volatile Object locker = new Object();
    private static final Logger log = LogManager.getLogger(CacheKit.class);

    private static CacheManager getManager()
    {
        if (cacheManager == null)
        {
            synchronized (CacheKit.class)
            {
                if (cacheManager == null)
                {
                    cacheManager = CacheManager.create();
                }
            }
        }
        return cacheManager;
    }

    static Cache getOrAddCache(String cacheName)
    {
        CacheManager cacheManager = getManager();
        Cache cache = cacheManager.getCache(cacheName);
        if (cache == null)
        {
            synchronized (locker)
            {
                cache = cacheManager.getCache(cacheName);
                if (cache == null)
                {
                    log.warn("Could not find cache config [" + cacheName + "], using default.");
                    cacheManager.addCacheIfAbsent(cacheName);
                    cache = cacheManager.getCache(cacheName);
                    log.debug("Cache [" + cacheName + "] started.");
                }
            }
        }
        return cache;
    }

    public static void put(String cacheName, Object key, Object value)
    {
        getOrAddCache(cacheName).put(new Element(key, value));
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(String cacheName, Object key)
    {
        Element element = getOrAddCache(cacheName).get(key);
        return element != null ? (T) element.getObjectValue() : null;
    }

    @SuppressWarnings("rawtypes")
    public static List getKeys(String cacheName)
    {
        return getOrAddCache(cacheName).getKeys();
    }

    public static void remove(String cacheName, Object key)
    {
        getOrAddCache(cacheName).remove(key);
    }

    public static void removeAll(String cacheName)
    {
        getOrAddCache(cacheName).removeAll();
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(String cacheName, Object key, ILoader iLoader)
    {
        Object data = get(cacheName, key);
        if (data == null)
        {
            data = iLoader.load();
            put(cacheName, key, data);
        }
        return (T) data;
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(String cacheName, Object key, Class<? extends ILoader> iLoaderClass)
    {
        Object data = get(cacheName, key);
        if (data == null)
        {
            try
            {
                ILoader dataLoader = iLoaderClass.newInstance();
                data = dataLoader.load();
                put(cacheName, key, data);
            }
            catch (Exception e)
            {
                throw new RuntimeException(e);
            }
        }
        return (T) data;
    }
}


