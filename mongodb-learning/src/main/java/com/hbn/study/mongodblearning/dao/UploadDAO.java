package com.hbn.study.mongodblearning.dao;

import com.hbn.study.mongodblearning.pojo.UploadData;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description TODO
 * @Author huangbaoning
 * @Date 2020/2/23 15:11
 */
@Repository
public class UploadDAO {
    public void save(List<UploadData> list) {
        // 如果是mybatis,尽量别直接调用多次insert,自己写一个mapper里面新增一个方法batchInsert,所有数据一次性插入
    }
}
