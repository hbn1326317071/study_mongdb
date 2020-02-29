package com.hbn.study.mongodblearning.pojo;

import com.alibaba.fastjson.JSONObject;

/**
 * @Description TODO
 * @Author huangbaoning
 * @Date 2020/2/29 10:29
 */
public abstract class ResolverBase implements BillResolver {

    public  <T> T resolve(JSONObject jsonObject, T t) {
        if (t instanceof BillDocument) {
            return (T)this.resolveBill(jsonObject);
        }
        return null;
    }
    /**
     * @Description //TODO  解析单据
     * @Author 
     * @Date 2020/2/29  
      * @param jsonObject
     * @Return {@link BillDocument}
     */
    @Override
   public  abstract   BillDocument resolveBill(JSONObject jsonObject);

}
