package com.hbn.study.mongodblearning.interview;

import org.springframework.data.mongodb.core.aggregation.ConditionalOperators;
import org.springframework.data.mongodb.util.BsonUtils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description TODO
 * @Author huangbaoning
 * @Date 2020/2/26 21:50
 */
public class PrintABC {
    private static volatile int state = 0;


    public static void main(String[] args) throws Exception {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition conditionA = reentrantLock.newCondition();
        Condition conditionB = reentrantLock.newCondition();
        Condition conditionC = reentrantLock.newCondition();
        new Thread(new TheadPrint(conditionA, conditionB, "A", reentrantLock, 0)).start();
        Thread.sleep(1000);
        new Thread(new TheadPrint(conditionB, conditionC, "B", reentrantLock, 1)).start();
      Thread.sleep(1000);
        new Thread(new TheadPrint(conditionC, conditionA, "C", reentrantLock, 2)).start();

    }

    public static class TheadPrint implements Runnable {
        private Condition current;
        private Condition nextCondition;
        private String printChar;
        private ReentrantLock reentrantLock;
        private int currentState;

        public TheadPrint(Condition current, Condition nextCondition,
                          String printChar, ReentrantLock reentrantLock, int currentState) {
            this.current = current;
            this.nextCondition = nextCondition;
            this.printChar = printChar;
            this.reentrantLock = reentrantLock;
            this.currentState = currentState;
        }

        @Override
        public void run() {
            System.out.println("当前线程" +currentState);
            for (int i = 0; i < 10; ) {
                try {
                    reentrantLock.lock();
//                    先打印A，
                    while (state % 3 != currentState) {
                        System.out.println(currentState+"在等待");
//                  阻塞当前线程
                        current.await();
                    }
                    state++;
                    i++;
                    System.out.println(printChar);
//                唤醒下一个线程
                    nextCondition.signal();

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();

                }


            }
        }
    }

}

