package com.hbn.study.mongodblearning.interview;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassNmae ByteDanceInterview
 * @Description TODO
 * @Author huangbaoning
 * @Date 2020/2/16 14:45
 * @Version 1.0
 */
public class ByteDanceInterview {
    public  static  int count = 900;
    public static synchronized  void inc() {
        // 这里延迟1毫秒，使得结果明显
//        try {
////            Thread.sleep(1);
//        } catch (InterruptedException e) {
//        }

        count++;
    }
    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
        System.out.println();
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j=0;j<10000;j++)
                    ByteDanceInterview.inc();
                }
            }).start();
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 这里每次运行的值都有可能不同,可能为100
        System.out.println("Counter.count=" + ByteDanceInterview.count);
        long time2 = System.currentTimeMillis();
        System.out.println("耗时："+(time2-time1));
    }


}
