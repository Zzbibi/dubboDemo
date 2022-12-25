package com.zz.schedule;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author zhangzhen
 * @create 2022/12/17 16:43
 */
public class MyThreadFactory implements ThreadFactory {

    // 记录线程工厂的序号
    protected static final AtomicInteger M_POOL_SEQ = new AtomicInteger(1);
    // 记录每个线程工厂创建的线程序号
    protected final AtomicInteger mThreadNum = new AtomicInteger(1);

    protected final String mPrefix;
    protected final boolean mDaemon;
    protected final ThreadGroup mThreadGroup;

    public MyThreadFactory() {
        this("pool-" + M_POOL_SEQ.getAndIncrement(), false);
    }

    public MyThreadFactory(String prefix) {
        this(prefix, false);
    }

    public MyThreadFactory(String prefix, boolean daemon) {
        mPrefix = prefix + "-thread-";
        mDaemon = daemon;
        SecurityManager securityManager = System.getSecurityManager();
        mThreadGroup = (null == securityManager) ?
                Thread.currentThread().getThreadGroup() : securityManager.getThreadGroup();
    }

    @Override
    public Thread newThread(Runnable r) {
        String threadName = mPrefix + mThreadNum.getAndIncrement();
        Thread thread = new Thread(mThreadGroup, r, threadName, 0);
        thread.setDaemon(mDaemon);
        return thread;
    }

    public ThreadGroup getMThreadGroup() {
        return mThreadGroup;
    }

}
