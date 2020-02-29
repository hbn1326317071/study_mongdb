package com.hbn.study.mongodblearning.interview;

/**
 * @ClassNmae CyclePrintAli
 * @Description TODO
 * @Author huangbaoning
 * @Date 2020/2/18 21:39
 * @Version 1.0
 */
public class CyclePrintAli {
    //        循环打印ali
    private static CyclePrintAli cyclePrintAli = new CyclePrintAli();
    private volatile static  int flag=1;
    public static void main(String[] args) {
        System.out.println("start");
        Thread thread = new Thread(new ThreadA());
        Thread threadB = new Thread(new ThreadB());
        thread.start();
        threadB.start();
        System.out.println("end");

    }

    static class ThreadA implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                synchronized (cyclePrintAli) {
                    while (flag != 1) {
                        try {
                            cyclePrintAli.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("数字A" + i);
                    flag = 2;
                    cyclePrintAli.notifyAll();



                }
            }


        }
    }

   static   class ThreadB implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                synchronized (cyclePrintAli) {
                    while (flag != 2) {
                        try {

                            cyclePrintAli.wait();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("B数字" + i);
                    flag=1;
                    cyclePrintAli.notifyAll();


                }
            }


        }
    }



}
