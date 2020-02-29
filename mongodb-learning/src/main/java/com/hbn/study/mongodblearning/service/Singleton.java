package com.hbn.study.mongodblearning.service;

/**
 * @ClassNmae Singleton
 * @Description TODO
 * @Author huangbaoning
 * @Date 2020/2/8 10:50
 * @Version 1.0
 */
public enum Singleton {
    ThreadTest;

    private final ThreadTest instance;

    Singleton() {
        instance = new ThreadTest();
    }

    private ThreadTest getInstance() {
        return instance;
    }
}

