package com.hbn.study.mongodblearning.util;
/**
 * @Description 单据类型类
 * @Author huangbaoning
 * @Date 2020/2/29
 */
public enum BillTypeEnum {
    B_0301("0301","报销单A"),
    B_0401("0401","报销单B");
    private String billTypeId;
    private  String billTypeName;

    BillTypeEnum(String billTypeId, String billTypeName) {
        this.billTypeId = billTypeId;
        this.billTypeName = billTypeName;
    }

    public String getBillTypeId() {
        return billTypeId;
    }

    public String getBillTypeName() {
        return billTypeName;
    }

    public String  getNameById(String billTypeId) {
        BillTypeEnum[] values = BillTypeEnum.values();
        for (BillTypeEnum val : values) {
            if (val.getBillTypeId().equals(billTypeId)) {
                return val.getBillTypeName();
            }
        }
        return null;

    }

}
