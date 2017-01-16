package com.chenshun.learnsummarize.io;

import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.assist.deque.LIFOLinkedBlockingDeque;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: chenshun <p />
 * Time: 16/11/17 15:12  <p />
 * Version: V1.0  <p />
 * Description: create ThreadPool for fileLoader and ImageLoader cached image;You can set the ThreadPool name and ProcessType (FIFO or LIFO)  <p />
 */
public class DefaultThreadFactory implements ThreadFactory
{
    private final AtomicInteger poolNumber = new AtomicInteger(1);
    private final ThreadGroup group;
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final String namePrefix;
    /** the priority of the Thread */
    private final int threadPriority;

    /**
     * @param threadPoolPrefixName
     *         the prefix of thread name
     * @param threadPriority
     *         the priority of the Thread
     */
    public DefaultThreadFactory(String threadPoolPrefixName, int threadPriority)
    {
        this.threadPriority = threadPriority;
        SecurityManager s = System.getSecurityManager();
        group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
        namePrefix = threadPoolPrefixName + "-pool-" + poolNumber.getAndIncrement() + "-thread-";
    }

    @Override
    public Thread newThread(Runnable r)
    {
        Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
        if (t.isDaemon())
        {
            t.setDaemon(false);
        }
        t.setPriority(threadPriority);
        return t;
    }

    /**
     * Creates a new ThreadPoolExecutor with the given initial parameters and default rejected execution handler
     *
     * @param threadPoolSize
     *         the number of threads to keep in the pool, even if they are idle, unless allowCoreThreadTimeOut is set,and it also as the maximum number of threads to allow in the pool
     * @param threadPriority
     *         the priority of the Thread
     * @param tasksProcessingType
     *         the factory to use when the executor creates a new thread
     * @param threadPoolPrefixName
     *         the queue to use for holding tasks before they are executed. This queue will hold only the Runnable tasks submitted by the execute method.
     * @return
     */
    public static ThreadPoolExecutor createExecutor(int threadPoolSize, int threadPriority, QueueProcessingType tasksProcessingType, String threadPoolPrefixName)
    {
        boolean lifo = tasksProcessingType == QueueProcessingType.LIFO;
        BlockingQueue<Runnable> taskQueue = lifo ? new LIFOLinkedBlockingDeque<Runnable>() : new LinkedBlockingQueue<Runnable>();
        return new ThreadPoolExecutor(threadPoolSize, threadPoolSize, 0L, TimeUnit.MILLISECONDS, taskQueue, new DefaultThreadFactory(threadPoolPrefixName, threadPriority));
    }
}
