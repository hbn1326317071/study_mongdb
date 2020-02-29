package com.hbn.study.mongodblearning.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.util.Date;

/**
 * @Description TODO
 * @Author huangbaoning
 * @Date 2020/2/23 14:59
 */
@Data
public class DownloadData  {
    @ExcelProperty("字符串标题")
    private String string;
    @ExcelProperty("日期标题")
    private Date date;
    @ExcelProperty("数字标题")
    private Double doubleData;
}

