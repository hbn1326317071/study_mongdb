package com.hbn.study.mongodblearning.interview;

/**
 * @ClassNmae getLongestSubstr
 * @Description TODO
 * @Author huangbaoning
 * @Date 2020/2/12 21:39
 * @Version 1.0
 */
public class getLongestSubstr {



    private static String longerStr = "";
    private static int maxLonger = 0;

    public static void getLonger(String target) {
        if(target == null || target.length() == 0) {
            return;
        }
        // 结束递归标识
        boolean out = false;
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<target.length();i++) {
            String chat = target.charAt(i) + "";
            if(!sb.toString().contains(chat)) {
                    sb.append(chat);
                //判断是否已经遍历完整个字符串
                if(i == target.length() -1) {
                    longerStr = sb.toString();
                    maxLonger = sb.length();
                    out = true;
                }
            } else {
                if(maxLonger < sb.length() ) {
                    longerStr = sb.toString();
                    maxLonger = sb.length();
                }
                // 每次递归去掉首字母
                target = target.substring(1);
                // 不可能获得更长的子字符串了
                if(maxLonger == target.length()) {
                    out = true;
                }
                break;
            }
        }
        if(!out) {
            getLonger(target);
        }
    }

    public static void main(String[] args) {
        getLonger("abcdekkkkkkkkqwertyuiopkjg");
        System.out.println(longerStr);
    }

}
