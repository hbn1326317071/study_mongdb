package com.hbn.study.mongodblearning.service;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;
import sun.misc.Unsafe;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadTest {

    
    public static volatile  ThreadTest  instance1;
    public static void main(String[] args) {

        final CountDownLatch latch = new CountDownLatch(2);
        new Thread() {
            public void run() {
                try {
                    System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            ;
        }.start();

        new Thread() {
            public void run() {
                try {
                    System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            ;
        }.start();

        try {
            System.out.println("等待2个子线程执行完毕...");
            latch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    单例模式 双重锁


        private volatile static ThreadTest instance;

    public static ThreadTest getThreadTest() {
        if(instance==null){
            synchronized (ThreadTest.class) {
                if (instance == null) {
                    System.out.println("执行了new方法");
                    instance = new ThreadTest();
                }
            }

        }
        return instance;
    }
    //静态内部类的方式
    static class A {
        static ThreadTest test = new ThreadTest();
    }

    public static ThreadTest  getInsance2() {
        System.out.println("执行B");
        return A.test;
    }

    @Test
    public void test2() {

            ThreadTest test=ThreadTest.getThreadTest();
            ThreadTest test1=ThreadTest.getThreadTest();
            System.out.println(test==test1);
        ThreadTest test3 = A.test;
        ThreadTest test4 = A.test;
        System.out.println(test3 == test4);


    }
@Test
    public void test3() {

ClassLoader loader = BigDecimal.class.getClassLoader();

System.out.println(loader.toString());

System.out.println(loader.getParent().toString());

System.out.println(loader.getParent().getParent());

    }
@Test
    public void test4() {
      Map<Integer,String> map=  new ImmutableMap.Builder<Integer, String>().
                put(30, "IP地址或地址段").
                put(31, "端口号或范围").
                put(32, "IP地址或地址段").
                put(33, "端口号或范围").
                put(34, "代码值").
                put(38, "探针名称").
                put(39, "网络协议号(protocol)").
                put(40, "ipv6源IP(ipv6_src_addr)").
                put(41, "ipv6目标IP(ipv6_dst_addr)").
                put(42, "网络协议名称(protocol_map)").
                put(43, "输入接口snmp(input_snmp)")
                .build();

    }




}




