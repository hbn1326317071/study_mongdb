package com.hbn.study.mongodblearning.interview;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassNmae CyclePrint
 * @Description TODO
 * @Author huangbaoning
 * @Date 2020/2/18 21:28
 * @Version 1.0
 */
public class CyclePrint  {
    private  volatile  int status = 1;

    static class ThreadOne implements Runnable{
        private CyclePrint threadTest;
        public ThreadOne(CyclePrint threadTest) {
            this.threadTest = threadTest;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
            }
        }
    }
    static class ThreadTwo implements Runnable{
        private CyclePrint threadTest;
        public ThreadTwo(CyclePrint threadTest) {
            this.threadTest = threadTest;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                threadTest.printB();
            }
        }
    }

    public void printA(){
        synchronized (this) {
            while (status != 1) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("A");
            status = 2;
            this.notifyAll();
        }
    }
    public void printB(){
        synchronized (this) {
            while (status != 2) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("B");
            status = 1;
            this.notifyAll();
        }
    }



}
