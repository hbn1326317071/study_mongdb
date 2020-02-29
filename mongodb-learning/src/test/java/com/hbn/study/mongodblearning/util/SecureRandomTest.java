package com.hbn.study.mongodblearning.util;

import java.security.SecureRandom;

/**
 * @ClassNmae SecureRandomTest
 * @Description TODO
 * @Author huangbaoning
 * @Date 2020/2/22 21:12
 * @Version 1.0
 */
public class SecureRandomTest {
    public static void main(String[] args) throws Exception {
        SecureRandom random1 = SecureRandom.getInstance("SHA1PRNG");
        SecureRandom random2 = SecureRandom.getInstance("SHA1PRNG");
        for (int i = 0; i < 5; i++) {
            System.out.println(random1.nextInt() + " != " + random2.nextInt());
        }
    }

}
