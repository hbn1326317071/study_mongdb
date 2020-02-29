package com.hbn.study.mongodblearning.util;

import com.alibaba.fastjson.JSONObject;
import com.hbn.study.mongodblearning.pojo.AssetResolver;
import org.apache.poi.ss.formula.functions.T;

/**
 * @Description 用于解析的入口
 * @Author huangbaoning
 * @Date 2020/2/29 10:22
 */
public class Resolver {
    public Resolver() {
    }

    public static <T> T resolve(String billType, JSONObject jsonObject,Class<T> t) {

        try {
            T object = t.newInstance();
            return adapt(object,billType, jsonObject);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;


    }

    private static <T> T adapt(T t, String billType, JSONObject jsonObject) {
        if (BillTypeEnum.B_0301.getBillTypeId().equals(billType)) {
            return new AssetResolver().resolve(jsonObject,t);
        }
        return null;

    }
}
