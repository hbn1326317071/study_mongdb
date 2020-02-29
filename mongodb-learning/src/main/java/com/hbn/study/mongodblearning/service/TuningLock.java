package com.hbn.study.mongodblearning.service;

import sun.misc.Unsafe;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.LockSupport;

public class TuningLock {
    private volatile  int state=0;
    private Thread lockHolder;
    private  static  final  long stateOffset;
    private static final Unsafe unsafe = Unsafe.getUnsafe();
//    线程安全，不是基于aqs进行实现，我们这里要做的就是来实现aqs的操作
    private ConcurrentLinkedQueue<Thread> waiters=new ConcurrentLinkedQueue();

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Thread getLockHolder() {
        return lockHolder;
    }

    public void setLockHolder(Thread lockHolder) {
        this.lockHolder = lockHolder;
    }
    /**
     * 原子操作
     */

    public final boolean compareAndSwapState(int expect, int update) {
        return unsafe.compareAndSwapInt(this, stateOffset,expect, update);
    }
    static {
        try {
            stateOffset = unsafe.objectFieldOffset(LockService.class.getDeclaredField("state"));
        } catch (NoSuchFieldException e) {
            throw new Error();
        }

    }

    public void lock() {
        if (aquire()) {
            return;
        }
        //cas比较与交换 --原子算法
        Thread current = Thread.currentThread();
        waiters.add(current);
        for (; ; ) {
//            只有头部的才需要进行抢锁
            if (current==waiters.peek()&&aquire()) {
//               拿到锁后，将队列中的数据进行移除
                waiters.poll();
                break;
            }
            LockSupport.park(current);

        }
    }

    public boolean aquire() {
        Thread currentThread = Thread.currentThread();
        int c = getState();
        if (c == 0) {//同步器还没有被持有
            if ((waiters.size()==0||currentThread==waiters.peek())&&compareAndSwapState(0, 1)) {
                setLockHolder(currentThread);
                return true;
            }
        }
        return false;
    }
    public void unlock() {
        if (Thread.currentThread() != lockHolder) {
            throw new RuntimeException("lockholder is not current thread");
        }
        int state = getState();
        if (compareAndSwapState(1, 0)) {
            setLockHolder(null);
            Thread first = waiters.peek();
            if (first != null) {
                LockSupport.unpark(first);
            }
        }
    }
}
