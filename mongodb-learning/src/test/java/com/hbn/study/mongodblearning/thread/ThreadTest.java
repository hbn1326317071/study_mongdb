package com.hbn.study.mongodblearning.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description TODO
 * @Author huangbaoning
 * @Date 2020/2/24 21:31
 */
public class ThreadTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
    }
}
