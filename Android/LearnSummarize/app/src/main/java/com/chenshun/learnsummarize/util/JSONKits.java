package com.chenshun.learnsummarize.util;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * User: chenshun <p />
 * Time: 16/10/23 00:19 <p />
 * Version V1.0  <p />
 * Description: 使用fastjson解析JSON <p />
 */
public class JSONKits
{
    public static String toJson(Object object)
    {
        return JSONObject.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
    }

    public static JSONObject parse(String text)
    {
        return JSONObject.parseObject(text);
    }

    public static <T> T parse(String text, Class<T> clazz)
    {
        return JSONObject.parseObject(text, clazz);
    }
}
