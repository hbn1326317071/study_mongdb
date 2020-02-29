package com.hbn.study.mongodblearning.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.hbn.study.mongodblearning.dao.UploadDAO;
import com.hbn.study.mongodblearning.listener.UploadDataListener;
import com.hbn.study.mongodblearning.pojo.DownloadData;
import com.hbn.study.mongodblearning.pojo.UploadData;
import com.hbn.study.mongodblearning.service.MongoDbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author huangbaoning
 * @Date 2020/2/23 14:58
 */
@Controller
public class TestFileController {
    private static final Logger logger = LoggerFactory.getLogger(TestFileController.class);
    @Autowired
    private UploadDAO uploadDAO;

    /**
     * @Description
     * @Author  huangaoning
     * @Date 2020/2/23  
      * @param response
     * @Return
     * {@link DownloadData}
     */
//    @GetMapping("download")
//    public void download(HttpServletResponse response) throws IOException {
//        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
//        response.setContentType("application/vnd.ms-excel");
//        response.setCharacterEncoding("utf-8");
//        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
//        String fileName = URLEncoder.encode("测试", "UTF-8");
//        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
//        EasyExcel.write(response.getOutputStream(), DownloadData.class).sheet("模板").doWrite(data());
//    }
    @GetMapping("download")
    public void download(HttpServletResponse response) throws IOException {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("测试", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), DownloadData.class).sheet("模板").doWrite(data());
    }

    private List<DownloadData> data() {
        List<DownloadData> list = new ArrayList<DownloadData>();
        for (int i = 0; i < 10; i++) {
            DownloadData data = new DownloadData();
            data.setString("字符串" + 0);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }


//    @RequestMapping("/expor")
//    public String exporExcel(HttpServletResponse response) throws IOException {
//        ExcelWriter writer = null;
//        OutputStream outputStream = response.getOutputStream();
//        try {
//            //添加响应头信息
//            response.setHeader("Content-disposition", "attachment; filename=" + "catagory.xls");
//            response.setContentType("application/msexcel;charset=UTF-8");//设置类型
//            response.setHeader("Pragma", "No-cache");//设置头
//            response.setHeader("Cache-Control", "no-cache");//设置头
//            response.setDateHeader("Expires", 0);//设置日期头
//
//            //实例化 ExcelWriter
//            writer = new ExcelWriter(outputStream, ExcelTypeEnum.XLSX, true);
//
//            //实例化表单
//            Sheet sheet = new Sheet(1, 0, DownloadData.class);
//            sheet.setSheetName("目录");
//
//            //获取数据
//            List<DownloadData> catagoryList = data();
//
//            //输出
//            writer.write(catagoryList, sheet);
//            writer.finish();
//            outputStream.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                response.getOutputStream().close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return "index";
//    }

        @PostMapping("upload")
    @ResponseBody
    public String upload(MultipartFile file) throws IOException {
            logger.error("hello");
            logger.info("hello");
            logger.debug("hello");
            logger.trace("hello");

        EasyExcel.read(file.getInputStream(), UploadData.class, new UploadDataListener(uploadDAO)).sheet().doRead();
        return "success";
    }


}
