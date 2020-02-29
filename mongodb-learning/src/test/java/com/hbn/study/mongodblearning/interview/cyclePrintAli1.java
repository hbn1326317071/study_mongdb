package com.hbn.study.mongodblearning.interview;

/**
 * @ClassNmae cyclePrintAli1
 * @Description TODO
 * @Author huangbaoning
 * @Date 2020/2/18 22:07
 * @Version 1.0
 */
public class cyclePrintAli1 {

    public static void main(String[] args) throws Exception {
//        锁对象a
        Object a = new Object();
//        锁对象l
        Object l = new Object();
//        锁对象i
        Object i = new Object();
        ThreadA pa = new ThreadA("a", i, a);
        ThreadA pb = new ThreadA("l", a, l);
        ThreadA pc = new ThreadA("i", l, i);

        new Thread(pa).start();
        // 保证初始ali的启动顺序
        Thread.sleep(20);
        new Thread(pb).start();
        Thread.sleep(20);
        new Thread(pc).start();
        Thread.sleep(20);
    }


   public  static   class ThreadA implements  Runnable{
       private String name;
       private Object prev;
       private Object self;

       public ThreadA(String name, Object prev, Object self) {
           this.name = name;
           this.prev = prev;
           this.self = self;
       }

       @Override
       public void run() {

           int count=20;
           while (count > 0) {
//               对前一个对象进行加锁
               synchronized (prev) {

                   synchronized (self) {
                       System.out.println(name + "#" );
                        count--;
                   }
                   self.notifyAll();
//                   如果是最后一次的话，需要都通知一下
                   if (count == 0) {
                       prev.notifyAll();
                   }else{
                       try {
                           prev.wait();
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }




               }

           }



       }

   }





}
