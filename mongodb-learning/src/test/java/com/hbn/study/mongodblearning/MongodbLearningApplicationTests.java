package com.hbn.study.mongodblearning;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sun.applet.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MongodbLearningApplicationTests {

    private  int[] boxx = new int[1024];

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
        List<MongodbLearningApplicationTests> list = new ArrayList<>();
        HashMap hashMap = new HashMap();
        hashMap.put("ab", "afs");
        for (int i = 0; i < 1000;
             i++) {
            list.add(new MongodbLearningApplicationTests());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("抛出异常了");
            }

        }

    }

}
