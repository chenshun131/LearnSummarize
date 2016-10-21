/**
 * Copyright (c) 2015-2016, Chill Zhuang 庄骞 (smallchill@163.com).
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
package com.smallchill.core.config;


import com.smallchill.core.interfaces.IConfig;
import org.beetl.sql.core.SQLManager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhuangqian
 * @title blade配置
 * @email smallchill@163.com
 * @date 2016-1-26上午9:40:18
 * @copyright 2016
 */
public class BladeConfig
{
    private static Map<String, SQLManager> pool = new ConcurrentHashMap<String, SQLManager>();

    private BladeConfig()
    {
    }

    private static IConfig conf = null;

    public static IConfig getConf()
    {
        if (null == conf)
        {
            throw new RuntimeException("BladeConfig未注入,请在applicationContext.xml中定义bladeConfig!");
        }
        return conf;
    }

    public static Map<String, SQLManager> getPool()
    {
        if (null == pool)
        {
            throw new RuntimeException("sqlManagerMap未注入,请在applicationContext.xml中定义sqlManagerMap!");
        }
        return pool;
    }

    /**
     * 注入自定义config
     *
     * @param config
     */
    public void setConf(IConfig config)
    {
        conf = config;
    }

    /**
     * 注入sqlManagerMap
     *
     * @param map
     */
    public void setSqlManager(Map<String, SQLManager> map)
    {
        pool.putAll(map);
    }
}
