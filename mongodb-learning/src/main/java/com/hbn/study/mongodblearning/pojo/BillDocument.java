package com.hbn.study.mongodblearning.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author huangbaoning
 * @Date 2020/2/29 10:05
 */
@Data
public class BillDocument implements Serializable {

    private String id;
    private String name;
    private String billType;
}
