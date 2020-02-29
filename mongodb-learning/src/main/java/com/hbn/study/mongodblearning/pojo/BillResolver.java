package com.hbn.study.mongodblearning.pojo;

import com.alibaba.fastjson.JSONObject;

/**
 * @Description TODO
 * @Author huangbaoning
 * @Date 2020/2/29 10:27
 */
public interface BillResolver {
    BillDocument resolveBill(JSONObject jsonObject);
}
