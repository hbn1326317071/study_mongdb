package com.hbn.study.mongodblearning.huawei;

import javax.servlet.Servlet;
import java.util.Arrays;

/**
 * @Description 华为面试题
 * @Author huangbaoning
 * @Date 2020/2/25 14:10
 */
public class InterviewTest {
    /**
     * 两个有序数组，nums1,nums2,   有序数组合并    nums2合并到nums1
     */
    public static void main(String[] args) {

        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 =new int []{2, 5, 6};
//        临时数组 存储有序的结果
        int[] nums3 = new int[nums1.length];
        int a=0;
        int b=0;
        for (int i = 0; i < nums3.length; i++) {
            //两数组都未遍历完，相互比较后加入  因为nums1最后3位是补位的，所以计算是要排除掉
            if (a < nums1.length-nums2.length && b < nums2.length) {
                if (nums1[a] > nums2[b]) {
//                    num[i]用来存储最后的结果值 存储比较得到的小的值
                    nums3[i] = nums2[b];
                    b++;
                } else {
                    nums3[i] = nums1[a];
                    a++;
                }
            } else if (a < nums1.length-nums2.length) {
                //nums2已经遍历完，直接将剩余nums1加入
                nums3[i] = nums1[a];
                a++;
            } else if (b < nums2.length) {
                //nums1已经遍历完，直接将剩余nums2加入
                nums3[i] = nums2[b];
                b++;
            }
        }

        nums1=nums3;
//        最后将执行结果 赋值给回nums1
        System.out.println(Arrays.toString(nums1));
    }

}


