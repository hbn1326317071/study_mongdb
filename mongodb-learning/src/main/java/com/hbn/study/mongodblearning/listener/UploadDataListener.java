package com.hbn.study.mongodblearning.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.hbn.study.mongodblearning.dao.UploadDAO;
import com.hbn.study.mongodblearning.pojo.UploadData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author huangbaoning
 * @Date 2020/2/23 15:09
 */
public class UploadDataListener  extends AnalysisEventListener<UploadData> {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(UploadDataListener.class);

    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 5;
    List<UploadData> list = new ArrayList<UploadData>();
    /**
     * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
     */
    private UploadDAO uploadDAO;

    public UploadDataListener() {
        // 这里是demo，所以随便new一个。实际使用如果到了spring,请使用下面的有参构造函数
        uploadDAO = new UploadDAO();
    }
    public UploadDataListener(UploadDAO uploadDAO) {
        this.uploadDAO = uploadDAO;
    }
    @Override
    public void invoke(UploadData uploadData, AnalysisContext analysisContext) {
        LOGGER.info("解析到一条数据:{}", JSON.toJSONString(uploadData));
        list.add(uploadData);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            list.clear();
        }
    }
    /**
     * 加上存储数据库
     */
    private void saveData() {
        LOGGER.info("{}条数据，开始存储数据库！", list.size());
        uploadDAO.save(list);
        LOGGER.info("存储数据库成功！");
    }
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        LOGGER.info("所有数据解析完成！");
    }
}
