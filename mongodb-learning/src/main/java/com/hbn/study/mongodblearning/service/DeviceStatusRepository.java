package com.hbn.study.mongodblearning.service;

import com.alibaba.fastjson.JSONObject;
import com.hbn.study.mongodblearning.pojo.Book;
import com.mongodb.BasicDBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.BooleanOperators;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository("deviceStatusRepository")
public class DeviceStatusRepository {

    @Autowired
    private MongoTemplate mongoTemplate;


//    /**
//     * 分页查询
//     */
//    public PageImpl<Book> pageDeviceStatusItemByDeviceSerial(String deviceSerial, String collectionName,
//                                                             int pageIndex, int pageSize) {
//        Query query = Query.query(new Criteria());
////                Criteria.where(CONSTS.DEVICE_SERIAL_FIELD).is(deviceSerial));
//
//        // 每页五个
//        // get 5 profiles on a page
//        Pageable pageable = new PageRequest(pageIndex, pageSize);
//        query.with(pageable);
//        // 排序
//        List list = new ArrayList();
//        list.add("id");
//        query.with(new Sort(Sort.Direction.DESC, "id"));
//        // 查询总数
//        int count = (int) mongoOperations.count(query, Book.class, collectionName);
//        List<Book> items = mongoOperations.find(query, Book.class, collectionName);
//        // System.out.println("stories:" + stories.size() + " count:" + count);
//        return (PageImpl<Book>) PageableExecutionUtils.getPage(items, pageable, () -> count);
//    }

    /**
     * 分页查询
     */
//    public void pageQuery() {
//        // limit限定查询2条
//        Query query = Query.query(Criteria.where("user").is("一灰灰blog")).with(Sort.by("age")).limit(2);
//        List<Map> result = mongoTemplate.find(query, Map.class, COLLECTION_NAME);
//        System.out.println("query: " + query + " | limitPageQuery " + result);
//
//
//        // skip()方法来跳过指定数量的数据
//        query = Query.query(Criteria.where("user").is("一灰灰blog")).with(Sort.by("age")).skip(2);
//        result = mongoTemplate.find(query, Map.class, COLLECTION_NAME);
//        System.out.println("query: " + query + " | skipPageQ
    /**
     * 使用pageRequest的方式进行排序
     */
    public void limitQuery(){


        Criteria criteria = new Criteria();
        Query query = new Query();
        Sort.Order order=new Sort.Order(Sort.Direction.ASC, "id");
        PageRequest request = PageRequest.of(3,5,Sort.by(order));
        query.with(Sort.by(order)).skip(10).limit(6);

     List<Book> bookList=   mongoTemplate.find(query,
                Book.class) ;
        System.out.println(JSONObject.toJSONString(bookList));
//        Aggregation agg = Aggregation.newAggregation(
//                Aggregation.match(criteria),  //查询条件
////                Aggregation.group("detail"),
//                Aggregation.project("id", "createTime"),
//                Aggregation.sort(Sort.Direction.ASC, "id"),
//                Aggregation.skip(10),//跳到第几个开始
//                Aggregation.limit(5)//查出多少个数据
//        );

        List<String> details = new ArrayList<String>();
//        AggregationResults<Book> outputType=mongoTemplate.aggregate(agg,"book", Book.class);
//        for (Iterator<Book> iterator = outputType.iterator(); iterator.hasNext();) {
//            Book obj =iterator.next();
//            System.out.println(JSONObject.toJSONString(obj));
//        }
    }

    public void limitQuery1(){
        Criteria criteria = new Criteria();
        Query query = new Query();
        Sort.Order order=new Sort.Order(Sort.Direction.DESC, "id");
        PageRequest request = PageRequest.of(3,5,Sort.by(order));
        List<Book> bookList=   mongoTemplate.find(Query.query(criteria)
                        .with(request) ,
                Book.class) ;
        System.out.println(JSONObject.toJSONString(bookList));
//        Aggregation agg = Aggregation.newAggregation(
//                Aggregation.match(criteria),  //查询条件
////                Aggregation.group("detail"),
//                Aggregation.project("id", "createTime"),
//                Aggregation.sort(Sort.Direction.ASC, "id"),
//                Aggregation.skip(10),//跳到第几个开始
//                Aggregation.limit(5)//查出多少个数据
//        );

        List<String> details = new ArrayList<String>();
//        AggregationResults<Book> outputType=mongoTemplate.aggregate(agg,"book", Book.class);
//        for (Iterator<Book> iterator = outputType.iterator(); iterator.hasNext();) {
//            Book obj =iterator.next();
//            System.out.println(JSONObject.toJSONString(obj));
//        }
    }
}