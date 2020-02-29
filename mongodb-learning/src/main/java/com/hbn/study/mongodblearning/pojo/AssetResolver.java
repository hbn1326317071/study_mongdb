package com.hbn.study.mongodblearning.pojo;

import com.alibaba.fastjson.JSONObject;

/**
 * @Description TODO
 * @Author huangbaoning
 * @Date 2020/2/29 10:34
 */
public class AssetResolver extends ResolverBase {
    @Override
    public BillDocument resolveBill(JSONObject jsonObject) {
        BillDocument billDocument = new BillDocument();
        billDocument.setId(jsonObject.getString("id"));
        return billDocument;
    }
}
