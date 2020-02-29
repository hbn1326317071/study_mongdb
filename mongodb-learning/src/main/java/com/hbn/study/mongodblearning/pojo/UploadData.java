package com.hbn.study.mongodblearning.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @Description TODO
 * @Author huangbaoning
 * @Date 2020/2/23 15:01
 */
@Data
public class UploadData {
    private String string;
    private Date date;
    private Double doubleData;
}