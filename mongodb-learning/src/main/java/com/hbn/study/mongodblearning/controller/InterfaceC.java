package com.hbn.study.mongodblearning.controller;

import org.junit.Test;
import org.springframework.data.mongodb.core.mapping.TextScore;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

public class InterfaceC implements   InterfaceA,InterfaceB {
    @Override
    public void A() {

    }
     @Test
    public  void test() {
//        AtomicInteger
        try {
            TestThread t =new TestThread();
            new Thread(t).start();
            new ThreadDemo().start();
            CallableThreadTest callableThreadTest = new CallableThreadTest();
            FutureTask<Integer> futureTask = new FutureTask<>(callableThreadTest);
            Thread futureTaskThread = new Thread(futureTask);
            futureTaskThread.setName("有返回值的线程");
            futureTaskThread.start();
            System.out.println("future对象的返回值为多少#"+futureTask.get());
        } catch (Exception e) {
            System.out.println("exception");
        }
    }

    class  TestThread implements Runnable {
        @Override
        public void run() {
            System.out.println("ThreadName#"+Thread.currentThread().getName());
            System.out.println("aa");
        }
    }

    class ThreadDemo extends Thread{
        @Override
        public void run() {
            System.out.println("bbbb");
            System.out.println("ThreadName111#"+Thread.currentThread().getName());
            super.run();
        }
    }
    class CallableThreadTest implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println("future  对象执行了");
            return 1024;
        }
    }
}

