package com.hbn.study.mongodblearning.interview;

/**
 * @ClassNmae DemoNumberLimit
 * @Description TODO
 * @Author huangbaoning
 * @Date 2020/2/18 21:26
 * @Version 1.0
 */
public class DemoNumberLimit {
    public static void main(String args[]){
        Object obj = new Object();
        Thread threadOne = new Thread(){
            public void run(){
                for (int i=0;i<50;i++){
                    System.out.println(Thread.currentThread().getName()+":"+i);
                    try{
                        Thread.sleep(500);
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
                //华丽的分割线
                for(int i=0;i<50;i++)
                    System.out.print("=");
                System.out.println();       //换行
                //同步
                synchronized(obj){
                    obj.notify();
                }
                System.out.println("第一个线程接着执行");
                for(int i = 51;i<101;i++){
                    System.out.println(Thread.currentThread().getName()+":"+i);
                    try{
                        Thread.sleep(500);
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.println("线程1执行完成");
            }
        };
        //线程2
        Thread threadTwo = new Thread(){
            public void run(){
                synchronized(obj){
                    try{
                        obj.wait();
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("线程2:");
                    System.out.println("线程1的上半部分执行完成,开始执行下半部分");
                }
            }
        };
        threadOne.start();
        threadTwo.start();
        threadOne.setName("One");
        threadTwo.setName("Two");
    }
}
