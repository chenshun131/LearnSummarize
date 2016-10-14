package com.chenshun.learnsummarize.util;

/**
 * User: chenshun <p />
 * Time: 16/10/14 08:05  <p />
 * Version: V1.0  <p />
 * Description: Singleton helper class for lazily initialization. <p />
 */
public abstract class Singleton<T>
{
    private T mInstance;

    protected abstract T create();

    public final T get()
    {
        synchronized (this)
        {
            if (mInstance == null)
            {
                mInstance = create();
            }
            return mInstance;
        }
    }
}

