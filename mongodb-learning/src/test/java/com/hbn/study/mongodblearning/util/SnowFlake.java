package com.hbn.study.mongodblearning.util;

/**
 * @ClassNmae SnowFlake
 * @Description TODO
 * @Author huangbaoning
 * @Date 2020/2/22 20:24
 * @Version 1.0
 * 第一个部分，是 1 个 bit：0，这个是无意义的。
 *
 * 第二个部分是 41 个 bit：表示的是时间戳。
 *
 * 第三个部分是 5 个 bit：表示的是机房 id，10001。
 *
 * 第四个部分是 5 个 bit：表示的是机器 id，1 1001。
 *
 * 第五个部分是 12 个 bit：表示的序号，就是某个机房某台机器上这一毫秒内同时生成的 id 的序号，0000 00000000。
 *
 *
 */
public class SnowFlake {
}
