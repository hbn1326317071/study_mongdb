package com.hbn.study.mongodblearning.util;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ImmutableMap;
import com.hbn.study.mongodblearning.pojo.BillDocument;
import io.netty.handler.codec.json.JsonObjectDecoder;
import org.apache.poi.ss.formula.functions.T;

import java.util.Map;

/**
 * @Description TODO
 * @Author huangbaoning
 * @Date 2020/2/29 10:09
 */
public class ClassUtil {
    public static Map<String, Class> map = new ImmutableMap.Builder<String, Class>()
            .put(BillTypeEnum.B_0301.getBillTypeId(), BillDocument.class)
            .put(BillTypeEnum.B_0401.getBillTypeId(), BillDocument.class)
            .build();

    public static void main(String[] args) {
        String billType = "0401";
        Class clazz = map.get(billType);
        JSONObject jsonObject = new JSONObject();
        Object resolve = Resolver.resolve(billType, jsonObject, clazz);
        System.out.println(JSONObject.toJSONString(resolve));

    }
}
