package com.hbn.study.mongodblearning.excel;

import com.alibaba.excel.support.ExcelTypeEnum;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author huangbaoning
 * @Date 2020/2/23 12:14
 */
public class EasyExcelTest {
    public static void main(String[] args) throws Exception {
        writeExcel();
        readExcel();
    }

    /**
     * 写入Excel
     *
     * @throws FileNotFoundException
     * @author Lynch
     */
    private static void writeExcel() throws FileNotFoundException {
        List<ExcelModel> excelModelList = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            ExcelModel excelModel = new ExcelModel();
            excelModel.setAddress("address" + i);
            excelModel.setAge(i + "");
            excelModel.setEmail("email" + i);
            excelModel.setHeigh("heigh" + i);
            excelModel.setLast("last" + i);
            excelModel.setName("name" + i);
            excelModel.setSax("sax" + i);
            excelModelList.add(excelModel);
        }

        long beginTime = System.currentTimeMillis();
        OutputStream out = new FileOutputStream("D:/aaa.xlsx");
        EasyExcelUtil.writeExcelWithModel(out, excelModelList, ExcelModel.class, ExcelTypeEnum.XLSX);
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("总共耗时 %s 毫秒", (endTime - beginTime)));

        excelModelList = null;
    }

    /**
     * 读取Excel
     *
     * @throws FileNotFoundException
     * @author Lynch
     */
    private static void readExcel() throws FileNotFoundException {
        try {
            InputStream inputStream=new FileInputStream("D:/aaa.xlsx");
            //读入文件，每一行对应一个 Model，获取 Model 列表
            List<ExcelModel> objectList = EasyExcelUtil.readExcelWithModel(inputStream, ExcelModel.class, ExcelTypeEnum.XLSX);
            for(ExcelModel excelModel: objectList) {
                System.out.println(excelModel);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
