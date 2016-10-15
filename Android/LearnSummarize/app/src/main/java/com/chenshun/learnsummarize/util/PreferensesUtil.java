package com.chenshun.learnsummarize.util;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;

import com.chenshun.learnsummarize.App;
import com.chenshun.learnsummarize.constant.SPConst;

import java.util.Map;
import java.util.Set;

/**
 * User: chenshun <p />
 * Time: 16/10/14 08:46  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class PreferensesUtil
{
    public static final int DEFAULT_SHAREDPERENCES_MODE = SPConst.DEFAULT_SHAREDPERENCES_MODE;
    private static final String DEF_STRING_VALUE = "";
    public static final boolean DEF_BOOLEAN_VALUE = true;
    protected SharedPreferences preferenses;

    /**
     * Retrieve a boolean value from the preferences,default false
     *
     * @param key
     * @return
     */
    public boolean getBoolean(String key)
    {
        return getBoolean(key, false);
    }

    /**
     * Retrieve a boolean value from the preferences
     *
     * @param key
     * @param defValue
     * @return
     */
    public boolean getBoolean(String key, boolean defValue)
    {
        return null != preferenses ? preferenses.getBoolean(key, defValue) : false;
    }

    /**
     * Retrieve a String value from the preferences,default ""
     *
     * @param key
     * @return
     */
    public String getString(String key)
    {
        return null != preferenses ? preferenses.getString(key, DEF_STRING_VALUE) : DEF_STRING_VALUE;
    }

    /**
     * Retrieve a String value from the preferences
     *
     * @param key
     * @return
     */
    public String getString(String key, String defValue)
    {
        return null != preferenses ? preferenses.getString(key, defValue) : DEF_STRING_VALUE;
    }

    /**
     * Retrieve an int value from the preferences,default 0
     *
     * @param key
     * @return
     */
    public int getInt(String key)
    {
        return null != preferenses ? preferenses.getInt(key, 0) : 0;
    }

    /**
     * Retrieve an int value from the preferences
     *
     * @param key
     * @return
     */
    public int getInt(String key, int defValue)
    {
        return null != preferenses ? preferenses.getInt(key, defValue) : 0;
    }

    /**
     * Retrieve a long value from the preferences,default 0
     *
     * @param key
     * @return
     */
    public long getLong(String key)
    {
        return null != preferenses ? preferenses.getLong(key, 0) : 0;
    }

    /**
     * Retrieve a long value from the preferences
     *
     * @param key
     * @return
     */
    public long getLong(String key, long defValue)
    {
        return null != preferenses ? preferenses.getLong(key, defValue) : 0;
    }

    /**
     * create new PreferensesUtil instance,the Operating mode Context.MODE_PRIVATE
     *
     * @param context
     * @param table
     *         SharedPreferences name
     */
    public PreferensesUtil(Context context, String table)
    {
        if (null == context)
        {
            context = App.getInstance().getApplicationContext();
        }
        preferenses = context.getSharedPreferences(table, DEFAULT_SHAREDPERENCES_MODE);
    }

    /**
     * create new PreferensesUtil instance
     *
     * @param context
     * @param table
     *         SharedPreferences name
     * @param mode
     *         open the SharedPreferences
     */
    public PreferensesUtil(Context context, String table, int mode)
    {
        if (null == context)
        {
            throw new NullPointerException("context is null!");
        }
        preferenses = context.getSharedPreferences(table, mode);
    }

    /**
     * write ContentValues data in SharedPreferences
     *
     * @param values
     * @return
     */
    public boolean write(ContentValues values)
    {
        if (null == preferenses)
        {
            return false;
        }
        SharedPreferences.Editor editor = preferenses.edit();
        if (null == editor)
        {
            return false;
        }
        Set<Map.Entry<String, Object>> entries = values.valueSet();
        for (Map.Entry<String, Object> entry : entries)
        {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String)
            {
                editor.putString(key, String.valueOf(value));
            }
            else if (value instanceof Integer || value instanceof Short || value instanceof Byte)
            {
                editor.putInt(key, (Integer) value);
            }
            else if (value instanceof Long)
            {
                editor.putLong(key, (Long) value);
            }
            else if (value instanceof Float || value instanceof Double)
            {
                editor.putFloat(key, (Float) value);
            }
            else if (value instanceof Boolean)
            {
                editor.putBoolean(key, (Boolean) value);
            }
        }
        return editor.commit();
    }

    /**
     * Retrieve all values from the preferences
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public ContentValues read()
    {
        if (null == preferenses)
        {
            return null;
        }
        Map map = preferenses.getAll();
        if (null == map)
        {
            return null;
        }
        ContentValues values = new ContentValues();
        Set<Map.Entry<String, ?>> entries = map.entrySet();
        for (Map.Entry<String, ?> entry : entries)
        {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String)
            {
                values.put(key, String.valueOf(value));
            }
            else if (value instanceof Integer || value instanceof Short || value instanceof Byte)
            {
                values.put(key, (Integer) value);
            }
            else if (value instanceof Long)
            {
                values.put(key, (Long) value);
            }
            else if (value instanceof Float || value instanceof Double)
            {
                values.put(key, (Float) value);
            }
            else if (value instanceof Boolean)
            {
                values.put(key, (Boolean) value);
            }
        }
        return values;
    }

    /**
     * save String data(key-value)
     *
     * @param key
     * @param value
     */
    public void saveString(String key, String value)
    {
        SharedPreferences.Editor editor = preferenses.edit();
        if (null != editor)
        {
            editor.putString(key, value).commit();
        }
    }

    /**
     * save Boolean data(key-value)
     *
     * @param key
     * @param value
     */
    public void saveBoolean(String key, boolean value)
    {
        SharedPreferences.Editor editor = preferenses.edit();
        if (null != editor)
        {
            editor.putBoolean(key, value).commit();
        }
    }

    /**
     * save Int data(key-value)
     *
     * @param key
     * @param value
     */
    public void saveInt(String key, int value)
    {
        SharedPreferences.Editor editor = preferenses.edit();
        if (null != editor)
        {
            editor.putInt(key, value).commit();
        }
    }

    /**
     * save Long data(key-value)
     *
     * @param key
     * @param value
     */
    public void saveLong(String key, long value)
    {
        SharedPreferences.Editor editor = preferenses.edit();
        if (null != editor)
        {
            editor.putLong(key, value).commit();
        }
    }

    /**
     * determine whether contain the key valueF
     *
     * @param key
     * @return
     */
    public boolean containsKey(String key)
    {
        if ((null != preferenses) && preferenses.contains(key))
        {
            return true;
        }
        return false;
    }

    /**
     * delete SharedPreferences data by key
     *
     * @param key
     */
    public void deleteKey(String key)
    {
        SharedPreferences.Editor editor = preferenses.edit();
        if (null != editor)
        {
            editor.remove(key).commit();
        }
    }

    /**
     * delete All data,if success,return true,otherwise return false
     */
    public boolean clean()
    {
        return preferenses.edit().clear().commit();
    }
}
